<template>
    <v-container fluid ma-0 pa-0 fill-height class="cyan lighten-5">
        <v-layout justify-center align-center>
            <v-card
                class="mx-auto my-12"
                max-width="374"
            >

                <v-card-title class="justify-center" style="font-size:1.5em">Administrar Fila</v-card-title>

                <v-card-title class="justify-center" style="font-size:3.5em">
                    25
                </v-card-title>

                <v-card-subtitle class="mt-n1" align="center">
                    <strong>
                    Turno actual
                    </strong>
                </v-card-subtitle>


                <v-card-actions>
                    <v-row justify="center">
                        <v-btn class="white--text" large color=#00C2CB height="6em">PASAR TURNO</v-btn>
                    </v-row>
                </v-card-actions>

                <v-card-actions align="center">
                        <v-col>
                            <v-btn class="white--text" large color=#E7AE57 height="3em">PAUSAR FILA</v-btn>
                        </v-col>
                        <v-col>
                            <v-btn class="white--text" large color=#727272 height="3em">FINALIZAR</v-btn>
                        </v-col>
                </v-card-actions>

                <v-card-actions>
                    <v-row justify="center">
                        <v-btn text small color=#00C2CB>Configurar fila</v-btn>
                    </v-row>
                </v-card-actions>  
            </v-card>
        </v-layout>
    </v-container>
</template>