package com.utilities.bank_statement_analyzer;

class SummaryStatistics {
    private final double sum;
    private final double max;
    private final double min;
    private final double average;

    SummaryStatistics(final double sum, final double max, final double min, final double average) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.average = average;
    }

    double getSum() {
        return sum;
    }

    double getMax() {
        return max;
    }

    double getMin() {
        return min;
    }

    double getAverage() {
        return average;
    }
}
