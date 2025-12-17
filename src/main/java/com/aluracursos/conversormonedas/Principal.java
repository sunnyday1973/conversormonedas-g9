package com.aluracursos.conversormonedas;

import com.aluracursos.conversormonedas.modelo.*;
import com.aluracursos.conversormonedas.service.ConsumirApi;
import com.aluracursos.conversormonedas.service.ConvierteDatos;
import com.aluracursos.conversormonedas.validator.ApiResponseValidator;
import lombok.Data;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal de la aplicación de conversión de monedas.
 * Presenta un menú en consola y delega en la API ExchangeRate-API
 * las consultas de tipos de cambio y códigos de monedas.
 *
 * Documentación oficial: https://www.exchangerate-api.com/docs
 */
@Data
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumirApi api = new ConsumirApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private int opcion = -1;

    /**
     * Muestra el menú principal en consola y procesa las opciones del usuario.
     *
     * Opciones disponibles:
     * 1 - Ver valores de conversión de una divisa base frente a todas las demás.
     * 2 - Ver valor de cambio entre dos divisas (par de monedas).
     * 3 - Calcular el monto convertido entre dos divisas a partir de un importe.
     * 4 - Listar todos los códigos de monedas soportados.
     *
     * Para códigos ISO 4217 soportados:
     * https://www.exchangerate-api.com/docs/supported-currencies
     */
    public void mostrarMenu() {
        while (opcion != 0) {
            var menu = """
                    \n
                    1 - Ver valores de las monedas
                    2 - Ver valor de cambio de una moneda a otra
                    3 - Calcular monto de cambio de una moneda a otra
                    4 - Ver códigos de monedas
                    -----------
                    0 - Salir
                    
                    * Para mas información sobre códigos consulte 
                    https://www.exchangerate-api.com/docs/supported-currencies
                    """;
            System.out.println(menu);

            try {
                opcion = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opción inválida");
                continue;
            } finally {
                teclado.nextLine();
            }

            try {
                switch (opcion) {
                    case 1 -> valorMoneda();
                    case 2 -> valorCambioEntreMonedas();
                    case 3 -> calcularMontoDeCambio();
                    case 4 -> codigosMonedas();
                    case 0 -> System.out.println("Cerrando la aplicación...");
                    default -> System.out.println("Opción inválida");
                }
            } catch (ExchangeRateException e) {
                System.out.println("Error al consultar la API: " + e.getMessage());
            }
        }
    }

    /**
     * Consulta y muestra los valores de conversión de una divisa base
     * frente a todas las demás monedas soportadas por la API.
     *
     * Endpoint usado (ejemplo):
     *   GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
     */
    private void valorMoneda() {
        System.out.print("""
                            Ingrese el código de divisa base para consultar
                            (Por ej., en ISO 4217: CLP, USD, EUR)
                            """);
        String moneda = teclado.nextLine();
        var json = api.consultarApi("/latest/" + moneda.toUpperCase());
        var datos = conversor.obtenerDatos(json, JsonValorMoneda.class);
        ApiResponseValidator.validarRespuesta(datos);
        var valoresCambio = datos.valoresCambio();

        valoresCambio.forEach((codigo, valor) ->
                                    System.out.println("Moneda: " + codigo
                                                    + ", Valor cambio: " + valor)
        );
    }

    /**
     * Consulta y muestra el tipo de cambio entre dos divisas (sin monto).
     *
     * Endpoint usado (ejemplo):
     *   GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP
     */
    private void valorCambioEntreMonedas() {
        System.out.print("""
                            Ingrese el código de divisa origien
                            """);
        String monedaOrigen = teclado.nextLine();
        System.out.print("""
                            Ingrese el código de divisa destino
                            """);
        String monedaDestino = teclado.nextLine();
        var json = api.consultarApi("/pair/" + monedaOrigen.toUpperCase() + "/" + monedaDestino.toUpperCase());
        var datos = conversor.obtenerDatos(json, JsonValorCambioEntreMonedas.class);
        ApiResponseValidator.validarRespuesta(datos);
        System.out.println("Valor conversion de moneda " + monedaOrigen +  " a " + monedaDestino +  ": " + datos.valorCambio());
    }

    /**
     * Calcula el monto convertido entre dos divisas a partir de un importe
     * en la moneda origen y muestra tanto el tipo de cambio como el resultado.
     *
     * Endpoint usado (ejemplo):
     *   GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
     */
    private void calcularMontoDeCambio() {
        System.out.print("""
                            Ingrese el código de divisa origien
                            """);
        String monedaOrigen = teclado.nextLine();
        System.out.print("""
                            Ingrese el código de divisa destino
                            """);
        String monedaDestino = teclado.nextLine();
        System.out.print("""
                            Ingrese el monto de divisa origen
                            """);
        Double montoOrigen = teclado.nextDouble();
        teclado.nextLine();
        var json = api.consultarApi("/pair/" + monedaOrigen.toUpperCase() + "/" + monedaDestino.toUpperCase() + "/" + montoOrigen);
        var datos = conversor.obtenerDatos(json, JsonMontoConversion.class);
        ApiResponseValidator.validarRespuesta(datos);

        System.out.println("Valor moneda " + monedaOrigen +  ": " + datos.valorCambio());
        System.out.println("Monto convertido en " + monedaDestino +  ": " + datos.montoConvertido());
    }

    /**
     * Obtiene y muestra todos los códigos de monedas soportados por la API,
     * junto con el nombre descriptivo de cada moneda.
     *
     * Endpoint usado:
     *   GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/codes
     */
    private void codigosMonedas() {
        var json = api.consultarApi("/codes");
        var datos = conversor.obtenerDatos(json, JsonMonedasSoportadas.class);
        ApiResponseValidator.validarRespuesta(datos);
        var monedas = datos.monedas();

        monedas.forEach(m -> System.out.println("Moneda: " + m.nombreMoneda()
                        + ", Código: " + m.codigo()
                )
        );
    }
}
