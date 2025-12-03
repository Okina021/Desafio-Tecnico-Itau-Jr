package com.Okina021.itau_desafio.transacao.services;

import com.Okina021.itau_desafio.transacao.dtos.TransacaoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {

    final List<TransacaoDto> transacoes = new ArrayList<>();

    public void salvar(TransacaoDto transacaoDto) {
        transacoes.add(transacaoDto);
    }

    public void deletar(){
        transacoes.clear();
    }

    public List<TransacaoDto> listar(){
        return transacoes;
    }
}
