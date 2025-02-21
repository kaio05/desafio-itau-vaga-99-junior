package com.itau.unibanco.models;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Transacao {

    @NotNull
    Double valor;

    @NotNull
    OffsetDateTime dataHora;

    public Transacao(@NotNull Double valor, @NotNull OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
    
}
