import dotenv from 'dotenv'
dotenv.config()

export default {
  //Se pone el servidor en el puerto 8080
  server: {
    port:8080,
  },
  // Disable server-side rendering: https://go.nuxtjs.dev/ssr-mode
  ssr: false,

  // Target: https://go.nuxtjs.dev/config-target
  target: 'static',

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'frontend-ayni',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
    "~/node_modules/bootstrap/dist/css/bootstrap.min.css",
    "./assets/styles.css",
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
    { src: "~/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js", mode: "client" },
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
    '@nuxtjs/auth',
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: process.env.BACKEND_URL,
    proxy: true,
  },

  auth: {
    strategies: {
      local: {
        endpoints: {
          login: {
            url: '/auth/login',
            method: 'post',
            propertyName: false
          },
          logout: { 
            url: '/auth/logout', 
            method: 'post' 
          },
          user: { 
            url: '/auth/profile', 
            method: 'get', 
            propertyName: false 
          }
        },
        tokenRequired: false,
        tokenType: false
      }
    }
  },  
  
  proxy: {
    "/emergencia": 'http://localhost:3000',
    "/tarea": 'http://localhost:3000',
    "/ranking/getRankingByIdTarea": 'http://localhost:3000',
    "/tarea/getTareaByIdEmergencia":'http://localhost:3000',
  },

  

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }

}
