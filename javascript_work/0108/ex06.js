function aa(p1, p2, ...p3) {
  console.log(p1);
  console.log(p2);
  console.log(p3);
}

aa(10, 20, { a: 20 }, { b: 30 }, 50);

console.log(typeof 20); // number
console.log(typeof 20); // number
console.log(typeof "문자열"); // string
console.log(typeof {}); // object
console.log(typeof []); // objcet
console.log(typeof (() => {})); // function

aaa = { a:10, b:20, id:'aaa@naver.com', pw:"abcd" }

console.log(aaa); // { a:10, b:20 } 모두 출력
delete aaa.a // { a:10, b:20 } 에서 a를 삭제
console.log(aaa); // { b:20 } 출력됨

// aaa = { a:10, b:20, id:'aaa@naver.com', pw:"abcd" }
// delete aaa.pw // pw 삭제되고 출력되는것
