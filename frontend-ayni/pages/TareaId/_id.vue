<template>
<body>
  <Navbar/>
  <div class="wrapper fadeInDown scrollDiv col-sm" style="background-color: #4f3185">

    <div v-for="(item, index) in items" :key="index" id="formContent" style="background-color: #169691">
      <h1>{{item.nombre}}</h1>

      <!-- Mapa -->
      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26652.897618664756!2d-70.71583567072133!3d-33.3811889850277!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662c5d793bb7325%3A0xe5a14691ce225e43!2sEstadio%20Santa%20Laura!5e0!3m2!1ses-419!2scl!4v1650682393094!5m2!1ses-419!2scl"
        width="400"
        height="300"
        style="border: 0"
        allowfullscreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
      ></iframe>

      <!-- Descripcion -->
      <p>
        {{item.descripcion}}
      </p>

      <!-- Botones -->

      <div class="contenedorDos">
        <div>
          <a href="#">
            <button type="button" class="btn btn-primary btn-lg">
              Aceptar
            </button>
          </a>
        </div>

        <div>
          <a href="#">
            <button type="button" class="btn btn-primary btn-lg">
              Rechazar
            </button>
          </a>

        </div>

      </div>
    </div>
    <div>
    <h1> </h1>
    <a v-bind:href="'../SelectVolTarea/'+param">
    <button class="botonDos"><span>Voluntarios</span></button>
    </a>
  </div>
  </div>
  
</body>
</template>

<script>
export default {
    //Función que contiene los datos del componente
    data(){
        return{
            //Lista de ítems a mostrar
            items:[],
            param:[]
        }
    },
    mounted() {
        this.param = this.$route.params.id;
      },
    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get("/tarea/getById/"+this.$route.params.id);
                this.items  = response.data;
                console.log(response);
            } catch (error) {
                console.log('error', error);
            }
        }
    },
    //Función que se ejecuta al cargar el componente
    created:function(){
        this.getData();
    }
}

</script>