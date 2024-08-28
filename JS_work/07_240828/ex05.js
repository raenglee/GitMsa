const doA = (a, b = 20, c = 30) => {
  console.log(`a = ${a}`);
  console.log(`b = ${b}`);
  console.log(`c = ${c}`);
}

doA();

// doB 함수 선언
function doB(){}  // 옛날 방식
// doC 함수 선언
const doC = function () { }  // 이 방식을 많이 씀 / 여기에서 this = onclick 했을 때 this는 버튼태그가 됨
const doD = () => { } // 여기에서 this는 다르다 = window객체가 this가 됨