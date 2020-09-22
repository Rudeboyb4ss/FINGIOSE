
<template>
<v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
  <v-layout justify-center align-center>
    <v-card
    class="mx-auto"
    width="344"
    elevation="12"
    height="400"
    align="center"
    justify="center"
    >
    <v-form 
      class="mx-auto my-10"
      ref="form"
    >
      <h1
      class="mx-10"
      >Ingresa código del local</h1>
      <v-text-field
        class="mx-10"
        :counter="10"
        label="Código"
        required
      ></v-text-field>
      <v-btn
        color="#00C2CB"
        class="mr-4 mt-10 white--text"
      >
        Ingresar
      </v-btn>
    </v-form>
    </v-card>
  </v-layout>
</v-container>
</template>
