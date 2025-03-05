package com.itau.unibanco.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.common.dtos.EstatisticasDto;
import com.itau.unibanco.common.dtos.TransacaoDto;

@SpringBootTest
public class EstatisticasServiceTest {

    @Autowired
    private Memoria memoria;

    @Autowired
    private EstatisticasService estatisticasService;

    @Autowired
    private TransacaoService transacaoService;

    @Test
    @DisplayName("Return 0 for all fields if memory is empty")
    void testCalcularEstatisticasCase1() {
        
        assertThat(memoria.getLista().isEmpty()).isTrue();
        EstatisticasDto nullStatistics = new EstatisticasDto(0, 0.0, 0.0, 0.0, 0.0);
        assertEquals(estatisticasService.calcularEstatisticas(), nullStatistics);
    }

    @Test
    @DisplayName("Return not null statistics if the memory is not empty")
    void testCalcularEstatisticasCase2() {
        
        TransacaoDto transacao = new TransacaoDto(100.0, OffsetDateTime.now());
        transacaoService.criarTransacao(transacao);
        assertThat(memoria.getLista().isEmpty()).isFalse();
        EstatisticasDto nullStatistics = new EstatisticasDto(0, 0.0, 0.0, 0.0, 0.0);
        assertNotEquals(estatisticasService.calcularEstatisticas(), nullStatistics);
    }
}
