import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex,axios)

export default new Vuex.Store({
  state: {
    alerta: 0,
    admin:{},
    fila:{},
    nuevo_user: {
      rut: null,
      nombre: null,
      correo: null,
    },
    codigoFila: null, //por mientras
    user_fila:{
    user: null,
    codigo: null,
  },
  volver: 2,
  filaconfig: null


  },
  mutations: {
  

      getFila:function(state)
      {
        axios.get("http://localhost:1818/admin/getbyrut/6666666666666").then((result) => {
          state.admin = result.data;
          //console.log(state.admin);
          state.codigoFila = state.admin.codigoFila;
          //console.log(this.codigoFila);
          axios.put("http://localhost:1818/filavirtual/editarestado/" + state.codigoFila)
        })
      },

      getTurnoActual(state)
      {
        //console.log(state.admin);
        console.log(state.codigoFila);
        axios.get("http://localhost:1818/filavirtual/getbycodigo/" + state.codigoFila).then((result) => {
          state.fila = result.data;
        })
      },

      createUser(state, nuevo_user){
        try{
          console.log(nuevo_user);
          axios.post('http://localhost:1818/user/create/', nuevo_user)
          .then(response =>{
            console.log(response);
          }
            )
          .catch(function(error){
            console.log(error);
          });
        } catch (err){
          console.log("Hubo un problema al crear el usuario." + err)
        }
      },

      getFilaYPausar(state){
          axios.get("http://localhost:1818/admin/getbyrut/12555555").then((result) => {
          state.admin = result.data;
          console.log(state.admin);
          state.fila = state.admin.fila;
          console.log(state.fila);
          axios.post("http://localhost:1818/filavirtual/editarpausada", state.fila)
        })
      },

      validarCodigo(state, pruebacodigo){
        axios.get("http://localhost:1818/filavirtual/getbycodigo/" + pruebacodigo).then((result) => {
        this.filaAsociada = result.data;
        if (this.filaAsociada == '') {
          console.log("sabe q es null");
          state.alerta = 1;
        }
        else{
        state.codigoFila = pruebacodigo;
        console.log(state.codigoFila);
          state.alerta = 2;
        }
      })
    },

    agregarUsuarioFila(state, user_fila){
      try{
        //state.user_fila = user_fila;
        //state.user_fila.user = user_fila.user;
        //state.user_fila.codigo = user_fila.codigo;
        console.log(user_fila);
        axios.post('http://localhost:1818/registrocliente/asignarturno', user_fila)
        .then(response =>{
          console.log(response);
        }
          )
        .catch(function(error){
          console.log(error);
        });
      } catch (err){
        console.log("Hubo un problema al agregar el usuario a la fila. " + err)
      }
    },

    variableVolver(state, numero){
      state.volver = numero;
      console.log(state.volver);
    },

    guardarFila(state, fila_nueva){
      state.filaconfig = fila_nueva;
      

    },

    obtenerFila(state, admin){ //obbtener la fila como un objeto
      try{
        state.admin.codigofila = "5f6bbf63d2c6822d31008c84"; //para probar 
        axios.get('http://localhost:1818/filavirtual/getbycodigo/5f6bbf63d2c6822d31008c84')// + state.admin.codigofila) //codigo fila es provisorio hasta saber como le van a póner al atributo codigo fila en admin
        .then(result =>{
          state.filaconfig = result.data;
          console.log(this.state.filaconfig);
          return result.data;
        }
          )
        .catch(function(error){
          console.log(error);
        });
      } catch (err){
        console.log("Hubo un problema al obtenerFila " + err)
      }
    },

    modificarhoraback(state, filaconfig){
      state.filaconfig.horaInicio = this.filaconfig.horaInicio;
      state.filaconfig.horaTermino = this.filaconfig.horaTermino;

      try{
        axios.post('http://localhost:1818/filavirtual/edit', this.filaconfig)
        .then(response =>{
          console.log(response);
        }
          )
        .catch(function(error){
          console.log(error);
        });
      } catch (err){
        console.log("Hubo un problema al modificar hora " + err)
      }
    }
  },

  actions: {
  },
  modules: {
  },
})
