package com.Okina021.itau_desafio.transacao.controllers;

import com.Okina021.itau_desafio.transacao.dtos.EstatisticaDto;
import com.Okina021.itau_desafio.transacao.services.EstatisticaSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    private EstatisticaSevice estatisticaSevice;

    @GetMapping
    public EstatisticaDto estatistica(@RequestParam(required = false, defaultValue = "60") Integer filterSeconds) {
        return estatisticaSevice.gerarStats(filterSeconds);

    }
}
