let arr = [1, 2, 3, 4, 5, 6, 7];
let numarr = arr.splice(2); // 두번째부터 잘라서 numarr에 넣음
console.log(`arr=${arr}`); // 34567이 잘리고 numarr이 되어서 1,2만 출력
console.log(`numarr = ${numarr}`); // 2번째부터 자른 3,4,5,6,7이 출력

console.log(); // 줄바꿈

arr = [1, 2, 3, 4, 5, 6, 7];
numarr = arr.splice(2, 2);
console.log(`arr=${arr}`);
console.log(`numarr = ${numarr}`);

arr = [1, 2, 3, 4, 5, 6, 7];
numarr = arr.splice(2, 2, [99, 99]); // 3, 4가 99, 99로 바뀜
console.log(`arr=${arr}`);
console.log(`numarr = ${numarr}`);