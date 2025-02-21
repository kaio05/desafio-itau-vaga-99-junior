package com.itau.unibanco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itau.unibanco.common.Memoria;
import com.itau.unibanco.models.Transacao;

@Service
public class TransacaoService {

    @Autowired
    private Memoria memoria;

    public void criarTransacao(Transacao transacao) {
        memoria.salvarTransacao(transacao);
    }

    public void apagarMemoria() {
        memoria.apagarMemoria();
    }

}
