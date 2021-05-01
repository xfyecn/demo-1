<template>
  <div id="Navbar">
    <nav class="navbar navbar-expand-lg navbar-light bg-navColor sticky-top">
      <div>
        <router-link to="/" class="navbar-brand" type="button">
          <img src="../assets/logo.jpg" alt="" width="50" height="45">
          DEMO
        </router-link>
      </div>
      <div class="collapse navbar-collapse" >
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="navbar-brand">
            <router-link to="/home" class="nav-link active" type="button" >Ana Sayfa</router-link>
          </li>
          <li class="navbar-brand">
            <router-link to="/surveyResults" class="nav-link" type="button">Anket Sonuçları</router-link>
          </li>
        </ul>
      </div>
      <div>
        <router-link to="survey" class="btn btn-outline-dark" type="button">Ankete Git</router-link>
      </div>
    </nav>
    <div class="container mt-3">
      <router-view/>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Navbar',
  props: {
    msg: String
  }
}
</script>

<style scoped>
  .bg-navColor {
    background-color: #98D8EF;
}
</style>