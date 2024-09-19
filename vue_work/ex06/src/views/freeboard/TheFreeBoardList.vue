<template>
 <div class="pb-10">
    <h1 class="h1-red">FreeBoardList</h1>
    <div class="px-5">
    <table class="border border-b-gray-500 w-full">
      <thead>
        <tr>
          <th class="border">IDX</th>
          <th class="border">title</th>
          <th class="border">author</th>
          <th class="border">regdate</th>
          <th class="border">viewcount</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in arr" :key="item.idx">  <!--arr 값 가져옴, key는 유니크한 값을 적어주어야함 (ex idx)-->
      <td class="border text-center">{{item.idx}}</td>
      <td class="border text-center">{{item.title}}</td>
      <td class="border text-center">{{item.creAuthor}}</td>
      <td class="border text-center">{{item.regDate}}</td>
      <td class="border text-center">{{item.viewCount}}</td>
        </tr>
      </tbody>
    </table>
    </div>    
  </div>

</template>

<script setup>
import axios from 'axios'
import { ref } from 'vue';
import {useRoute} from 'vue-router';

const route = useRoute();  //주소줄에있는 파라미터 가져오는것
const arr = ref ([ ]);

console.log("route.params.aa= "+route.params.aa);  //파람즈에있는 aa값 출력
console.log("route.params.bb= "+route.params.bb);

axios.get('http://localhost:8080/freeboard')
.then(res=>{
  console.log(res.data);
  arr.value = res.data;
})
.catch(e=>{
  console.log(e);
})

</script>

<style>

</style>
