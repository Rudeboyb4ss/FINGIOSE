import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex,axios)

export default new Vuex.Store({
  state: {
    fila:{},
    admin:null,
    nuevo_user: {
      rut: null,
      nombre: null,
      correo: null,
    }
  },
  mutations: {
      getFila(state)
      {
        axios.get("http://localhost:1818/admin/getbyrut/12555555").then((result) => {
          state.admin = result.data;
          console.log(state.admin);
          state.fila = state.admin.fila;
          console.log(state.fila);
          axios.post("http://localhost:1818/filavirtual/editarestado", state.fila)
        })
      }
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
    }


  },
  actions: {
  },
  modules: {
  }
})
