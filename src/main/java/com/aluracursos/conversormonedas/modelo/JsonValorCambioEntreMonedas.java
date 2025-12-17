package com.aluracursos.conversormonedas.modelo;

import com.aluracursos.conversormonedas.service.IApiResultado;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonValorCambioEntreMonedas(
                @JsonAlias("result") String resultado,
                @JsonAlias("base_code") String monedaOrigen,
                @JsonAlias("target_code") String monedaDestino,
                @JsonAlias("conversion_rate") Double valorCambio,
                @JsonAlias("error-type") String tipoError
            ) implements IApiResultado {}
