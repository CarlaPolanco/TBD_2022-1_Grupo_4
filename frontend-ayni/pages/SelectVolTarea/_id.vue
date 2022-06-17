<template>
<body>
    <Navbar />
    <div class="container" style="background-color: #4f3185">
        <div class="row">
            <tr height="100px"></tr>
        </div>
        <div class="row">
            <div class="col-sm">
                <div  v-for="(item, index) in items_tarea" :key="index" id="formContent" style="background-color: #169691">
                    <h1>{{item.nombre}}</h1>
                    <!--Aqui va lo de Seleccionar varios o solo una cantidad y eso-->
                    <div class="input-group mb-3">
                        <input type="text" class="form-control" placeholder="Cantidad de Voluntarios" aria-label="Voluntario username" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button type="button" class="btn btn-primary btn-lg">
                                Aceptar
                            </button>
                        </div>
                    </div>
                    <button type="button" class="list-group-item list-group-item-action">Seleccionar todos los voluntarios</button>
                    <button type="button" class="list-group-item list-group-item-action">Seleccionar los primeros 3 voluntarios</button>
                </div>
            </div>
            <div class="col-sm">
                <div id="formContent" style="background-color: #169691">
                    <h1>Voluntarios</h1>
                    <table id="example" class="table table-striped table-bordered" style="background-color: #169691">
                        <thead>
                            <tr>
                                <th style="width: 100x;"></th>                
                                <th style="width: 800px;">Nombre Voluntario</th>
                                <th style="width: 100x;">Ranking</th>
                                <th style="width: 100px;"><input type="checkbox" id="one_checkbox" onclick="selects()"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- {% for para la lista de voluntarios ordenados por Ranking %} -->
                            <tr  v-for="(item, index) in items_ranking" :key="index">                
                                <td name="Ver Perfil">
                                    <a href="#">
                                        <button type="button" class="btn btn-primary btn-lg">
                                        Ver Perfil
                                        </button>
                                    </a>
                                </td>
                                <td name="Voluntario"> {{item.nombre}} </td>
                                <td name="Ranking">{{item.porcentaje}}</td>
                                <td>
                                    <input type="checkbox" id="one_checkbox" name="one_checkbox">
                                </td>
                            </tr>
                            <!-- {% for para la lista de voluntarios ordenados por Ranking %} -->
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class= "col"></div>
                <div class= "col">
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Seleccionar</button>
                    </div>
                </div>
            </div>
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
            items_tarea:[],
            param:[],
            items_ranking:[],
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
                this.items_tarea  = response.data;
                console.log(response);
            } catch (error) {
                console.log('error', error);
            }
        },
        getData2: async function(){
            try {
                let response2 = await this.$axios.get("/ranking/getRankingByIdTarea/"+this.$route.params.id);
                this.items_ranking = response2.data;
                console.log(response2);
            } catch (error) {
                console.log('error', error);
            }
        }
    },
    //Función que se ejecuta al cargar el componente
    created:function(){
        this.getData();
        this.getData2();
    }
}
</script> 