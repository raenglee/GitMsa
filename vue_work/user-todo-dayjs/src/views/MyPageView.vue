<template>
	<div class="flex flex-col items-center justify-center gap-4 p-6 rounded-lg shadow-lg min-height-80">
		<div class="flex flex-col items-center justify-center">
			<h1 class="text-5xl my-10">MyPageView</h1>
			<h1>EMAIL = {{ userStore.email }}</h1>
			<h1>nickName = {{ userStore.nickName }}</h1>
			<h1>userId = {{ userStore.userId }}</h1>
			<img class="w-64 my-10 rounded-full" :src="userStore.profileImage" />
		</div>
		<div @click="kakaoLogout()" class="px-4 py-2 text-sm text-white bg-red-500 rounded-full cursor-pointer hover:bg-red-600 transition-all">
			로그아웃
		</div>
	</div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';

const router = useRouter();
const userStore = useUserStore();

const kakaoLogout = () => {
	localStorage.removeItem('token');
	userStore.logout();
	router.push('/');
	alert('로그아웃 성공');
};
</script>

<style lang="scss" scoped></style>
