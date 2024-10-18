<template>
  <div>
<h1>LOGIN</h1>
<div class="flex flex-col items-center justify-center gap-4 p-6 rounded-lg shadow-lg min-height-80">
   <a id="custom-login-btn" @click="kakaoLogin()" class="transition-transform transform hover:scale-105">
      <img
         src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
         width="222"
         alt="카카오 로그인 버튼"
         class="rounded-lg shadow-md"
      />
   </a>
   <div
      @click="kakaoLogout()"
      class="px-4 py-2 text-sm text-white bg-red-500 rounded-full cursor-pointer hover:bg-red-600 transition-all"
   >
      로그아웃
   </div>
</div>

  </div>
</template>

<script setup>
const kakaoLogin = () => {
  window.Kakao.Auth.authorize({
  redirectUri: 'http://localhost:5173/oauth',
  });
};
const kakaoLogout = () => {
  window.Kakao.Auth.logout();
  // localStorage.removeItem('kakaoToken');
  // alert('로그아웃 되었습니다.');
};
  
</script>

<style lang="scss" scoped>

</style>