let arr = [1, 2, 3];
let brr = [4, 5, 6];
let myarr = [
  { age: 20, name: "홍길동" },
  { age: 30, name: "이길동" },
  { age: 40, name: "김길동" },
];
console.log(arr + brr);
console.log(arr.concat(brr));  // 배열 형태로 더하기


// filter: 주어진 함수에 predicate 람다 만들 시 true,false로 새로운 배열을 만듦
/*
자바에서의 작성법
list = arr.stream().filter(n->n%2==0).collect(newArraysList,(a,c)=>a.add(c),(1,2)->{})
*/
const crr = arr.filter((n) => n % 2 == 0);
console.log(crr);

const filterArr = myarr.filter(item => item.age > 20);
console.log(filterArr);