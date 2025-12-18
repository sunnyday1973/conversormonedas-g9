![Alura + One](./img/alura.png)

# Challenge ONE  
## Practicando con Java: Conversor de Monedas

Este proyecto es un conversor de monedas en Java que consume la API gratuita **Exchange Rate API** para obtener tasas de cambio en tiempo real, proporcionando información precisa y actualizada para las conversiones entre distintas divisas.

---

## Clave de la API

Para integrar la API en la aplicación es necesario disponer de una **API key** propia.

1. Accede a la página de Exchange Rate API:  
   https://www.exchangerate-api.com/
2. Regístrate con tu correo electrónico.
3. Recibirás tu clave de acceso en el correo proporcionado.
4. Crea una variable de entorno llamada `EXCHANGERATE_APIKEY` con el valor de la clave obtenida.

---

## Crear variable de entorno en Windows (interfaz gráfica)

1. Abrir el **Panel de control**.  
2. Ir a **Sistema y seguridad**.  
3. Seleccionar **Sistema**.  
4. Hacer clic en **Configuración avanzada del sistema**.  
5. Presionar **Variables de entorno…**.  
6. En la sección correspondiente (usuario o sistema), hacer clic en **Nueva…** e ingresar:
   - **Nombre de la variable**: `EXCHANGERATE_APIKEY`  
   - **Valor de la variable**: `su_api_key`

---

## Crear variable de entorno en macOS (terminal)

En una terminal:

`echo 'export EXCHANGERATE_APIKEY=su_api_key' >> ~/.zshrc`


`source ~/.zshrc`

Sustituye `su_api_key` por la clave real que recibiste por correo.

---

## Crear variable de entorno en GitHub (Codespaces Secret)

1. Ir al repositorio en GitHub.  
2. Abrir **Settings**.  
3. Ir a **Secrets and variables** → **Codespaces**.  
4. Hacer clic en **New repository secret**.  
5. Definir:
   - **Name**: `EXCHANGERATE_APIKEY`  
   - **Value**: `su_api_key`

---

## Verificar que la variable existe

- En **Windows** (PowerShell o CMD):

`echo %EXCHANGERATE_APIKEY%`

- En **macOS / Linux** (terminal):

`echo $EXCHANGERATE_APIKEY`

---

## Compilar y ejecutar (Maven)

`./mvnw spring-boot:run`

O con Maven global

`mvn spring-boot:run`

---

## Funcionalidades

Al ejecutar la aplicación se mostrará el siguiente menú en consola:

1 - Ver valores de las monedas

*Consulta los tipos de cambio de una divisa base vs todas las demás.*

*Endpoint: https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{BASE_CODE}*


2 - Ver valor de cambio de una moneda a otra

*Obtiene el tipo de cambio entre dos divisas específicas.*

*Endpoint: https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}*

3 - Calcular monto de cambio de una moneda a otra

*Convierte un monto de una divisa origen a una divisa destino.*

*Endpoint: https://v6.exchangerate-api.com/v6/{API_KEY}/pair/{FROM}/{TO}/{AMOUNT}*

4 - Ver códigos de monedas

*Lista todos los códigos ISO 4217 soportados por la API.*

*Endpoint: https://v6.exchangerate-api.com/v6/{API_KEY}/codes*

\-----------

0 - Salir

