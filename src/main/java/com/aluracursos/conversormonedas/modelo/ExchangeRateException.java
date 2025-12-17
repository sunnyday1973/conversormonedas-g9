package com.aluracursos.conversormonedas.modelo;

public class ExchangeRateException extends RuntimeException {
    private final String tipoError;

    public ExchangeRateException(String mensaje, String tipoError) {
        super(mensaje);
        this.tipoError = tipoError;
    }

    public String getTipoError() {
        return tipoError;
    }
}
