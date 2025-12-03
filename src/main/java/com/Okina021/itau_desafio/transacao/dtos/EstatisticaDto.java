package com.Okina021.itau_desafio.transacao.dtos;

import java.util.DoubleSummaryStatistics;

public record EstatisticaDto(
        Long count,
        Double sum,
        Double avg,
        Double min,
        Double max
) {

    public static EstatisticaDto toStats(DoubleSummaryStatistics count) {
        return new EstatisticaDto(count.getCount(), count.getSum(), count.getAverage(), count.getMin() > 0 ? count.getMin() : 0, count.getMax() > 0 ? count.getMax() : 0);
    }
}
