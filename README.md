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
  - Abrir dos terminales (cmd) y dirigirse a la carpeta del proyecto (ejemplo: escritorio/TBD_2022-1_Grupo_4).
  - Ya teniendo todos los requisitos para ejecutar el proyecto (*), y estando en una de las terminales en la carpeta destino, realizamos la primera parte, en la terminal 1 ingresamos "cd backend-ayni" y enter.
  - Luego de estar dentro backend-ayni debemos levantar la parte del backend del proyecto, de esta manera, ingresando "gradlew bootRun" (en caso de tener una terminal que tenga comandos de linux o powershell de windows, puede ingresar con "./gradlew bootRun"), esto levantara el apartado de backend en el puerto 8081 en localhost (http://localhost:8081).
  - Ya ingresando el comando, saldran mensajes por la terminal que generen las tablas y dump del proyecto, luego de mensajes de exito, debera ejecutar ctrl + c y detener el proceso, y repetir el paso anterior (es debido sql2o que no reconoce en una primera instancia los datos generados, pero se pueden visualizar en pgadmin o terminal de postgresql).
  - En caso de que el mensaje de exito no se genere o no se visualize la base de datos, debera comprobar sus creedenciales de postgres en el archivo DatabaseContext.java de la carpeta repositories en la linea 17 y 18, ver si tiene alguna, en caso de no tener concidencias, debera tomar una (cambiar en postgres) o agregarse, aumentando el ciclo del iterador en 1 en el codigo java del archivo DatabaseContext.java.
  - Ya levantado el apartado del backend en el puerto 8081 (http://localhost:8081), en una segunda parte en la otra terminal, en la terminal 2, estando en la carpeta destino del proyecto ingresamos "cd frontend-ayni" y enter.
  - Luego de estar dentro frontend-ayni debemos levantar la parte del frontend del proyecto, de esta manera, ingresando "npm install" se instalaran las dependencias necesarias para correr el proyecto, luego de que las dependencias se instalen, se ingresa "npm run dev" esto levantara el frontend en el puerto 8080 en el localhost(http://localhost:8080), en caso de errores de que falte un modulo, por ejemplo: "axios", debera correr "npm install nombre_modulo", en este caso, "npm install axios".
  - Ya realizzndo estos pasos podra interactuar con la aplicacion web de Ayni en el la pagina http://localhost:8080.
  - (*): npm, java 11+, gradle 5+, node js, vue, nuxt, postgresql  
