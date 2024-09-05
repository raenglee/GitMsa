<template>
  <div>
    <h1>안녕</h1>
<MyAA name="홍길동"></MyAA>
<MyAA name="김길동"></MyAA>
<MyAA name="이길동"></MyAA>

  </div>
</template>

<script>
//@는 jsconfig.jason에 적혀있는데, ./src/를 뜻하는 것 (소스파일 아래~)

import MyAA from '@/components/MyAA.vue'

export default {
components:{
  MyAA
},
setup () {
    return {MyAA}
  }
}
</script>

<style lang="scss" scoped>

</style>