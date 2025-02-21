package com.itau.unibanco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.unibanco.models.Transacao;
import com.itau.unibanco.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public void criarTransacao(@RequestBody Transacao transacao) {
        transacaoService.criarTransacao(transacao);
    }
}
