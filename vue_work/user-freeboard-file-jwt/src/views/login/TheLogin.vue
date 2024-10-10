<template>
    <div class="bg-gray-100 flex items-center justify-center min-height-100">
        <div class="bg-white p-8 rounded-lg shadow-md w-96">
        <h2 class="text-2xl font-bold mb-6 text-center">로그인</h2>
        
        <form @submit.prevent="submitLogin">
            <div class="mb-4">
                <label for="email" class="block text-sm font-medium text-gray-700">이메일</label>
                <input type="email"
                        v-model="email"
                        id="email" name="email" required 
                        class="mt-1 p-2 border border-gray-300 rounded w-full" 
                        placeholder="이메일을 입력하세요">
            </div>
            <div class="mb-4">
                <label for="password" class="block text-sm font-medium text-gray-700">비밀번호</label>
                <input type="password"
                        v-model="password"
                        id="password" name="password" required 
                        class="mt-1 p-2 border border-gray-300 rounded w-full" 
                        placeholder="비밀번호를 입력하세요">
            </div>
            <button type="submit" 
                    class="w-full bg-blue-600 text-white p-2 rounded hover:bg-blue-700">로그인</button>
        </form>

        <p class="mt-4 text-center text-sm text-gray-600">계정이 없으신가요? <a href="#" class="text-blue-600 hover:underline">회원가입</a></p>
    </div>
    </div>
</template>

<script setup>
import { doLogin } from '@/api/loginApi';
import { ref } from 'vue';
// email 변수에 초기값 설정
const email = ref('aaa@naver.com');
// password 변수에 초기값 설정
const password = ref('1234');

const submitLogin = async () => {
    const data = { "email": email.value, "password": password.value };
    const res = await doLogin(data);
    localStorage.setItem('token', res.data);
    if(res.status==20){
        alert("로그인 성공");
    }
}
</script>

<style lang="scss" scoped>

</style>