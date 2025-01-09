setTimeout(() => {
  console.log("test 3초후 실행");
}, 3000);

setTimeout(() => {
  console.log("2초 뒤에 실행");
}, 2000);

const aa = setInterval(() => {
  console.log("2초 마다 실행");
}, 2000);

setTimeout(() => {
    clearInterval(aa);
    console.log("8초 뒤에 2초마다 했던 인터벌을 날리는것");
  }, 8000);

console.log("출력됩니다.");
