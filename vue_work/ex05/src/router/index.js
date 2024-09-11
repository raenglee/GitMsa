import TheHome from '@/views/TheHome.vue';
import TheJoin from '@/views/TheJoin.vue';
import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {path:'/',component: TheHome},
    {path: '/join', component: TheJoin} ]
});
export default router;