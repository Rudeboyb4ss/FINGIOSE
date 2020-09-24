
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
      <h2
      class="mx-10 my-10 mt-16"
      >Ingresa código del local</h2>
      <v-text-field
        v-model="codigo"
        class="mx-10"
        :counter="24"
        label="Código"
        :error-messages="codigoErrors"
        required
        @input="$v.codigo.$touch()"
        @blur="$v.codigo.$touch()"
      ></v-text-field>
      <b class="ml-3 mt-5 cyan--text mx-11 my-8" v-if="alerta == 1"> Ha ingresado un código inválido.</b>
      <v-btn
        color="#00C2CB"
        class="mr-4 mt-10 white--text"
        @click="submit" 
        v-on:click="validarcodigox"
      >
        Ingresar
      </v-btn>
    </v-card>
  </v-layout>
</v-container>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, maxLength, minLength } from "vuelidate/lib/validators";
import { mapState, mapMutations } from "vuex";

export default {
  mixins: [validationMixin],

  validations: {
    codigo: { required, maxLength: maxLength(24) , minLength: minLength(24) },
  },

  data: () => ({
    codigo: "",
  }),
  
  watch:{
    alerta: function(){
      console.log(this.alerta);
      if(this.alerta == 2){
            this.$router.push('IngresoUsuario');
      }
    }
  },

  computed: {
    codigoErrors() {
      const errors = [];
      if (!this.$v.codigo.$dirty) return errors;
      !this.$v.codigo.maxLength &&
        errors.push("El código debe tener 24 caracteres.");
      !this.$v.codigo.minLength &&
        errors.push("El código debe tener 24 caracteres.");
      !this.$v.codigo.required && errors.push("Debe ingresar un código.");
      return errors;
    },
    ...mapState(['codigoFila','alerta']),
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
    clear() {
      this.$v.$reset();
      this.codigo = "";
    },
    ...mapMutations(['validarCodigo']),

      validarcodigox(){
          this.pruebacodigo = this.codigo;
          this.validarCodigo(this.pruebacodigo);
          //]console.log(this.alerta);
      }

  },
};
</script>