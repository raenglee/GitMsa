<template>
  <div>
    <h1 class="h1-red">TheFileUpload</h1>
    <div class="p-5">
      <button
        class="px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
        type="button"
        @click="save"
      >
        전송
      </button>
    </div>
    <div @dragover.prevent="" @drop.prevent="dropFile" class="p-5 bg-slate-400">
      <h1 class="w-full bg-white py-3 my-2 text-center">여기에 파일을 올리세요</h1>
      <div v-for="file in myfile" v-bind:key="file">
        file = {{ file.name }}
      </div>
      <div>
      </div>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';

const myfile = ref([]);

const dropFile = (e)=>{
  myfile.value = [];
  const data = e.dataTransfer;
  for(let i=0; i<data.files.length; i++){
    alert(data.files[i].name);
    myfile.value.push(data.files[i]);
  }
}

const save = () => {
  if (!myfile.value.length) {
    alert('파일을 선택하세요');
    return;
  }

  const formData = new FormData();

  for (const file of myfile.value) {
    formData.append('files', file); // Append multiple files
  }

  formData.append(
    'fileDto',
    new Blob([JSON.stringify({ name: 'filename' })], { type: 'application/json' })
  );

  axios
    .post('http://localhost:10000/file/uploads', formData, {
      headers: {
        'Content-Type': 'multipart/form-data'
      }
    })
    .then((res) => {
      console.log(res);
    })
    .catch((e) => {
      console.log(e);
    });
};
</script>

<style lang="scss" scoped></style>
