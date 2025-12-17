package com.aluracursos.conversormonedas.modelo;

import com.aluracursos.conversormonedas.service.IApiResultado;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonMontoConversion(
                @JsonAlias("result") String resultado,
                @JsonAlias("conversion_rate") Double valorCambio,
                @JsonAlias("conversion_result") Double montoConvertido,
                @JsonAlias("error-type") String tipoError
            ) implements IApiResultado {}
