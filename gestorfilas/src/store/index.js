import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex,axios)

export default new Vuex.Store({
  state: {
    fila:{},
    admin:null,
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
  actions: {
  },
  modules: {
  }
})
