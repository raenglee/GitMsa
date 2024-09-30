<template>
  <div class="overlay" :class="{ isModal: isModal }"></div>
  <div class="modal p-5 rounded" :class="{ isView: isModal }">
    <h1 class="text-5xl">User 수정</h1>
    <div class="cursor-pointer p-5 m-5 w-80 bg-slate-500 text-white rounded">
        <h1>회원 번호 = {{ idx }}</h1>
        <h1>이름 = <input type="text" v-model="name" class="p-1
                                                           border border-gray-300 rounded-lg
                                                           shadow-sm
                                                           focus:outline-none
                                                           focus:ring-2
                                                           focus:ring-blue-500
                                                           focus:border-blue-500
                                                           text-gray-700"></h1>
        <h1>이메일 = {{ email }}</h1>
        <h1>가입날짜 = {{ wdate }}</h1>
    </div>
    <div class="flex space-x-5 justify-center">
    <button 
    class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
    @click="modalUser">취소</button>
    <button
    class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
    @click="modalUser('save')">저장</button>
  </div>
</div>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
    <div class="flex flex-wrap">
      <div
        @click="modalUser(item)"
        class="cursor-pointer p-5 m-5 w-80 bg-slate-500 text-white rounded"
        v-for="item in arr"
        :key="item.idx"
      >
          <h1>회원 번호 = {{ item.idx }}</h1>
          <h1>이름 = {{ item.name }}</h1>
          <h1>이메일 = {{ item.email }}</h1>
          <h1>가입날짜 = {{ item.wdate }}</h1>
          <h1>작성한 글 = {{ item.list.length }}</h1>
          <button @click.stop="doDelete(item.idx)">삭제</button>
          <!--스탑 -> dodelete만 뜨도록 함 div안에 버튼 두개라서 한개만 열리도록 하는것-->
      </div>
    </div>
  </div>
</template>

<script setup>
import { getUsers, saveUser } from '@/api/userApi'
import { ref, watchEffect } from 'vue'

const arr = ref([])

const idx = ref('');
const name = ref('');
const wdate = ref('');
const email = ref('');

const isModal = ref(false)
const doDelete = () => {
  console.log("doDelete");
}
const modalUser = async (item) => {
  isModal.value = !isModal.value;

  if(item == 'save'){
    const result = await saveUser({
                                  idx:idx.value,
                                  name:name.value,
                                  email:email.value,
                                  password:"마이패스워드"
                                });
    //update해야함, axios
    alert('수정하였습니다.'+result);
    return;
  }

  idx.value = item.idx;
  name.value = item.name;
  email.value = item.email;
  wdate.value = item.wdate;
};

//watch안에 있는 함수 즉시 실행
//await 쓰려면 async 필요 (await = 완벽하게 뜰 때 까지 기다리라는 명령어)
watchEffect(async () => {
  const retValue = await getUsers()
  //  console.log("retValue = "+JSON.stringify(retValue.data))
  arr.value = retValue.data
  // console.log(arr.value)
})
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: skyblue;
}

.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  background-color: rgb(0, 0, 0, 0.2);
  display: none;
}

.isModal {
  display: block;
}

.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: white;
  z-index: 1001;
  display: none;
}

.isView {
  display: block;
}
</style>
