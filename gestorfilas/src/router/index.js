import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import(/* webpackChunkName: "about" */ '../views/Home.vue')
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/iniciarfila',
    name: 'iniciarfila',
    component: () => import(/* webpackChunkName: "about" */ '../views/initfila.vue')
  },
  {
    path: '/IngresoUsuario',
    name: 'IngresoUsuario',
    component: () => import(/* webpackChunkName: "about" */ '../views/IngresoUsuario.vue')
  },
  {
    path: '/administrarFila',
    name: 'AdministrarFila',
    component: () => import(/* webpackChunkName: "about" */ '../views/administrarFila.vue')
  },
  {
    path: '/confila',
    name: 'configfila',
    component: () => import(/* webpackChunkName: "about" */ '../views/confila.vue')
  },
  {
    path: '/ingresado',
    name: 'ingresado',
    component: () => import(/* webpackChunkName: "about" */ '../views/UsuarioIngresado.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
