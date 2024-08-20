var heading = document.querySelector("#heading"); // var은 변수명, 변수선언
var btn = document.querySelector("#btn");

heading.onclick = function () {
  heading.style.color = "red"; // 글자 색 변경
  heading.innerHTML = "글자 변경하기"; // 글자 변경
  heading.style.backgroundColor = "blue"; // 글자배경색 변경
  heading.style.textAlign = "center"; // 글자 중앙으로 변경
  heading.style.fontSize = "100px";
}; //온클릭시 doA함수실행

btn.onclick = function () {
  var name = prompt("당신의 이름은?", "이름");
  alert(name);
};
