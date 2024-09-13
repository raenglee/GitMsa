import { createRouter, createWebHistory } from 'vue-router'
import TheHome from '@/views/TheHome.vue';
import TheUser from '@/views/TheUser.vue';
import TheFreeBoard from '@/views/TheFreeBoard.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: TheHome
    },
    {
      path: '/user',
      name: 'user',
      component: TheUser
    },
    {
      path: '/freeboard',
      name: 'freeboard',
      component: TheFreeBoard
    }
  ]
})

export default router
