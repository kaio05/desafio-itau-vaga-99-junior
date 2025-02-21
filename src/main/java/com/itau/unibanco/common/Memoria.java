package com.itau.unibanco.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import com.itau.unibanco.models.Transacao;

@Component
@Scope("singleton")
public class Memoria {

    List<Transacao> transacoes = new ArrayList<>();
    
    public Memoria memoria() {
        return new Memoria();
    }

    public void salvarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public List<Transacao> getLista() {
        return transacoes;
    }
    
}
