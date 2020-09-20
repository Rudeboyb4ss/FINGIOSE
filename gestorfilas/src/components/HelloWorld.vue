<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <button v-on:click="click"> 
      click
    </button>
    
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }, 
  methods:{
    click: () => {
      axios.get("https://jsonplaceholder.typicode.com/todos/1").then((result ) => {console.log("result:  ", result)}).catch(e => {console.log("Error: ",e)})
      //axios.get("localhost:8080").then((result ) => {console.log("result:  ", result)}).catch(e => {console.log("Error: ",e)})
      }
  }
}
</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
