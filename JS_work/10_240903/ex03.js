let arr = [1, 2, 3, 4, 5, 6, 7];
let numarr = arr.slice(2);  // 원래 배열은 바꾸지않고 2번째부터 자르기

console.log(arr);
console.log(numarr);

arr = [1, 2, 3, 4, 5, 6, 7];
numarr = arr.slice(2, 5);  // 2~5사이를 잘라서 가져오기

console.log(arr);
console.log(numarr);