import './assets/main.css'

// import {aa} from './AA';
import { createApp } from 'vue'
import App from './App.vue'
// import TheHome from './views/TheHome.vue'
import router from './router/index.js'

// todo 
window.Kakao.init("qwerqwer");

const app = createApp(App)

app.use(router)

app.mount('#QWER')
