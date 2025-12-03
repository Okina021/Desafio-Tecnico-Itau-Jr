package com.Okina021.itau_desafio.transacao.controllers;

import com.Okina021.itau_desafio.transacao.dtos.TransacaoDto;
import com.Okina021.itau_desafio.transacao.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deletar(){
        transacaoService.deletar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvarTransacao(@Valid @RequestBody TransacaoDto transacaoDto){
        transacaoService.salvar(transacaoDto);
    }

}
