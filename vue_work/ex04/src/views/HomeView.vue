<template>
  <div>
    <h1>Home</h1>
    <ul>
      <li v-for="user in list" v-bind:key="user.idx">idx={{ user.idx }} name={{ user.name }}</li>
    </ul>
    <button
      @click="select"
      class="bg-yellow-200 p-3 m-3 hover:bg-yellow-100 border border-gray-300"
    >
      불러오기
    </button>
    <div v-for="num in mylist" v-bind:key="num">num = {{ num }}</div>
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  setup() {
    const mylist = [10, 20, 30]
    const list = ref([
      {
        idx: 1,
        name: '바꿔바꿔바꿔바꿔바꿔',
        age: 100,
        email: '바꿔@naver.com',
        password: '1234',
        wdate: '2024-09-06T11:18:32.729596'
      },
      {
        idx: 2,
        name: '이게되네',
        age: 25,
        email: 'asdf@yahoo.com',
        password: 'qwer',
        wdate: '2024-09-06T11:32:44.718893'
      },
      {
        idx: 3,
        name: '홍길동',
        age: 100,
        email: 'qwer@naver.com',
        password: '1234',
        wdate: '2024-09-06T11:18:32.729596'
      }
    ])

    const select = () => {
      list.value = [{ idx: 1, name: '강제바꿈' }]
    }
    // fetch(`127.0.0.1:8080/user/select`)

    return { list, mylist, select }
  }
}
</script>

<style lang="scss" scoped></style>
