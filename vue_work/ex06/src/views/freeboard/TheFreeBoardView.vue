<template>
  <div>
    <h1 class="h1-red">TheFreeBoardView</h1>
    <div class="p-5">
      <div class="border border-b-slate-400 rounded p-5">
        <h1 class="font-bold">
          글 제목 <span class="font-normal">{{ title }}</span>
        </h1>
        <hr class="my-3" />
        <h1>글 내용</h1>
        <p class="h-64">{{ content }}</p>
        <h1>작성일자{{ regDate }}</h1>
        <h1>작성자{{ creAuthor }}</h1>
      </div>
    </div>
    <div class="flex justify-between mt-5">
      <button
        class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
        @click="pageMove(idx)">
        수정
      </button>
      <button
        class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
        @click="doDelete(idx)">
        삭제
      </button>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();
const title = ref('초기값');
const content = ref('초기값');
const regDate = ref('초기값');
const creAuthor = ref('초기값');
const idx = ref(0);

const doDelete = (idx) => {
  console.log(idx)
  axios
    .delete(`http://localhost:8080/freeboard/delete/${idx}`)
    .then(res => {
      alert(res.data);
      if(res.status=='200'){
        router.push({name:"freeboardlist"})
      }
    })
    .catch(e => console.log(e));
}

const pageMove = () => {
  router.push({name:"freeboardinput", query: { idx:idx.value }});
}

const getFreeBoard = () => {
  axios.get(`http://localhost:8080/freeboard/view/${route.params.idx}`)
    .then(res => {
      title.value = res.data.title;
      content.value = res.data.content;
      regDate.value = res.data.regDate;
      creAuthor.value = res.data.creAuthor;
      idx.value = res.data.idx;
    })
    .catch(e => {
      console.log(e);
      alert(e.response.data.message);
      router.push({ name: 'freeboardlist' });
    })
}

//호출 안해주면 '초기값'만 나옴
getFreeBoard();

</script>

<style lang="scss" scoped></style>
