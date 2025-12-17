package com.aluracursos.conversormonedas.validator;

import com.aluracursos.conversormonedas.modelo.ExchangeRateException;
import com.aluracursos.conversormonedas.service.IApiResultado;

public class ApiResponseValidator {

    public static <T extends IApiResultado> T validarRespuesta(T datos) {
        if ("success".equalsIgnoreCase(datos.resultado())) {
            return datos;
        }

        String tipoError = datos.tipoError();
        String mensajeDescriptivo = switch (tipoError) {
            case "unsupported-code" ->
                    "Código de moneda no soportado por la API.";
            case "malformed-request" ->
                    "La solicitud a la API tiene un formato incorrecto.";
            case "invalid-key" ->
                    "La API key no es válida.";
            case "inactive-account" ->
                    "La cuenta de la API está inactiva o el email no está confirmado.";
            case "quota-reached" ->
                    "Se alcanzó el límite de solicitudes permitido por el plan.";
            default ->
                    "Error desconocido al llamar a la API de tipo: " + tipoError;
        };

        throw new ExchangeRateException(mensajeDescriptivo, tipoError);
    }
}
