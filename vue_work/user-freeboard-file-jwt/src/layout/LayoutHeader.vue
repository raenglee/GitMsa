<template>
  <div>
    <header>
      <div class="p-5 bg-violet-300 text-white text-3xl">
        <nav class="flex justify-between">
          <div class="flex space-x-5">
            <div>
              <RouterLink to="/">메인</RouterLink>
            </div>
            <div>
              <RouterLink to="/userlist">회원목록</RouterLink>
            </div>

            <div class="group relative">
              <RouterLink to="/freeboardlist">자유게시판</RouterLink>
              <div
                class="opacity-0 group-hover:opacity-100 transition absolute bg-violet-300 p-5 top-8 -left-5 rounded"
              >
                <div>
                  <RouterLink to="/freeboardlist">FreeBoardList</RouterLink>
                </div>
                <div>
                  <RouterLink to="/freeboardinput">FreeBoardinput</RouterLink>
                </div>
              </div>
            </div>

            <div class="group relative">
              <RouterLink to="/fileupload">파일</RouterLink>
              <div
                class="opacity-0 group-hover:opacity-100 transition absolute bg-violet-300 p-5 top-8 -left-5 rounded"
              >
                <div>
                  <RouterLink to="/fileupload">fileupload</RouterLink>
                </div>
                <div>
                  <RouterLink to="/fileuploads">fileuploads</RouterLink>
                </div>
                <div>
                  <RouterLink to="/filedownload">filedownload</RouterLink>
                </div>
              </div>
            </div>
          </div>

          <template v-if="loginPinia.loginCheck">
            <div class="flex space-x-5">
            <h1>안녕하세요 {{loginPinia.name}} 님</h1>
            <button @click="logout">로그아웃</button>
          </div>
          </template>
          <template v-else>
            <div class="flex space-x-5">
              <div>
                <RouterLink to="/join">회원가입</RouterLink>
              </div>
              <div>
                <RouterLink to="/login">로그인</RouterLink>
              </div>
            </div>
          </template>
        </nav>
      </div>
    </header>
  </div>
</template>

<script setup>
import { doLoginCheck } from '@/api/loginApi';
import { useLoginStore } from '@/store/loginPinia';
import { watchEffect } from 'vue';
import { RouterLink } from 'vue-router';

const loginPinia = useLoginStore();
const logout = () => {
  localStorage.removeItem("token");
  loginPinia.logout();
}

watchEffect(async () => {
  const result = await doLoginCheck();
  if (result == false) {
    loginPinia.logout();
  } else {
    if (result.status == 200) {
      loginPinia.login(result.data);
    } else if (result.status == 401) {
      localStorage.removeItem('token');
      loginPinia.logout();
    }
  }
});
</script>


<style lang="scss" scoped></style>
