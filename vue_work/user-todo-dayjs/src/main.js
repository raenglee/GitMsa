import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

const app = createApp(App)

app.use(createPinia())
app.use(router)

window.Kakao.init('559f5a4dc876ebc08334fa9126719be9'); // 사용하려는 앱의 JavaScript 키 입력
app.mount('#app')
