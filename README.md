![Alura + One](./img/alura.png)

# Challenge ONE
# Practicando con Java: Challenge Conversor de Monedas

Se hace llamada a la API gratuita "Exchange Rate API" que entrega las tasas de cambio en tiempo real, proporcionando información precisa y 
actualizada para nuestras conversiones de moneda. 

## Clave de la API
Para su integracion, es necesario tener la clave de esa API.
Para obtener esa clave, es necesario realizar un registro inicial ingresando un correo electrónico. 
Después de esto, recibirás una clave en el correo electrónico proporcionado y estará lista para su uso. Accede al [enlace](https://www.exchangerate-api.com/) 
y realiza su registro.
Una vez, obtenida la llave, crea la variable del sistema con nombre EXCHANGERATE_APIKEY y valor obtenido de la llave.

## Crear una variable de entorno vía interfaz de Windows
1. Abrir el Panel de control
2. Ir a Sistema y seguridad
3. Seleccionar Sistema
4. Hacer clic en Configuración avanzada del sistema
5. Presionar Variables de entorno
6. Se abrirá una ventana con dos secciones:
- Variables de usuario (solo para el usuario actual)
- Variables del sistema (para todos los usuarios)


## Crear una variable vía terminal en MacOS 
echo 'export EXCHANGERATE_APIKEY=su_api_key' >> ~/.zshrc
source ~/.zshrc

## Verificar que la variable existe
En modo de comandos o de PowerShell en Windos o terminal de MacOs escriba
echo $EXCHANGERATE_APIKEY

## Ejecutar la aplicación
Al ejecutar la aplicacion, se presentara el siguente menu:
1 - Ver valores de las monedas
2 - Ver valor de cambio de una moneda a otra
3 - Calcular monto de cambio de una moneda a otra
4 - Ver códigos de monedas
-----------
0 - Salir
