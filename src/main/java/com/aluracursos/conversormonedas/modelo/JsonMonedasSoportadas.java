package com.aluracursos.conversormonedas.modelo;

import com.aluracursos.conversormonedas.service.IApiResultado;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonMonedasSoportadas(
                    @JsonAlias("result") String resultado,
                    @JsonAlias("supported_codes") List<List<String>> supportedCodes,
                    @JsonAlias("error-type") String tipoError
                ) implements IApiResultado {

    public List<MonedaSoportada> monedas() {
        if (supportedCodes == null) {
            return List.of(); // lista vacía si no hay códigos en caso de result ≠ "success"
        }

        return supportedCodes.stream()
                .map(par -> new MonedaSoportada(par.get(0), par.get(1)))
                .toList();
    }
}