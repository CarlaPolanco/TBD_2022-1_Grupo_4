-------------------------------------- Readme Proyecto ----------------------------------------
# TBD_2022-1_Grupo_4

Laboratorio numero 1 de Taller de Base de Datos 2022-1

# LABORATORIO 1 - AYNI

La estructura del codigo se presenta de la siguiente manera:
```
---------------------------------------------------------------------------------------------------------------
TBD_2022-1_Grupo_4 -> - frontend-ayni -> - assets 
                                         - components
                                         - pages 
                                         - static
                                         - store 
                                         - BACKEND_URL.env
                                         - nuxt.config.js
---------------------------------------------------------------------------------------------------------------
```

# INSTRUCCIONES DE USO - Solo Frontend

  - **Se debe tener levantado el Backend de antemano para una mejor demostración de uso**
  - Nos posicionamos dentro de la carpeta del frontend (ejemplo: "TBD_2022-1_Grupo_4\frontend-ayni") con el terminal o linea de comandos de preferencia.
  - Luego de estar dentro frontend-ayni debemos levantar la parte del frontend del proyecto, de esta manera, ingresando "npm install" se instalaran las dependencias necesarias para correr el proyecto, luego de que las dependencias se instalen, se ingresa "npm run dev" esto levantara el frontend en el puerto 8080 en el localhost(http://localhost:8080), en caso de errores de que falte un modulo, por ejemplo: "axios", debera correr "npm install nombre_modulo", en este caso, "npm install axios".
  - Ya realizzndo estos pasos podra interactuar con la aplicacion web de Ayni en el la pagina http://localhost:8080.

-------------------------------------- Readme Tecnico ----------------------------------------

# frontend-ayni

## Build Setup

```bash
# install dependencies
$ npm install

# serve with hot reload at localhost:3000
$ npm run dev

# build for production and launch server
$ npm run build
$ npm run start

# generate static project
$ npm run generate
```

For detailed explanation on how things work, check out the [documentation](https://nuxtjs.org).

## Special Directories

You can create the following extra directories, some of which have special behaviors. Only `pages` is required; you can delete them if you don't want to use their functionality.

### `assets`

The assets directory contains your uncompiled assets such as Stylus or Sass files, images, or fonts.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/assets).

### `components`

The components directory contains your Vue.js components. Components make up the different parts of your page and can be reused and imported into your pages, layouts and even other components.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/components).

### `layouts`

Layouts are a great help when you want to change the look and feel of your Nuxt app, whether you want to include a sidebar or have distinct layouts for mobile and desktop.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/layouts).


### `pages`

This directory contains your application views and routes. Nuxt will read all the `*.vue` files inside this directory and setup Vue Router automatically.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/get-started/routing).

### `plugins`

The plugins directory contains JavaScript plugins that you want to run before instantiating the root Vue.js Application. This is the place to add Vue plugins and to inject functions or constants. Every time you need to use `Vue.use()`, you should create a file in `plugins/` and add its path to plugins in `nuxt.config.js`.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/plugins).

### `static`

This directory contains your static files. Each file inside this directory is mapped to `/`.

Example: `/static/robots.txt` is mapped as `/robots.txt`.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/static).

### `store`

This directory contains your Vuex store files. Creating a file in this directory automatically activates Vuex.

More information about the usage of this directory in [the documentation](https://nuxtjs.org/docs/2.x/directory-structure/store).
