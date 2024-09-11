<template>
  <div class="max-w-md w-full bg-white p-8 rounded-lg shadow-md">
    <h2 class="text-2xl font-bold mb-6 text-gray-800">회원가입</h2>
    <form>
      <div class="mb-4">
        <label for="name" class="block text-gray-700 text-sm font-medium mb-2"
          >이름</label
        >
        <input
          type="text"
          id="name"
          v-model="name"
          class="w-full px-3 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
          placeholder="이름을 입력하세요"
        />
      </div>
      <div class="mb-4">
        <label for="email" class="block text-gray-700 text-sm font-medium mb-2"
          >이메일</label
        >
        <input
          type="email"
          id="email"
          v-model="email"
          class="w-full px-3 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
          placeholder="이메일을 입력하세요"
        />
      </div>
      <div class="mb-4">
        <label
          for="password"
          class="block text-gray-700 text-sm font-medium mb-2"
          >비밀번호</label
        >
        <input
          type="password"
          id="password"
          v-model="password"
          class="w-full px-3 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
          placeholder="나이를 입력하세요"
        />
      </div>
      <div class="mb-4">
        <label
          for="age"
          class="block text-gray-700 text-sm font-medium mb-2"
          >나이</label
        >
        <input
          type="number"
          id="age"
          v-model="age"
          class="w-full px-3 py-2 border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-500"
        />
      </div>
      <button
        type="button"
        @click="save"
        class="w-full bg-blue-500 text-white py-2 px-4 rounded-lg shadow-sm hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500"
      >
        회원가입
      </button>
    </form>
  </div>
</template>

<script setup>
import axos from "axios";
import { ref } from "vue";

//fetch -> method:"POST", content-type:APPLICATION... 등 적어야했는데
//axois는 안적어도 됨

const name = ref('');
const age = ref('');
const email = ref('');
const password = ref('');

const save = () => {
  const data = {
    name:name.value,
    age:age.value,
    email:email.value,
    password:password.value,
  };
  alert(JSON.stringify(data));
axios.post("http://localhost:8080/user/insert", data)
  .then((res) => {console.log(res)})
  .catch((e) => {console.log(e);});
  }
</script>

<style lang="scss" scoped></style>
