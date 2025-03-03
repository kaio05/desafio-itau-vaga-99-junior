package com.itau.unibanco.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.common.dtos.TransacaoDto;

public class TransacaoDtoServiceTest {

    private Memoria memoria = new Memoria();

    private TransacaoDto transacao = new TransacaoDto(100.00, OffsetDateTime.now());
    private TransacaoDto transacao2 = new TransacaoDto(200.00, OffsetDateTime.now());

    @Test
    void testCriarTransacao() {
        memoria.salvarTransacao(transacao);
        memoria.salvarTransacao(transacao2);
        
        assertEquals(memoria.getLista().get(0), transacao);
        assertEquals(memoria.getLista().size(), 2);
    }

    @Test
    void testApagarMemoria() {
        memoria.apagarMemoria();
        assertEquals(memoria.getLista().size(), 0);
    }
}
