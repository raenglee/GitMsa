const arr = ['a', 'b', 'c'];
const brr = [1, 2, 3, 4, 5];

const str1 = arr.join();
const str2 = brr.join('..');
const str3 = brr.join("<p>");

console.log(str1);
console.log(str2);
console.log(str3);

const length = arr.push('zz');  // 마지막 요소로 zz추가
console.log(arr);
console.log(length);

const value = arr.unshift('aa');  // 제일 앞에 aa 추가
console.log(arr);
console.log(value);

const item = arr.pop();  // 제일 끝에것을 꺼내는 것 'zz'가 밖으로 나옴
console.log(item);
console.log(arr);

const fitem = arr.shift();
console.log(fitem);
console.log(arr);