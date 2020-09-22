<template>
  <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
    <v-layout row wrap align-center>
  <v-card
    class="mx-auto"
    max-width="344"
    elevation="12"
    height="400"
    align="center"
    justify="center"
  >
    <v-card-text class=text-center>
      <h1 class="display-1 text--primary font-weight-black" >
        Administrar Fila
      </h1>
    </v-card-text>
    <v-card-actions class="pa-16 flex-column justify-center " >
      <v-btn
          color="#00C2CB"
          v-bind="attrs"
          v-on="on"
          block
          height="100"
        >
      <a class="font-weight-medium white--text" >Iniciar Fila</a>
      </v-btn>
      <div class="text-center pa-16">
        <v-btn class=" ma-2"
        height="30">
        Configurar fila
      </v-btn>
      </div>
    </v-card-actions>

  </v-card>
  </v-layout>
  </v-container>
</template>