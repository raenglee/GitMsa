import { aa } from "./myclass.js";

console.log(aa);
console.log(aa.a);
console.log(aa.b);

aa.b();
const { a, b } = aa; // 객체 분할 { }
console.log(`a = ${a}`);
console.log(`b = ${b}`);

const [qwer, asdf] = bb; // 배열 분할 [ ]
console.log(`qwer = ${qwer}`);
console.log(`asdf = ${asdf}`);
