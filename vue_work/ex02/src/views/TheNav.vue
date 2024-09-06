<template>
  <div>
    <a href="/">home</a>
    <RouterLink to="/">home</RouterLink>
    <RouterLink to="/welcome">welcome</RouterLink>
    <RouterLink to="/insert">insert</RouterLink>
    <RouterLink to="/select">select</RouterLink>
  </div>
</template>

<script>
export default {
  setup() {
    return {}
  }
}
</script>

<style lang="scss" scoped></style>
