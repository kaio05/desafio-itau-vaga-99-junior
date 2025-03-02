package com.itau.unibanco.services;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.common.dtos.EstatisticasDto;
import com.itau.unibanco.models.Transacao;

@Service
public class EstatisticasService {
    
    @Autowired
    private Memoria memoria;

    Integer getCount(List<Transacao> lista) {
        return lista.size();
    }

    Double getSum(List<Double> valores) {
        return valores.stream().reduce(0.0, Double::sum);
    }

    Double getAvg(List<Transacao> lista, List<Double> valores) {
        return getSum(valores) / getCount(lista);
    }

    Double getMin(List<Double> valores) {
        return valores.stream().min(Double::compare).get();
    }

    Double getMax(List<Double> valores) {
        return valores.stream().max(Double::compare).get();
    }

    public EstatisticasDto calcularEstatisticas() {
        
        List<Transacao> recentes = memoria.getLista().stream().filter(i -> Duration.between(i.getDataHora(), OffsetDateTime.now()).getSeconds() <= 60).toList();
        
        if(recentes.size() == 0) {
            EstatisticasDto estatisticas = new EstatisticasDto(0, 0.0, 0.0, 0.0, 0.0);
            return estatisticas;
        }

        List<Double> valoresRecentes = recentes.stream().map(i -> i.getValor()).toList();

        EstatisticasDto estatisticas = new EstatisticasDto(getCount(recentes), getSum(valoresRecentes), getAvg(recentes, valoresRecentes), getMin(valoresRecentes), getMax(valoresRecentes));
        return estatisticas;
    }
}
