<template>
  <div>
    <h1>count={{count}}</h1>
    <button @click="addCount">증가</button>
  </div>
</template>

<script>
import {ref} from 'vue';
export default {
  setup () {
    const count = ref(0);  // import ref와 value 덕분에 반응형 변수 됨
    const addCount = () => {
      // console.log('can?') 함수 되나 확인하는 문장
      count.value=count.value+1;
    }
    return{count,addCount}
  }
}
</script>

<style lang="scss" scoped>

</style>