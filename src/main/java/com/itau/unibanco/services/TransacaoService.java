package com.itau.unibanco.services;

import java.time.Duration;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.common.dtos.TransacaoDto;

@Service
public class TransacaoService {

    @Autowired
    private Memoria memoria;

    public ResponseEntity<TransacaoDto> criarTransacao(TransacaoDto transacao) {
        if (Duration.between(transacao.getDataHora(), OffsetDateTime.now()).getSeconds() < 0 || transacao.getValor() < 0) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
        }
        memoria.salvarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    public void apagarMemoria() {
        memoria.apagarMemoria();
    }

}
