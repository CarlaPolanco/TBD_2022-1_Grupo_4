<template>
  <div class="wrapper fadeInDown scrollDiv" style="background-color: #4F3185">
  <div id="formContent"  style="background-color: #169691">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="../store/ayni-logo.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action="">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="username">
      <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
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