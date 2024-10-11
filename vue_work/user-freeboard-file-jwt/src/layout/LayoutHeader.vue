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

          <template v-if="loginCheck">
            <div>안녕하세요</div>
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
import { ref, watchEffect } from 'vue'
import { RouterLink } from 'vue-router'

const loginCheck = ref(false)
watchEffect(() => {
    const result = doLoginCheck();
    if(result==false){
        loginCheck.value = false;
    } else{
        console.log(result);
        loginCheck.value = true;
    }
})
</script>

<style lang="scss" scoped></style>
