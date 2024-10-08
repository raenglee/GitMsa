<template>
  <div>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img
        src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
        width="222"
        alt="카카오 로그인 버튼"
      />
    </a>
    <div @click="kakaoLogout()">로그아웃</div>
  </div>
</template>

<script setup>
import { watchEffect } from "vue";
import { useRoute } from "vue-router";
import axios from "axios";

const route = useRoute();

const kakaoLogin = () => {
  window.Kakao.Auth.authorize({
    redirectUri: "http://localhost:5173/kakaologin",
  });
};

watchEffect(() => {
  if (route.query.code) {
    axios.get("http://localhost:10000/kakao/login?code=" + route.query.code)
  .then((response) => {
    console.log(response.data);
  })
  .catch((error) => {
    console.log(error);
  });
  }
});

const kakaoLogout = () => {
  window.Kakao.Auth.logout((res) => {
    console.log(res);
  });
};


</script>
