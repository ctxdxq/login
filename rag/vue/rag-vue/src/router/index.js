import { createRouter, createWebHistory } from 'vue-router'
import Layout from "@/layout/Layout.vue";

const routes = [
  {
    path: '/',
    name: 'layout',
    component: Layout,
    redirect: "/home",  //重定向，自动跳转
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () =>import("@/views/HomeView.vue")
      }
    ]
  },
  {
    path: '/Login',
    name: 'Login',
    component: () =>import("@/views/Login")
  },
  {
    path: '/Register',
    name: 'Register',
    component: () =>import("@/views/Register")
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
