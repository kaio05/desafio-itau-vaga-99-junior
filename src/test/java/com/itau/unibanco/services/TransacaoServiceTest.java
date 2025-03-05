package com.itau.unibanco.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.common.dtos.TransacaoDto;

@SpringBootTest
public class TransacaoServiceTest {

    @Mock
    private Memoria memoria;

    @Autowired
    @InjectMocks
    private TransacaoService transacaoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should not create transaction because it happens in the future")
    void testCriarTransacaoCase1() {
        TransacaoDto transacao = new TransacaoDto(100.0, OffsetDateTime.MAX);
        
        Assertions.assertEquals(transacaoService.criarTransacao(transacao), ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null));

        verify(memoria, times(0)).salvarTransacao(any());
    }

    @Test
    @DisplayName("Should not create transaction because it's value is negative")
    void testCriarTransacaoCase2() {
        TransacaoDto transacao = new TransacaoDto(-100.0, OffsetDateTime.now());
        
        Assertions.assertEquals(transacaoService.criarTransacao(transacao), ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null));
        
        verify(memoria, times(0)).salvarTransacao(any());
    }

    @Test
    @DisplayName("Should successfully create transaction")
    void testCriarTransacaoCase3() {
        TransacaoDto transacao = new TransacaoDto(100.0, OffsetDateTime.now());

        Assertions.assertEquals(transacaoService.criarTransacao(transacao), ResponseEntity.status(HttpStatus.CREATED).body(null));

        verify(memoria, times(1)).salvarTransacao(any());
    }

    @Test
    @DisplayName("Should delete memory")
    void testeApagarMemoria() {
        TransacaoDto transacao = new TransacaoDto(100.0, OffsetDateTime.now());

        transacaoService.criarTransacao(transacao);
        transacaoService.apagarMemoria();

        verify(memoria, times(1)).salvarTransacao(any());
        verify(memoria, times(1)).apagarMemoria();
    }
}
