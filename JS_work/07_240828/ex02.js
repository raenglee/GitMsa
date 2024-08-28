const arr = [];  // let이면 값 변경 가능
arr.push('test');
arr.push("test");
arr.push("test");

console.log(arr);  //값의 추가는 가능

arr = "asdf";
console.log(arr);  //값의 전체 변경은 불가능