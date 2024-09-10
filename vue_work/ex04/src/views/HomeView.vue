<template>
  <div>
    <h1 class="text 5xl">Home</h1>
    <div class="p-5">
      <table class="border border-gray-500 w-full">
        <tr>
          <th class="border border gray-500">idx</th>
          <th class="border border gray-500">name</th>
          <th class="border border gray-500">age</th>
          <th class="border border gray-500">email</th>
          <th class="border border gray-500">password</th>
          <th class="border border gray-500">wdate</th>
        </tr>
        <tr v-for="user in list" v-bind:key="user.idx">
          <td class="border border gray-500"> {{ user.idx }} </td>
          <td class="border border gray-500"> {{ user.name }} </td>
          <td class="border border gray-500"> {{ user.age }} </td>
          <td class="border border gray-500"> {{ user.email }} </td>
          <td class="border border gray-500"> {{ user.password }} </td>
          <td class="border border gray-500"> {{ user.wdate }} </td>
        </tr>
      </table>
    </div>
    <button @click="select" class="bg-yellow-200 p-3 m-3 hover:bg-yellow-100 border border-gray-300">불러오기</button>
    <div v-for="num in mylist" v-bind:key="num">
      num = {{ num }}
      </div>
  <div class="p-5">
    name = <input class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" type="text" name="name" id="" v-model="name"><br>
    age = <input class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" type="number" name="age" id="" v-model="age"><br>
    password = <input class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" type="text" name="password" id="" v-model="password"><br>
    email = <input class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" type="text" name="email" id="" v-model="email"><br>
    <button @click="insert" class="bg-yellow-200 p-3 m-3 hover:bg-yellow-100 border border-gray-300">입력</button>
  </div>
</div>



</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const mylist = [10, 20, 30]
    const list = ref([
      {
        idx: 1,
        name: '바꿔바꿔바꿔바꿔바꿔',
        age: 100,
        email: '바꿔@naver.com',
        password: '1234',
        wdate: '2024-09-06T11:18:32.729596'
      }
    ])

const name = ref('');
const age = ref('');
const password = ref('');
const email = ref('');

//셀렉트 -> 백엔드에서 데이터를 가져옴
    const select = () => {
      fetch(`http://localhost:8080/user/select`)
      .then(res=>{
        return res.json();
      })
      .then(result => {
        list.value = result;
        // console.log(result);
      })
      .catch(e=>{
        console.log("예외가 발생했습니다.");
        console.log(e)
      })
    }      
    const insert = () => {
      const data = {
        name: name.value,
        age: age.value,
        password: password.value,
        email: email.value
      }

try{
fetch('http://127.0.0.1:8080/user/insert', {
  method: "POST",
  headers: {'Content-Type': 'application/json'},
  body: JSON.stringify(data)})
.then(res=>{
  if(!res.status.toString().startsWith('2'))
alert('입력을 실패 하였습니다.');
else{
  alert('입력되었습니다.');
}
})
}catch(e){
console.log(e);
};
}
    return { list, mylist, select, insert, name, age, password, email }
  }
}
</script>

<style lang="scss" scoped></style>
