package com.itau.unibanco.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.itau.unibanco.common.dtos.TransacaoDto;

@SpringBootTest
public class MemoriaTest {

    @Autowired
    Memoria memoria;

    @Test
    @DisplayName("Should show that the memory is empty")
    void testApagarMemoria() {
        TransacaoDto transacao = new TransacaoDto(10.0, OffsetDateTime.now());

        memoria.salvarTransacao(transacao);

        memoria.apagarMemoria();

        assertThat(memoria.getLista().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Should show that one transaction was saved")
    void testSalvarTransacao() {
        TransacaoDto transacao = new TransacaoDto(10.0, OffsetDateTime.now());

        memoria.salvarTransacao(transacao);

        assertEquals(memoria.getLista().size(), 1);
    }
}
