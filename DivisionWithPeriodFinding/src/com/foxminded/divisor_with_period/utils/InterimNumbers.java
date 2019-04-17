package com.foxminded.divisor_with_period.utils;

import static com.foxminded.divisor_with_period.utils.NumberUtils.*;

public class InterimNumbers {
    
    final int dividend;
    final int minuend;
    final int deduction;

    public InterimNumbers(int dividend, int minuend, int deduction) {
        super();
        this.dividend = dividend;
        this.minuend = minuend;
        this.deduction = deduction;
    }

    public int getDividend() {
        return dividend;
    }

    public int getMinuend() {
        return minuend;
    }

    public int getDeduction() {
        return deduction;
    }
    
    public int getMinuendLen() {
        return findLength(minuend);
    }

    public int getDividendLen() {
        return findLength(dividend);
    }

    public int getDeductionLen() {
        return findLength(deduction);
    }
}
