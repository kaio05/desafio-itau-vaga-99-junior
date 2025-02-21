package com.itau.unibanco.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.models.Transacao;

public class TransacaoServiceTest {

    private Memoria memoria = new Memoria();

    private Transacao transacao = new Transacao(100.00f, OffsetDateTime.now());
    private Transacao transacao2 = new Transacao(200.00f, OffsetDateTime.now());

    @Test
    void testCriarTransacao() {
        memoria.salvarTransacao(transacao);
        memoria.salvarTransacao(transacao2);
        
        assertEquals(memoria.getLista().get(0), transacao);
        assertEquals(memoria.getLista().size(), 2);
    }
}
