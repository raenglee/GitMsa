<template>
  <div>
    <h1>TheInsert</h1>
    <button @click="userSend">전송</button>
  </div>
</template>

<script>
export default {
  setup() {
    const mydata = {
       "name": "대박",
        "age": 695,
        "email": "hhh@naver.com",
        "password": "password",
        "wdate": "2024-09-06T11:52:47.301447"
    }
    const userSend = () => {
      fetch('http://localhost:8080/user/insert',{
        method:"POST",
        headers:{ 'Content-Type':'application/json' },
        body:JSON.stringify(mydata)
        })
        .then(res => {
          console.log(res);
        })
    }
    return { userSend }
  }
}
</script>

<style lang="scss" scoped></style>
