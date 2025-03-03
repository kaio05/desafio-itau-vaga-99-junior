package com.itau.unibanco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.unibanco.common.dtos.TransacaoDto;
import com.itau.unibanco.services.TransacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDto> criarTransacao(@Valid @RequestBody TransacaoDto transacao, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            
        return transacaoService.criarTransacao(transacao);
    }

    @DeleteMapping
    public ResponseEntity<TransacaoDto> excluirTransacoes() {
        transacaoService.apagarMemoria();;
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
