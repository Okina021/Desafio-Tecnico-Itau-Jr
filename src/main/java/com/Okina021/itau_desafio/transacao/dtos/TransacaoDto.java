package com.Okina021.itau_desafio.transacao.dtos;

import com.Okina021.itau_desafio.transacao.validation.annotations.ValueValidation;
import jakarta.validation.constraints.Past;

import java.time.OffsetDateTime;

public record TransacaoDto(
        @ValueValidation(notNull = true, notNegative = true)
        Double valor,
        @Past
        OffsetDateTime dataHora
) {
}
