<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <h1 class="text-5xl"></h1>
    <div class="p-5 bg-slate-500 text-white text-3xl">
      <nav class="flex space-x-5">
        <div>
        <RouterLink to="/">Home</RouterLink>
        </div>
        <div>
        <RouterLink to="/userlist">User</RouterLink>
        </div>
        <div class="group relative">
        <RouterLink to="/freeboardlist">FreeBoardList</RouterLink>
        <div class="opacity-0
                    group-hover:opacity-100
                    transition absolute
                    bg-slate-600
                    p-5 top-14
                    -left-3
                    rounded">
          <div>
          <RouterLink to="/freeboardlist">FreeBoardList</RouterLink>
          </div>
          <div>
          <RouterLink to="/freeboardinput">FreeBoardInput</RouterLink>
          </div>
        </div>
        </div>
        <div>
          <RouterLink to="/fileupload">FileUpload</RouterLink>
          </div>
      </nav>
    </div>
    <RouterView />
  </header>

  
</template>

<style scoped>

</style>
