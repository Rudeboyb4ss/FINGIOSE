<template>
  <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
    <v-card ref="form" class="mx-auto my-12" max-width="374">
      <v-card-title class="justify-center" style="font-size: 1.5em"
        >Configurar fila virtual</v-card-title
      >
      <v-card-subtitle class="mt-n1 ml-3 pb-0" >
         Ingrese horario de atención
        </v-card-subtitle>
      <v-row class="ml-4">
        <v-col cols="11" sm="5">
          <v-dialog
            ref="dialog"
            v-model="modal2"
            :return-value.sync="time"
            persistent
            width="290px"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="time"
                label="Ingrese hora de inicio"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker
              color="#00C2CB"
              v-if="modal2"
              v-model="time"
              full-width
            >
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal2 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog.save(time)"
                >OK</v-btn
              >
            </v-time-picker>
          </v-dialog>
        </v-col>

        <v-spacer></v-spacer>

        <v-col class="mr-11" cols="11" sm="5">
          <v-dialog
            ref="dialog1"
            v-model="modal1"
            :return-value.sync="time1"
            persistent
            width="290px"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                v-model="time1"
                label="Ingrese hora de termino"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker
              color="#00C2CB"
              v-if="modal1"
              v-model="time1"
              full-width
            >
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal1 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog1.save(time1)"
                >OK</v-btn
              >
            </v-time-picker>
          </v-dialog>
        </v-col>
      </v-row>
      <v-text-field class="ml-7 mr-10"
              label="Ingrese tiempo de atención por cliente"
                placeholder="MM"
            ></v-text-field>
      <v-container class="px-6 small" fluid>
      <v-switch
      class="shrink"
      color="#00C2CB" 
      v-model="switch1"
      :label="`Horario con receso`"
    ></v-switch>
      </v-container>
      <v-card-subtitle class="mt-n1 ml-3 pb-0" >
         Ingrese horario del receso
        </v-card-subtitle>
      <v-row class="ml-4">
        <v-col cols="11" sm="5">
          <v-dialog
            ref="dialog3"
            v-model="modal3"
            :return-value.sync="time3"
            persistent
            width="290px"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                class="mb-0"
                v-model="time3"
                label="Ingrese hora de inicio"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker
              color="#00C2CB"
              v-if="modal3"
              v-model="time3"
              full-width
            >
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal3 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog3.save(time3)"
                >OK</v-btn
              >
            </v-time-picker>
          </v-dialog>
        </v-col>

        <v-spacer></v-spacer>

        <v-col class="mr-11" cols="11" sm="5">
          <v-dialog
            ref="dialog4"
            v-model="modal4"
            :return-value.sync="time4"
            persistent
            width="290px"
          >
            <template v-slot:activator="{ on, attrs }">
              <v-text-field
                class="mt-0"
                v-model="time4"
                label="Ingrese hora de termino"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker
              color="#00C2CB"
              v-if="modal4"
              v-model="time4"
              full-width
            >
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal4 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog4.save(time4)"
                >OK</v-btn
              >
            </v-time-picker>

          </v-dialog>
        </v-col>
        <div>
      <v-btn
        small
        color="#9D9D9D"
        height="2em"
        class="mx-4 mb-7 mt-0 white--text"
        @click="submit"
        >+ Agregar receso</v-btn
      > </div>

      


      </v-row>
      <v-card-actions class="justify-end">
        <div>
      <v-btn
        v-if="volver == 1"
        color="#00C2CB"
        height="3em"
        align="center"
        class="mx-8 my-4 white--text"
        @click="submit"
        v-on:click="modificarHora"
        >Aceptar</v-btn
      >
      <v-btn
        v-if="volver == 2"
        color="#00C2CB"
        height="3em"
        align="center"
        class="mx-8 my-4 white--text"
        v-on:click="modificarHora"
        @click="submit"
        >Aceptar</v-btn
      ></div>
      </v-card-actions>
      
      
    </v-card>
  </v-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import { validationMixin } from "vuelidate";
import { required, maxLength, email } from "vuelidate/lib/validators";

export default {
  data: () => ({
    time: null,
    time1: null,
    time3: null,
    time4: null,
    modal1: false,
    modal2: false,
    modal3: false,
    modal4: false,
    checkbox: true,
    radioGroup: 1,
    switch1: true,
  }),

  created: function () {
    this.filaconfig2 = this.obtenerFila(this.admin);
    console.log(this.filaconfig2);
  },

  computed: {
    ...mapState(["volver", "filaconfig", "admin"]),
  },

  methods: {
    ...mapMutations(["obtenerFila", "modificarhoraback"]),

    submit() {
      //this.$v.$touch();
    },

    modificarHora() {
      //no se puede porque no se guarda la variable global filaconfig
      //this.filaconfig.horaInicio = this.time;
      //this.filaconfig.horaTermino = this.time1;
      //this.modificarhoraback(this.filaconfig);

      if (this.volver == 1) {
        this.$router.push('AdministrarFila');
      } else {
        this.$router.push('iniciarfila');
      }
    },
  },
};
</script>