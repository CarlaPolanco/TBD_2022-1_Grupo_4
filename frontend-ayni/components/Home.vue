<template>
<body>
  <div class="conteiner bg-prpl scrollDiv">
    <div class="row">
      <div class="col-sm nuxt-logo">
        <NuxtLogo/>
      </div>
    </div>
  </div>
</body>
</template>

<script>
export default {
  name: 'IndexPage'
}
</script>
<style>
.bg-prpl{
  background-color: #4F3185
}
.home-logo{
  margin-top: 5vh;
  margin-left: 5vh;
  max-width: auto;
}
.scrollDiv {
    height: 100vh;
    max-height: 100vh;
}
</style>
