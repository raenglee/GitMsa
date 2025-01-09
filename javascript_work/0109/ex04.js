const arr1 = [10, 3, 5];

// const sortArr1 = arr1.sort((a, b) => {
//   if (a > b) return -1;
//   else if (a < b) return 1;
//   else return 0;
// });

const sortArr1 = arr1.sort((a, b) => b - a);

console.log(sortArr1);

const arr2 = [
  { name: "홍길동", age: 20 },
  { name: "김길동", age: 15 },
  { name: "이길동", age: 30 },
];

const sortArr2 = arr2.sort((item1, item2) => {
  return item1.age - item2.age;
});

console.log(sortArr2);

const arr3 = ["Hi", "my name is", "juhyunLEE"];

console.log(arr3.join());
console.log(arr3.join("-"));
console.log(arr3.join(" "));
