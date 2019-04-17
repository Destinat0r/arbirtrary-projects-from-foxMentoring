package com.foxminded.divisor_with_period;

import static com.foxminded.divisor_with_period.utils.NumberUtils.*;
import static com.foxminded.divisor_with_period.utils.StringUtils.*;
import com.foxminded.divisor_with_period.utils.*;
import java.util.*;

public class DivisorWithPeriod extends IntegerDivisor {

    public String divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        double result = dividend / (double) divisor;

        if (result == (int) result) {
            return super.divide(dividend, divisor);
        }

        List<Integer> dividendDigits = turnIntToArrayList(dividend);
        List<Integer> interimCalculationsList = makeInterimCalculationsList(dividendDigits, divisor);
        List<Integer> interimNumbersAfterPeriod = generateInterimNumbersUpTo20Sign(interimCalculationsList, divisor);

        interimNumbersAfterPeriod = findNumbersAfterPeriod(interimNumbersAfterPeriod);
        
        if (interimCalculationsList.get(1) == 0) {
            interimCalculationsList = interimNumbersAfterPeriod;
        } else {
            interimCalculationsList.remove(interimCalculationsList.size() - 1);
            interimCalculationsList.addAll(interimNumbersAfterPeriod);
        }

        int lastNumber = interimCalculationsList.get(interimCalculationsList.size() - 1);

        if (lastNumber != 0) {
            interimCalculationsList.add(interimCalculationsList.get(interimCalculationsList.size() - 2) - lastNumber);
        }

        String finalResult = findResult(dividend, divisor).replace("(0)", "");

        int firstMinuend = interimCalculationsList.get(0);
        int firstDeduction = interimCalculationsList.get(1);

        InterimNumbers interimNumbers = new InterimNumbers(dividend, firstMinuend, firstDeduction);

        return makeFirstRow(dividend, divisor, interimNumbers) + makeSecondRow(interimNumbers, finalResult)
                + makeThirdRow(interimNumbers, finalResult)
                + makeRemainingCalculations(interimCalculationsList, interimNumbers);
    }

    private List<Integer> findNumbersAfterPeriod(List<Integer> interimNumbersAfterPeriod) {
        List<Integer> list = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        int previous = 0;

        for (int i = 0; i < interimNumbersAfterPeriod.size(); ++i) {
            int current = interimNumbersAfterPeriod.get(i);
            if (!even.contains(current) && current != 0 && list.size() <= 19) {
                list.add(current);
                if (i % 2 == 0) {
                    even.add(current);
                }
            } else if (current == previous && current != 0) {
                list.add(current);
            } else {
                break;
            }
            previous = current;
        }
        
        return list;
    }

    private List<Integer> generateInterimNumbersUpTo20Sign(List<Integer> interimCalculationsList, int divisor) {
        int remainder = interimCalculationsList.get(interimCalculationsList.size() - 1);

        return makeInterimCalculationsList(makeDigitsAfterPeriod(remainder), divisor);
    }

    private List<Integer> makeDigitsAfterPeriod(int remainder) {
        List<Integer> dividendDigitsAfterPeriod = new ArrayList<>();
        dividendDigitsAfterPeriod.add(remainder);

        for (int i = 0; i < 19; ++i) {
            dividendDigitsAfterPeriod.add(0);
        }

        return dividendDigitsAfterPeriod;
    }

    private String findResult(int dividend, int divisor) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        boolean foundPeriod = false;

        int resultDigit = dividend / divisor;
        int remainder = dividend % divisor;
        int index = 1 + findLength(resultDigit);

        sb.append(resultDigit).append('.');
        map.put(remainder, index++);

        while (!foundPeriod && (sb.length() - sb.indexOf(".")) < 11) {
            resultDigit = remainder * 10 / divisor;
            remainder = remainder * 10 % divisor;

            if (!map.containsKey(remainder)) {
                sb.append(resultDigit);
                map.put(remainder, index++);
            } else {
                foundPeriod = true;
                sb.append(resultDigit);
                sb.insert(map.get(remainder), "(");
                sb.append(")");
            }
        }

        return sb.toString();
    }

    private String makeFirstRow(int dividend, int divisor, InterimNumbers interimNumbers) {
        int firstDeductionLen = interimNumbers.getDeductionLen();
        int spaces = firstDeductionLen - interimNumbers.getDividendLen();
        
        if (interimNumbers.getDividendLen() == firstDeductionLen
                && interimNumbers.getDividend() < interimNumbers.getDeduction()) {
            spaces++;
        } else if ( findLength(divisor) - interimNumbers.getDividendLen() >= 2) {
            spaces++;
        }
        
        return " _" + dividend + makeRowOfSymbols(' ', spaces) + "|" + divisor + "\n";
    }
    
    private String makeRemainingCalculations(List<Integer> interimCalculationsList, InterimNumbers interimNumbers) {
        StringBuilder sb = new StringBuilder();
        int spaces = findSpaces(interimNumbers, interimCalculationsList.get(2));
        int nextNumber = interimNumbers.getDeduction();

        for (int i = 2; i < interimCalculationsList.size(); ++i) {
            int currentNumber = interimCalculationsList.get(i);

            if (currentNumber == 0) {
                spaces--;
            }

            if (i != interimCalculationsList.size() - 1) {
                nextNumber = interimCalculationsList.get(++i);
                
                int lastNumbersLengthDiff = findLength(currentNumber) - findLength(nextNumber);
                sb.append(makeRowOfSymbols(' ', spaces++)).append('_').append(currentNumber).append("\n")
                        .append(makeRowOfSymbols(' ', spaces + lastNumbersLengthDiff)).append(nextNumber).append("\n")
                        .append(makeRowOfSymbols(' ', spaces + lastNumbersLengthDiff))
                        .append(makeRowOfSymbols('-', findLength(nextNumber))).append("\n");
                
                spaces = changeSpaces(spaces, currentNumber, nextNumber, interimCalculationsList.get(i + 1));
            } else {
                if (findLength(nextNumber) == findLength(currentNumber) && findLength(currentNumber) != 2) {
                    spaces += 1;
                }
                sb.append(makeRowOfSymbols(' ', spaces + (findLength(nextNumber) - findLength(currentNumber))))
                        .append(currentNumber).append("\n");
            }
        }

        return sb.toString();
    }
    
    private int findSpaces(InterimNumbers interimNumbers, int firstFromList) {
        int firstDifference = interimNumbers.getMinuend() - interimNumbers.getDeduction();
        int spaces = 2;
        if (interimNumbers.getMinuendLen() == 1 && interimNumbers.getDeductionLen() == 1
                || interimNumbers.getDividendLen() == 1 && firstDifference >= 10 && firstDifference < 100 
                || findLength(firstFromList) == 3 && interimNumbers.getDividendLen() != 2) {
            spaces = 1;
        } else if(interimNumbers.getMinuendLen() >= 6) {
            spaces = 4;
        }
        
        return spaces;
    }
    
    private int changeSpaces(int spaces, int currentNumber, int nextNumber, int afterNext) {
        if (currentNumber < 10 || findLength(currentNumber) == findLength(nextNumber) && findLength(currentNumber) == 2
                && findLength(currentNumber - nextNumber) == 2 && findLength(afterNext) == 3) {
            spaces--;
        }
        if (currentNumber >= 100 && currentNumber - nextNumber < 10 || currentNumber == nextNumber) {
            spaces += 1;
        }
        
        return spaces;
    }
}
