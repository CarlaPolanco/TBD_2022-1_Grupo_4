<template>

  <div class ="contenedorTres">
    <div class ="col-sm">
      <div v-for="(item, index) in items" :key="index">
        <h1> </h1>
        <a v-bind:href="'EmergenciaId/'+item.id">
        <button class="botonDos"><span>{{item.nombre}}</span></button>
        </a>
      </div>
    </div>
    <div class ="col-sm" style="padding-top:30px">
        <a href="#">
          <button type="button" class="btn btn-success">Nueva Emergencia</button>
        </a>
    </div>

    </div>
   
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
            items:[]
        }
    },
    methods:{
        //Función asíncrona para consultar los datos
        getData: async function(){
            try {
                let response = await this.$axios.get('/emergencia');
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
