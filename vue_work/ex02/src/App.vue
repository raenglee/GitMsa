<template>
  <div>
    <TheNav></TheNav>
    <RouterView></RouterView>
    <AA></AA>
  </div>
</template>

<script>
import TheNav from './views/TheNav.vue'
import AA from './views/AA.vue'
import { RouterView } from 'vue-router'

export default {
  components: {
    AA,
    RouterView,
    TheNav
  },
  setup() {
    return { AA, RouterView, TheNav }
  }
}
</script>

<style lang="scss" scoped></style>
