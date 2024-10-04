import { createRouter, createWebHistory } from 'vue-router'
import TheHome from '@/views/TheHome.vue';  // @->src 밑

import TheFreeBoardInput from '@/views/freeboard/TheFreeBoardInput.vue';
import TheFreeBoardList from '@/views/freeboard/TheFreeBoardList.vue';
import TheFreeBoardView from '@/views/freeboard/TheFreeBoardView.vue';
import TheFreeBoardUpdate from '@/views/freeboard/TheFreeBoardUpdate.vue';

import TheUserList from '@/views/users/TheUserList.vue';

import TheFileUpload from '@/views/file/TheFileUpload.vue';
import TheFileUploads from '@/views/file/TheFileUploads.vue';
import TheFileDownload from '@/views/file/TheFileDownload.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: TheHome
    },
    {
      path: '/userlist',
      name: 'userlist',
      component: TheUserList
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
    },
    {
      path: '/fileuploads',
      name: 'fileuploads',
      component: TheFileUploads
    },
    {
      path: '/filedownload',
      name: 'filedownload',
      component: TheFileDownload
    }
  ]
})

export default router
