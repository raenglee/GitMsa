<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/user">User</RouterLink>
        <RouterLink to="/freeboard">FreeBoard</RouterLink>
      </nav>
    </div>
    <RouterView />
  </header>

  
</template>

<style scoped>

</style>
