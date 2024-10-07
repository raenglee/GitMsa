import './assets/main.css'

// import {aa} from './AA';
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

const app = createApp(App)  //시작 페이지

app.use(router)

app.mount('#app')
