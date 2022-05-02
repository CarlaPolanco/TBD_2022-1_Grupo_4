<template>
<body>
  <div class ="contenedorTres">

    <div v-for="(item, index) in items" :key="index">
      <h1> </h1>
      <a v-bind:href="'TareasId/'+item.id">
        <button class="botonDos"><span>{{item.nombre}}</span></button>
      </a>
    </div>
  </div>

  <div>
      <a href="/NuevaTarea">
        <button type="button" style="position: absolute; top: 60px; left: 650%; width : 150px ; padding: 10px" class="btn btn-success">Nueva Tarea</button>
      </a>
  </div>
</body>
</template>

<style>
.scrollDiv {
    height: 100vh;
    max-height: 100vh;
}
</style>

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
    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response2 = await this.$axios.get("/tarea");
                this.items = response2.data;
                console.log(response2);
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
