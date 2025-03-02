package com.itau.unibanco.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itau.unibanco.common.dtos.EstatisticasDto;
import com.itau.unibanco.services.EstatisticasService;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticasService estatisticasService;
    
    @GetMapping
    public EstatisticasDto getEstatisticas() {
        return estatisticasService.calcularEstatisticas();
    }
}
