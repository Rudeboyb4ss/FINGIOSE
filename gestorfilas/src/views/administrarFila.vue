<template>
  <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
    <v-layout justify-center align-center>
      <v-card class="mx-auto my-12" max-width="374">
        <v-card-title class="justify-center" style="font-size:1.5em">Administrar Fila</v-card-title>

        <v-card-title class="justify-center" style="font-size:1.5em" v-if="fila.turnoActual == 0">No existen personas en la fila</v-card-title>
        <v-card-title class="justify-center" style="font-size:1.5em" v-if="fila.pausada == true">Fila Pausada</v-card-title>
        <v-card-title class="justify-center" style="font-size:3.5em" v-else>{{fila.turnoActual}}</v-card-title>

        <v-card-subtitle class="mt-n1" align="center" v-if="fila.turnoActual != 0 && fila.pausada!=true">
          <strong>Turno actual</strong>
        </v-card-subtitle>

        <v-card-actions>
          <v-row justify="center">
            <v-btn class="white--text" large color="#00C2CB" height="6em" @click.prevent="pasarTurno">PASAR TURNO</v-btn>
          </v-row>
        </v-card-actions>

        <v-card-actions align="center">
          <v-col>

            <v-btn
              class="white--text"
              large
              color="#E7AE57"
              height="3em"
              @click.prevent="pausarFila"
              v-if="fila.pausada == false">
                PAUSAR FILA
            </v-btn>

            <v-btn class="white--text" large color="#E7AE57" height="3em" @click.prevent="pausarFila" v-else>
              REANUDAR FILA
            </v-btn>

          </v-col>

          <v-col>
            <v-btn class="white--text" large color="#727272" height="3em" @click.prevent="finalizarFila">
              FINALIZAR
            </v-btn>
          </v-col>
        </v-card-actions>

        <v-card-actions>
          <v-row justify="center">
            <v-btn text small color="#00C2CB" to="/confila">Configurar fila</v-btn>
          </v-row>
        </v-card-actions>
      </v-card>
    </v-layout>
  </v-container>
</template>

<script>
  import {mapState, mapMutations} from 'vuex';
  export default{

    created: function()
    {
      //this.getFila();
      this.getTurnoActual();
      this.variableVolver(1);

    },

    computed:{
      ...mapState(['fila','admin','volver'])
    },

    methods:{
      ...mapMutations(['getFilaYPausar', 'getFila', 'getTurnoActual', 'pasarTurnoActual']),
      
      finalizarFila(){
        this.getFila();
        this.$router.push('iniciarfila')
      },

      pausarFila(){
        this.getFilaYPausar();
      },

      traerTurno(){
        this.getTurnoActual();
      },

      pasarTurno(){
        this.pasarTurnoActual();
      }
      
    }
  }
</script>