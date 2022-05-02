<template>
  <div class="wrapper fadeInDown scrollDiv" style="background-color: #4F3185">
  <div id="formContent"  style="background-color: #169691">
    
    <!-- Tabs Titles -->

    <div>
        <h1> Creacion nueva tarea</h1> 
    </div>

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="../store/ayni-logo.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form>
      <input type="text" id="Nombre de la Tarea" class="fadeIn second" name="Nombre de la Tarea" placeholder="Nombre de la Tarea">
      <input type="text" id="Descripcion" class="fadeIn second" name="Descripcion" placeholder="Descripcion">
      <input type="text" id="Fecha" class="fadeIn third" name="Fecha" placeholder="Fecha">
      <input type="text" id="Longitud" class="fadeIn third" name="Longitud" placeholder="Longitud">
      <input type="text" id="Latitud" class="fadeIn third" name="Latitud" placeholder="Latitud">
    </form>

    <!-- Botones -->

    <div class = "contenedorDos" >
        <div>
            <a href="./SelectVolTarea">
            <button type="button" class="btn btn-primary btn-lg">Registrar</button>
            </a>
        </div>
    </div>
  </div>

</div>
</template>

<style>
.scrollDiv {
    height: 100vh;
    max-height: 100vh;
}
</style>