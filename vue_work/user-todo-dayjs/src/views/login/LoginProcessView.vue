<template>
	<div class="flex flex-col justify-center items-center min-height-80">
		<h1>Oauth</h1>
		<template v-if="loginCheck">
			<div>
				<h1>로그인에 성공하셨습니다.</h1>
				<router-link to="/">홈으로</router-link>
			</div>
		</template>
	</div>
</template>

<script setup>
import { watchEffect } from 'vue';
import { useRoute } from 'vue-router';
import { login, loginCheck } from '@/api/loginApi';
import { useUserStore } from '@/stores/user';

const useStore = useUserStore();
const route = useRoute();

watchEffect(async () => {
	// console.log('code = ', route.query.code);
	if (route.query.code) {
		const data = await login(route.query.code);
		localStorage.setItem('token', data);
		const res = await loginCheck();
	if (res.status.toString().startsWith('2')) {
		console.log(res.data);
		useStore.login(res.data);
	}
	}
});
</script>

<style lang="scss" scoped></style>