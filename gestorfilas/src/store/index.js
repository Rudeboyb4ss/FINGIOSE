import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    nuevo_user: {
      rut: null,
      nombre: null,
      correo: null,
    }
  },
  mutations: {
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
