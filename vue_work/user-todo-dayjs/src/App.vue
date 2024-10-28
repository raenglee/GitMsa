<script setup>
import { RouterLink, RouterView } from 'vue-router';

// nav 위치 설정
import TheLayoutNav from './components/TheLayoutNav.vue';
</script>

<template>
	<!-- ...사용한 곳...-->
	<TheLayoutNav />

	<RouterView />
</template>
<style scoped></style>
