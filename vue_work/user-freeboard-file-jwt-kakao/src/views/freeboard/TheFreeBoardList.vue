<template>
  <div class="pb-10">
    <h1 class="h1-red">FreeBoardList</h1>
    <div class="px-5">
      <table class="border border-b-gray-500 w-full">
        <thead>
          <tr>
            <th class="border text-center text-lg p-2">IDX</th>
            <th class="border text-center text-lg p-2">title</th>
            <th class="border text-center text-lg p-2">author</th>
            <th class="border text-center text-lg p-2">regdate</th>
            <th class="border text-center text-lg p-2">viewcount</th>
            <th class="border text-center text-lg p-2">img</th>
          </tr>
        </thead>
        <tbody>
          <!-- && <- 앞에꺼 true 이면 뒤에꺼 확인해봅니다. -->
          <!-- || <- 앞에꺼 false 이면 뒤에꺼 확인해봅니다. -->
          <template v-if="arr && arr.length>0">
            <tr
              v-for="item in arr"
              :key="item.idx"
              class="cursor-pointer hover:bg-slate-200"
              @click="viewPage(item.idx)"
            >
              <td class="border text-center text-lg p-2">{{ item.idx }}</td>
              <td class="border text-center text-lg p-2">{{ item.title }}</td>
              <td class="border text-center text-lg p-2">{{ item.creAuthor }}</td>
              <td class="border text-center text-lg p-2">{{ item.regDate }}</td>
              <td class="border text-center text-lg p-2">{{ item.viewCount }}</td>
              <template v-if="item.list[0]">
                <td class="border">
                  <img :src="`${GLOBAL_URL}/file/download/${item.list[0].name}`" alt="" srcset="" width="150">
                </td>
              </template>
              <template v-else>
                <td class="border"></td>
              </template>
            </tr>
          </template>
        </tbody>
      </table>
    </div>
    <div class="flex justify-center mt-5">
      <ul class="flex space-x-2">
        <li
          class="cursor-pointer p-3"
          v-for="num in totalPages"
          v-bind:key="num"
          @click="setPageNum(num - 1)"
        >
          {{ num }}
        </li>
      </ul>
    </div>

    <div v-if="temp">
      <h1>나올수도 있고...</h1>
    </div>
    <div>
      <button @click="changeTemp">나오게..하기</button>
    </div>
  </div>
</template>

<script setup>
import { ref, watchEffect } from 'vue';
import { useRouter } from 'vue-router';
import { GLOBAL_URL } from '@/api/util';
import { getFreeBoard } from '@/api/freeboardApi';

const temp = ref(null);
const changeTemp = ()=>{ temp.value = !temp.value }

const router = useRouter();
const arr = ref([]);
const totalPages = ref(10);
const pageNum = ref(0);

const setPageNum = async(num) => {
  pageNum.value = num;
  const res = await getFreeBoard(num);
  arr.value = res.data.list;
  totalPages.value = res.data.totalPages;
};

const viewPage = (idx) => {
  const data = { name: 'freeboardview', params: { idx } };
  router.push(data);
};

watchEffect(async()=>{
  const res = await getFreeBoard();
  arr.value = res.data.list;
  totalPages.value = res.data.totalPages;
})
</script>

<style scoped></style>
