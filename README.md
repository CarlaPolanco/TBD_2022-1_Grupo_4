# TBD_2022-1_Grupo_4

Laboratorio numero 1 de Taller de Base de Datos 2022-1

# LABORATORIO 1 - AYNI

# Integrantes 

```
- Estefanía Álvarez
- Felipe Cornejo 
- Bastian Loyola
- Bastian Onetto
- Carla Polanco
- Carlos Retamales
- Pablo Villareal
```

La estructura del codigo se presenta de la siguiente manera:
```
---------------------------------------------------------------------------------------------------------------
TBD_2022-1_Grupo_4 -> - backend-ayni ->  - src/main/java/cl/tbd/backendayni ->  - models 
                                         - gradlew                              - repositories
                                                                                - services
                                                                                - BackendAyniApplication.java
                                         - src/main/resources -> - application.properties                  -
                      - frontend-ayni -> - assets 
                                         - components
                                         - pages 
                                         - static
                                         - store 
                                         - BACKEND_URL.env
                                         - nuxt.config.js
---------------------------------------------------------------------------------------------------------------
```

# INSTRUCCIONES DE USO

  - Descargar el reposotorio en su formato zip y descomprimirlo en una carpeta destino (ejemplo escritorio) o clonar usando git clone https://github.com/CarlaPolanco/TBD_2022-1_Grupo_4 en la carpeta destino (ejemplo escritorio).
  - Antes de Comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener Postggres configurado en el puerto 5432, que es el puerto por defecto, en aso de no tenerlo configurado en este puerto se debe cambiar en el archivo "application.properties" (ubicación detallada arriba) y cambiar el puerto en la configuracion.
  - Teniendo ya Postgres configurado, se debe crear una base de datos llamada "ayni" (sin comillas), para que el backend pueda generar los datos necesarios.
  - Abrir dos terminales (a preferencia del usuario) y dirigirse a la carpeta del proyecto (ejemplo: escritorio/TBD_2022-1_Grupo_4).
  - Ya teniendo todos los requisitos para ejecutar el proyecto (*), y estando en una de las terminales en la carpeta destino, realizamos la primera parte, en la terminal 1 ingresamos "cd backend-ayni" y enter.
  - Luego de estar dentro backend-ayni debemos levantar la parte del backend del proyecto, de esta manera, ingresando "gradlew bootRun" (en caso de tener una terminal que tenga comandos de linux o powershell de windows, puede ingresar con "./gradlew bootRun"), esto levantara el apartado de backend en el puerto 3000 en localhost (http://localhost:3000).
  - En caso de que el mensaje de exito no se genere o no se visualize la base de datos, debera comprobar sus creedenciales de postgres en el archivo "application.properties", de manera más especifica, en la linea 4 y 5, donde se deben reemplazar los valores de "user" y "password" con los propios. Una vez editado, se guardan los cambios y se vuelve a levantar.
  - Ya levantado el apartado del backend en el puerto 3000 (http://localhost:3000), en una segunda parte en la otra terminal, en la terminal 2, estando en la carpeta destino del proyecto ingresamos "cd frontend-ayni" y enter.
  - Luego de estar dentro frontend-ayni debemos levantar la parte del frontend del proyecto, de esta manera, ingresando "npm install" se instalaran las dependencias necesarias para correr el proyecto, luego de que las dependencias se instalen, se ingresa "npm run dev" esto levantara el frontend en el puerto 8080 en el localhost(http://localhost:8080), en caso de errores de que falte un modulo, por ejemplo: "axios", debera correr "npm install nombre_modulo", en este caso, "npm install axios".
  - Ya realizzndo estos pasos podra interactuar con la aplicacion web de Ayni en el la pagina http://localhost:8080.
  - (*): npm, java 11+, gradle 5+, node js, vue, nuxt, postgresql  
