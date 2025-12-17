package com.aluracursos.conversormonedas.modelo;

import com.aluracursos.conversormonedas.service.IApiResultado;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonValorMoneda(
                    @JsonAlias("result") String resultado,
                    @JsonAlias("base_code") String moneda,
                    @JsonAlias("conversion_rates") Map<String, Double> valoresCambio,
                    @JsonAlias("error-type") String tipoError
            ) implements IApiResultado {}
