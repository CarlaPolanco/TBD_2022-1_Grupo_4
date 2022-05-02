<template>
  <div class="wrapper fadeInDown scrollDiv" style="background-color: #4F3185">
  <div id="formContent"  style="background-color: #169691">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="../store/ayni-logo.png" id="icon" alt="User Icon">
    </div>

    <!-- Login Form -->
    <form>
      <input type="text" id="Correo" class="fadeIn second" name="Correo" placeholder="Correo">
      <input type="text" id="Nombre de Usuario" class="fadeIn second" name="Nombre de Usuario" placeholder="Nombre de Usuario">
      <input type="text" id="Password" class="fadeIn third" name="Password" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Registrarse">
    </form>


  </div>
</div>
</template>

<style>
.scrollDiv {
    height: 100vh;
    max-height: 100vh;
}
</style>