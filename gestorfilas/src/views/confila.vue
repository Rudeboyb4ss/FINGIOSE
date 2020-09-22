<template>
  <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
    <v-card ref="form" class="mx-auto my-12" max-width="374">
      <v-card-title class="justify-center" style="font-size:1.5em">Configurar fila virtual</v-card-title>

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

            <v-time-picker color="#00C2CB" v-if="modal2" v-model="time" full-width>
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal2 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog.save(time)">OK</v-btn>
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

            <v-time-picker color="#00C2CB" v-if="modal1" v-model="time1" full-width>
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal1 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog1.save(time1)">OK</v-btn>
            </v-time-picker>
          </v-dialog>
        </v-col>
      </v-row>

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
                v-model="time3"
                label="Ingrese hora de inicio"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker color="#00C2CB" v-if="modal3" v-model="time3" full-width>
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal3 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog3.save(time3)">OK</v-btn>
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
                v-model="time4"
                label="Ingrese hora de termino"
                placeholder="HH:MM"
                readonly
                v-bind="attrs"
                v-on="on"
              ></v-text-field>
            </template>

            <v-time-picker color="#00C2CB" v-if="modal4" v-model="time4" full-width>
              <v-spacer></v-spacer>
              <v-btn text color="#00C2CB" @click="modal4 = false">Cancel</v-btn>
              <v-btn text color="#00C2CB" @click="$refs.dialog4.save(time4)">OK</v-btn>
            </v-time-picker>
          </v-dialog>
        </v-col>
      </v-row>

      <v-btn color="#00C2CB" class="mx-4 my-4 white--text" @click="submit">Aceptar</v-btn>
    </v-card>
  </v-container>
</template>

<script>
import { validationMixin } from "vuelidate";
import { required, maxLength, email } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      time: null,
      modal2: false,
      time1: null,
      modal1: false,
      time3: null,
      modal3: false,
      time4: null,
      modal4: false,
    };
  },

  methods: {
    submit() {
      this.$v.$touch();
    },
  },
};
</script>