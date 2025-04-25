package com.challItau.demo.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse
{
    private Long count;
    private Double sum;
    private Double avg;
    private Double max;
 
    public StatisticsResponse(DoubleSummaryStatistics stats)
    {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.max = stats.getMax();
    }

    public Long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMax() {
        return max;
    }
}
