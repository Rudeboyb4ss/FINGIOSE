import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex,axios)

export default new Vuex.Store({
  state: {
    admin:{},
    fila:{},
    nuevo_user: {
      rut: null,
      nombre: null,
      correo: null,
    },
    codigoFila: "5f6bca45977c940a559d413d", //por mientras
    user_fila:{
    user: null,
    codigo: null,
  }

  },
  mutations: {

      getFila:function(state)
      {
        axios.get("http://localhost:1818/admin/getbyrut/6666666666666").then((result) => {
          console.log(result.data);
          state.admin = result.data;
          state.codigoFila = result.data.codigoFila;
          console.log(result.data.nombre);
          console.log(state.codigoFila);
          axios.put("http://localhost:1818/filavirtual/editarestado/" + result.data.codigoFila)
          
        })
      },

      getTurnoActual:function(state)
      {
        console.log(state.codigoFila);
        //console.log(state.admin.codigoFila);
        axios.get("http://localhost:1818/filavirtual/getbycodigo/" + state.codigoFila).then((result) => {
          state.fila = result.data;
          state.codigoFila = state.fila.codigo;
          //console.log(state.fila);
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

      getFilaYPausar:function(state)
      {
        axios.get("http://localhost:1818/admin/getbyrut/6666666666666").then((result) => {
          console.log(result.data);
          state.admin = result.data;
          state.codigoFila = result.data.codigoFila;
          console.log(result.data.nombre);
          console.log(state.codigoFila);
          axios.put("http://localhost:1818/filavirtual/editarpausada/" + result.data.codigoFila).then((result) => {
            state.fila = result.data;
          })
          
          
        })
      },

      pasarTurnoActual:function(state)
      {
        axios.put("http://localhost:1818/filavirtual/pasarturno/" + state.codigoFila).then((result) => {
          state.fila = result.data;
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
    }
  },

  actions: {
  },
  modules: {
  },
})
