<template>
	<div class="flex flex-col justify-center items-center min-height-80">
		<h1 class="text-3xl">나에게 카톡 보내기</h1>
		<input
			v-model="message"
			type="text"
			class="block min-w-80 px-3 py-2 my-5 text-gray-700 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500"
			placeholder="메시지를 입력하세요."
		/>
		<button
			@click="sendMessage"
			class="inline-flex items-center px-4 py-2 text-sm font-medium text-white bg-blue-600 border border-transparent rounded-md shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-blue-500"
		>
			Send Message
		</button>
	</div>
</template>

<script setup>
import { msgSend } from '@/api/loginApi';
import { ref } from 'vue';
const message = ref('');
const sendMessage = async () => {
	const token = localStorage.getItem('token');
	if (!token) {
		alert('로그인하셔야 메시지를 보낼수 있습니다.');
		return;
	}
	const res = await msgSend(message.value);
	if (res.status.toString().startsWith('2')) {
		alert('메시지 성공');
		message.value = '';
	} else {
		alert('메시지 전송 실패');
	}
};
</script>

<style lang="scss" scoped></style>
