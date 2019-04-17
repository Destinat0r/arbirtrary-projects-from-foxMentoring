package com.foxminded.integer_divisor;

import static com.foxminded.integer_divisor.utils.NumberUtils.*;
import static com.foxminded.integer_divisor.utils.StringUtils.*;

import java.util.*;

public class IntegerDivisor {

    public String divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        int result = dividend / divisor;

        List<Integer> dividendDigits = turnIntToArrayList(dividend);
        List<Integer> interimCalculationsList = makeInterimCalculationsList(dividendDigits, divisor);

        int firstMinuend = interimCalculationsList.get(0);
        int firstDeduction = interimCalculationsList.get(1);

        InterimNumbers interimNumbers = new InterimNumbers(dividend, firstMinuend, firstDeduction);

        String output = makeFirstRow(dividend, divisor) + makeSecondRow(interimNumbers, result)
                + makeThirdRow(interimNumbers, result)
                + makeRemainingCalculations(interimCalculationsList, interimNumbers);

        return output;
    }

    private class InterimNumbers {
        private int dividend;
        private int minuend;
        private int deduction;

        InterimNumbers(int dividend, int minuend, int deduction) {
            super();
            this.dividend = dividend;
            this.minuend = minuend;
            this.deduction = deduction;
        }

        int getMinuendLen() {
            return findLength(minuend);
        }

        int getDividendLen() {
            return findLength(dividend);
        }

        int getDeductionLen() {
            return findLength(deduction);
        }
    }

    private List<Integer> turnIntToArrayList(int number) {
        String temp = Integer.toString(number);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.charAt(i) - '0');
        }
        return list;
    }

    private List<Integer> makeInterimCalculationsList(List<Integer> digits, int divisor) {
        int remainer = 0;
        Iterator<Integer> iter = digits.iterator();
        List<Integer> list = new ArrayList<>();

        while (iter.hasNext()) {
            int minuend = findSuitableMinuend(remainer, divisor, iter);
            list.add(minuend);
            int digitOfResult = minuend / divisor;
            int deduction = digitOfResult * divisor;
            remainer = minuend - deduction;
            list.add(deduction);
        }
        list.add(remainer);

        return list;
    }

    private int findSuitableMinuend(int minuend, int divisor, Iterator<Integer> digits) {
        while (minuend < divisor && digits.hasNext()) {
            minuend = minuend * 10 + digits.next();
        }

        return minuend;
    }

    private String makeFirstRow(int dividend, int divisor) {
        return " _" + dividend + "|" + divisor + "\n";
    }

    private String makeSecondRow(InterimNumbers interimNumbers, int result) {
        int spacesBeforeFirstMinuend = interimNumbers.getDividendLen() - interimNumbers.getMinuendLen();

        String output = "  " + makeRowOfSymbols(' ', interimNumbers.getMinuendLen() - interimNumbers.getDeductionLen())
                + interimNumbers.deduction + makeRowOfSymbols(' ', spacesBeforeFirstMinuend) + "|"
                + makeRowOfSymbols('-', findLength(result)) + "\n";
        return output;
    }

    private String makeThirdRow(InterimNumbers interimNumbers, int result) {
        String output = "  " + makeRowOfSymbols(' ', interimNumbers.getMinuendLen() - interimNumbers.getDeductionLen())
                + makeRowOfSymbols('-', interimNumbers.getDeductionLen())
                + makeRowOfSymbols(' ', interimNumbers.getDividendLen() - interimNumbers.getMinuendLen()) + "|" + result
                + "\n";
        return output;
    }

    private String makeRemainingCalculations(List<Integer> interimCalculationsList, InterimNumbers interimNumbers) {
        StringBuilder stringBuilder = new StringBuilder();
        int firstDifference = interimNumbers.minuend - interimNumbers.deduction;
        int spaces = 2;

        if (firstDifference > 0 && firstDifference < 10 && interimNumbers.deduction != 0) {
            spaces = 1;
        }

        int nextNumber = interimNumbers.deduction;

        for (int i = 2; i < interimCalculationsList.size(); ++i) {
            int currentNumber = interimCalculationsList.get(i);

            if (i != interimCalculationsList.size() - 1) {
                nextNumber = interimCalculationsList.get(++i);

                stringBuilder.append(makeRowOfSymbols(' ', spaces++) + '_' + currentNumber + "\n"
                        + makeRowOfSymbols(' ', spaces) + nextNumber + "\n" + makeRowOfSymbols(' ', spaces)
                        + makeRowOfSymbols('-', findLength(currentNumber)) + "\n");
            } else {
                stringBuilder.append(makeRowOfSymbols(' ', spaces + (findLength(nextNumber) - findLength(currentNumber)))
                                + currentNumber + "\n");
            }
        }

        return stringBuilder.toString();
    }
}
