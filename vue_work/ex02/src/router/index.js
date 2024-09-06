import { createRouter, createWebHistory } from 'vue-router'
import TheCounter from '@/views/TheCounter.vue'
import TheWelcome from '@/views/TheWelcome.vue'
import TheInsert from '@/views/TheInsert.vue'
import TheSelect from '@/views/TheSelect.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'counter',
      component: TheCounter
    },
    {
      path: '/welcome',
      name: 'welcome',
      component: TheWelcome
    },
    {
      path: '/insert',
      name: 'insert',
      component: TheInsert
    },
    {
      path: '/select',
      name: 'select',
      component: TheSelect
    }
  ]
})

export default router
