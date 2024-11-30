import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import JobDetailView from '../views/JobDetailView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/postJob',
    name: 'postJob',
    component: () => import('../views/PostJobView.vue')
  },
  {
    path: '/job/detail/:id',
    name: 'job.detail',
    props: true,
    component:JobDetailView,
  },
]

const router = new VueRouter({
  routes
})

export default router
