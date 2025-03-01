package com.itau.unibanco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.unibanco.models.Transacao;
import com.itau.unibanco.services.TransacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@Valid @RequestBody Transacao transacao) {
        transacaoService.criarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @DeleteMapping
    public ResponseEntity<Transacao> excluirTransacoes() {
        transacaoService.apagarMemoria();;
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
