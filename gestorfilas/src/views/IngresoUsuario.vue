<template>
  <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
    <v-layout justify-center align-center>
      <v-card ref="form" class="mx-auto pa-md-4" max-width="500">
        <v-card-title class="justify-center" style="font-size:1.2em">Ingresa tus datos para unirte a la fila virtual</v-card-title>
        <v-text-field class="ml-4 mr-4"
          v-model="name"
          :error-messages="nameErrors"
          :counter="20"
          label="Nombre"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field>
        <v-text-field class="ml-4 mr-4"
          v-model="rut"
          :error-messages="rutErrors"
          label="Rut"
          required
          @input="$v.rut.$touch()"
          @blur="$v.rut.$touch()"
        ></v-text-field>
        <v-text-field class="ml-4 mr-4"
          v-model="email"
          :error-messages="emailErrors"
          label="Correo electrónico"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
        ></v-text-field>

        <v-btn class="mx-4 mb-4 white--text" color="#00C2CB" @click="submit">Unirse a la fila</v-btn>
        <v-btn @click="clear" class="white--text mx-4 mb-4" color="#00C2CB">Limpiar campos</v-btn>
      </v-card>
    </v-layout>
  </v-container>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, maxLength, email } from "vuelidate/lib/validators";
import { mapState, mapMutation } from "vuex";

export default {
  mixins: [validationMixin],

  validations: {
    name: { required, maxLength: maxLength(20) },
    rut: { required, maxLengthRut: maxLength(10) },
    email: { required, email },
  },

  data: () => ({
    name: "",
    rut: "",
    email: "",
    nuevo_user: {
      rut: null,
      nombre: null,
      correo: null,
    },
  }),

  computed: {
    nameErrors() {
      const errors = [];
      if (!this.$v.name.$dirty) return errors;
      !this.$v.name.maxLength &&
        errors.push("El nombre puede tener máximo 20 caracteres.");
      !this.$v.name.required && errors.push("Debe ingresar un nombre.");
      return errors;
    },
    rutErrors() {
      const errors = [];
      if (!this.$v.rut.$dirty) return errors;
      //!this.$v.rut.maxLengthRut && errors.push('El rut no puede tener más de 10 caracteres.')
      !this.$v.rut.required && errors.push("Debe ingresar un rut.");
      const rutRegex = /^[0-9]+[-|‐]{1}[0-9kK]{1}$/;
      !rutRegex.test(this.rut) && errors.push("Debe ingresar un rut válido.");
      return errors;
    },
    emailErrors() {
      const errors = [];
      if (!this.$v.email.$dirty) return errors;
      !this.$v.email.email &&
        errors.push("Debe ingresar un correo electrónico válido.");
      !this.$v.email.required &&
        errors.push("Debe ingresar un correo electrónico.");
      return errors;
    },
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
    clear() {
      this.$v.$reset();
      this.name = "";
      this.email = "";
      this.rut = "";
    },
    /*...mapMutation(['createUser']),

      create_user(){
          this.$v.$touch()
          this.createUser(this.nuevo_user)
      }*/
  },
};
</script>
