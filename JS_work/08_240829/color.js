const mybgclass = ["bg-orange-400", "bg-green-400", "bg-yellow-400"];
const removeclass = () => {
  for (const element of mybgclass) {
    document.querySelector("#result").classList.remove(element);
  }  // 여러번 쓰이는 구문은 함수 선언하면 여기저기 호출 가능
};
document.querySelector("#orange").onclick = () => {
  removeclass();  //호출 한 것
  document.querySelector("#result").classList.add("bg-orange-400");
};
document.querySelector("#green").onclick = () => {
  removeclass();
  document.querySelector("#result").classList.add("bg-green-400");
};
document.querySelector("#yellow").onclick = () => {
  removeclass();
  document.querySelector("#result").classList.add("bg-yellow-400");
};