package com.itau.unibanco.common.dtos;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransacaoDto {

    @NotNull
    Double valor;

    @NotNull
    OffsetDateTime dataHora;

    public TransacaoDto(@NotNull Double valor, @NotNull OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
    
}
