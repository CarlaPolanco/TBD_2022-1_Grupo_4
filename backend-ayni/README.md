# TBD_2022-1_Grupo_4

Laboratorio numero 1 de Taller de Base de Datos 2022-1

# LABORATORIO 1 - AYNI

La estructura del codigo se presenta de la siguiente manera:
```
---------------------------------------------------------------------------------------------------------------
TBD_2022-1_Grupo_4 -> - backend-ayni ->  - src/main/java/cl/tbd/backendayni ->  - models 
                                         - gradlew                              - repositories
                                                                                - services
                                                                                - BackendAyniApplication.java
                                         - src/main/resources -> - application.properties                  -
---------------------------------------------------------------------------------------------------------------
```

# INSTRUCCIONES DE USO - Solo Backend

  - Antes de Comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener Postggres configurado en el puerto 5432, que es el puerto por defecto, en aso de no tenerlo configurado en este puerto se debe cambiar en el archivo "application.properties" (ubicación detallada arriba) y cambiar el puerto en la configuracion.
  - Teniendo ya Postgres configurado, se debe crear una base de datos llamada "ayni" (sin comillas), para que el backend pueda generar los datos necesarios.
  - Abrir una terminal (a gusto del usuario) y dirigirse a la carpeta del backend del proyecto (ejemplo: escritorio/TBD_2022-1_Grupo_4/backend-ayni).
  - Luego de estar dentro backend-ayni debemos levantar la parte del backend del proyecto, de esta manera, ingresando "gradlew bootRun" (en caso de tener una terminal que tenga comandos de linux o powershell de windows, puede ingresar con "./gradlew bootRun"), esto levantara el apartado de backend en el puerto 3000 en localhost (http://localhost:3000).
  - En caso de que el mensaje de exito no se genere o no se visualize la base de datos, debera comprobar sus creedenciales de postgres en el archivo "application.properties", de manera más especifica, en la linea 4 y 5, donde se deben reemplazar los valores de "user" y "password" con los propios. Una vez editado, se guardan los cambios y se vuelve a levantar

  - (*): npm, java 11+, gradle 5+, node js, vue, nuxt, postgresql  
