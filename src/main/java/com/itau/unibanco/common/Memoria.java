package com.itau.unibanco.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itau.unibanco.common.dtos.TransacaoDto;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("singleton")
public class Memoria {

    List<TransacaoDto> transacoes = new ArrayList<>();
    
    public Memoria memoria() {
        return new Memoria();
    }

    public void salvarTransacao(TransacaoDto transacao) {
        transacoes.add(transacao);
    }

    public void apagarMemoria() {
        transacoes.clear();
    }

    public List<TransacaoDto> getLista() {
        return transacoes;
    }
    
}
