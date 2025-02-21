package com.itau.unibanco.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;
import com.itau.unibanco.models.Transacao;

@Configuration
public class Memoria {

    List<Transacao> transacoes = new ArrayList<>();

    @Bean
    public Memoria memoria() {
        return new Memoria();
    }

    public void salvarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }
    
}
