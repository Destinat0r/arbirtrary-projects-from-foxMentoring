package com.foxminded.divisor_with_period;

import static com.foxminded.divisor_with_period.utils.NumberUtils.*;
import static com.foxminded.divisor_with_period.utils.StringUtils.*;

import java.util.*;

import com.foxminded.divisor_with_period.utils.InterimNumbers;

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

        return makeFirstRow(dividend, divisor) + makeSecondRow(interimNumbers, result + "")
                + makeThirdRow(interimNumbers, result + "")
                + makeRemainingCalculations(interimCalculationsList, interimNumbers);
    }

    List<Integer> turnIntToArrayList(int number) {
        String temp = Integer.toString(number);
        List<Integer> list = new ArrayList<>();
       
        for (int i = 0; i < temp.length(); i++) {
            list.add(temp.charAt(i) - '0');
        }
        
        return list;
    }

    List<Integer> makeInterimCalculationsList(List<Integer> digits, int divisor) {
        int remainder = 0;
        Iterator<Integer> iter = digits.iterator();
        List<Integer> list = new ArrayList<>();

        while (iter.hasNext()) {
            int minuend = findSuitableMinuend(remainder, divisor, iter);
            list.add(minuend);
            int digitOfResult = minuend / divisor;
            int deduction = digitOfResult * divisor;
            remainder = minuend - deduction;
            list.add(deduction);
        }
        list.add(remainder);

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

    String makeSecondRow(InterimNumbers interimNumbers, String result) {
        int spacesBeforeFirstMinuend = interimNumbers.getDividendLen() - interimNumbers.getMinuendLen();

        return "  " + makeRowOfSymbols(' ', interimNumbers.getMinuendLen() - interimNumbers.getDeductionLen())
                + interimNumbers.getDeduction() + makeRowOfSymbols(' ', spacesBeforeFirstMinuend) + "|"
                + makeRowOfSymbols('-', result.length()) + "\n";
    }

    String makeThirdRow(InterimNumbers interimNumbers, String result) {
        return "  " + makeRowOfSymbols(' ', interimNumbers.getMinuendLen() - interimNumbers.getDeductionLen())
                + makeRowOfSymbols('-', interimNumbers.getDeductionLen())
                + makeRowOfSymbols(' ', interimNumbers.getDividendLen() - interimNumbers.getMinuendLen()) + "|" + result
                + "\n";
    }

    private String makeRemainingCalculations(List<Integer> interimCalculationsList, InterimNumbers interimNumbers) {
        StringBuilder sb = new StringBuilder();
        int firstDifference = interimNumbers.getMinuend() - interimNumbers.getDeduction();
        int spaces = 2;

        if (firstDifference > 0 && firstDifference < 10 && interimNumbers.getDeduction() != 0) {
            spaces = 1;
        }

        int nextNumber = interimNumbers.getDeduction();

        for (int i = 2; i < interimCalculationsList.size(); ++i) {
            int currentNumber = interimCalculationsList.get(i);

            if (i != interimCalculationsList.size() - 1) {
                nextNumber = interimCalculationsList.get(++i);

                sb.append(makeRowOfSymbols(' ', spaces++)).append('_').append(currentNumber).append("\n")
                        .append(makeRowOfSymbols(' ', spaces)).append(nextNumber).append("\n")
                        .append(makeRowOfSymbols(' ', spaces)).append(makeRowOfSymbols('-', findLength(currentNumber)))
                        .append("\n");
            } else {
                sb.append(makeRowOfSymbols(' ', spaces + (findLength(nextNumber) - findLength(currentNumber))))
                        .append(currentNumber).append("\n");
            }
        }
        
        return sb.toString();
    }
}
