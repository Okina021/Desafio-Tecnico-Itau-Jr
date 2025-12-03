package com.Okina021.itau_desafio.transacao.services;

import com.Okina021.itau_desafio.transacao.dtos.EstatisticaDto;
import com.Okina021.itau_desafio.transacao.dtos.TransacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
public class EstatisticaSevice {

    @Autowired
    private TransacaoService transacaoService;

    public EstatisticaDto gerarStats(Integer filterSeconds){
        List<TransacaoDto> transacaoDtos = transacaoService.listar();
        OffsetDateTime dateFilter = OffsetDateTime.now().minusSeconds(filterSeconds);

        List<TransacaoDto> filtered = transacaoDtos.stream()
                .filter(t -> t.dataHora().isAfter(dateFilter))
                .toList();

        DoubleSummaryStatistics stats =
                filtered.stream().mapToDouble(TransacaoDto::valor).summaryStatistics();

        return EstatisticaDto.toStats(stats);
    }
}
