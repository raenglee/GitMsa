<template>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
    <div class="flex space-x-5">
    <div @click="modalUser" class="p-1 w-80 bg-slate-500 text-white" v-for="item in arr" :key="item.idx">
      <div>
        <h1>회원 번호 = {{ item.idx }}</h1>
        <h1>이름 = {{ item.name }}</h1>
        <h1>이메일 = {{ item.email }}</h1>
        <h1>가입날짜 = {{ item.wdate }}</h1>
        <h1>작성한 글 = {{ item.list.length }} </h1>
      </div>
    </div>
    </div>
  </div>
</template>

<script setup>
import { getUsers } from '@/api/userApi'
import { ref, watchEffect } from 'vue'

const arr = ref([])
const modalUser=()=>{
  
}
//watch안에 있는 함수 즉시 실행
//await 쓰려면 async 필요 (await = 완벽하게 뜰 때 까지 기다리라는 명령어)
watchEffect(async () => {
  const retValue = await getUsers()
  //  console.log("retValue = "+JSON.stringify(retValue.data))
  arr.value = retValue.data
  console.log(arr.value)
})
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: skyblue;
}
</style>
