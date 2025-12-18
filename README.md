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
Una vez, obtenida la llave, crea la variable del sistema con nombre `EXCHANGERATE_APIKEY` y valor obtenido de la llave.

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
`echo 'export EXCHANGERATE_APIKEY=su_api_key' >> ~/.zshrc`

`source ~/.zshrc`


## Crear variable de entorno en GitHub como Codespaces Secret
1. Ir al repositorio en GitHub
2. Abrir Settings
3. Ir a Secrets and variables → Codespaces
4. Seleccionar New repository secret
5. Definir:
  Name: `EXCHANGERATE_APIKEY`
  Value: `su_api_key`

## Verificar que la variable existe
En modo de comandos o de PowerShell en *Windos* o terminal de *MacOs* escriba
`echo $EXCHANGERATE_APIKEY`

## Ejecutar la aplicación


