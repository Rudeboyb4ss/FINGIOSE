<template>
  <v-app>
    <v-app-bar
      app
      color="#00C2CB"
      dark
      max-height="100px"
      width="100%"
    >
      <div class="flex align-center">
        <v-img
          alt="Filapp Logo"
          contain
          src="../public/Filapp.png"
          transition="scale-transition"
          height="200px"
        />
      </div>
    </v-app-bar>
    <!-- Esto llama a las rutas-->
    <router-view/>
  </v-app>
</template>

<script>
export default {
  name: 'App'
}
</script>