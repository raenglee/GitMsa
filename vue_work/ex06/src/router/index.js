import { createRouter, createWebHistory } from 'vue-router'
import TheHome from '@/views/TheHome.vue';  // @->src 밑
import TheUser from '@/views/TheUser.vue';
import TheFreeBoardInput from '@/views/freeboard/TheFreeBoardInput.vue';
import TheFreeBoardList from '@/views/freeboard/TheFreeBoardList.vue';
import TheFreeBoardView from '@/views/freeboard/TheFreeBoardView.vue';
import TheFreeBoardUpdate from '@/views/freeboard/TheFreeBoardUpdate.vue';
import TheFileUpload from '@/views/TheFileUpload.vue';

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
      path: '/freeboardinput',
      name: 'freeboardinput',
      component: TheFreeBoardInput
    },
    {
      path: '/freeboardupdate',
      name: 'freeboardupdate',
      component: TheFreeBoardUpdate
    },
    {
      path: '/freeboardlist',
      name: 'freeboardlist',
      component: TheFreeBoardList
    },
    {
      path: '/freeboardview/:idx',
      name: 'freeboardview',
      component: TheFreeBoardView,
    },
    {
      path: '/fileupload',
      name: 'fileupload',
      component: TheFileUpload
    }
  ]
})

export default router
