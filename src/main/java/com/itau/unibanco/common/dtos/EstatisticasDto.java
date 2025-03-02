package com.itau.unibanco.common.dtos;

import lombok.Data;

@Data
public class EstatisticasDto {
    public int count;
    public Double sum, avg, min, max;
    
    public EstatisticasDto(int count, Double sum, Double avg, Double min, Double max) {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.min = min;
        this.max = max;
    }

    
}
