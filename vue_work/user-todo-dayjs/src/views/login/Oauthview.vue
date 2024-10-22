<template>
	<div>
		<h1>Oauth</h1>
	</div>
</template>

<script setup>
import { watchEffect } from 'vue';
import { useRoute } from 'vue-router';
import { login } from '@/api/lognApi';

const route = useRoute();

watchEffect(async () => {
	console.log('code = ', route.query.code);
	if (route.query.code) {
		const data = await login(route.query.code);
		console.log('data = ', data);
	}
});
</script>

<style lang="scss" scoped></style>