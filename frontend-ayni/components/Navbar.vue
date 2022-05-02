<template>
  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #169691">
  <a class="navbar-brand" href="/"><img src = "../store/ayni-icon.png" height = 50 ></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse col-sm-2" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Emergencia">Emergencias</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Quienes Somos</a>
      </li>
    </ul>
  </div>
  <div>
    <ul class="navbar-nav mr-auto my-2 my-lg-0">
      <a class="nav-link to-right" href="/Login" role="button">
        Iniciar Sesión
      </a>
      <a class="nav-link to-right" href="/Signup" role="button">
        Registrarse
      </a>
    </ul>
  </div>
</nav>
</template>

<script>
export default {
  name: 'NuxtNavbar'
}
</script>

<style>
.to-right{
  align-items: right;
}
</style>
