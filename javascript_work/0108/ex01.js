console.log("ggg");

// 1 falsy 값
const f1 = undefined; // 선언만 되어져있고 값이 할당 되지 않았을 때
const f2 = null; // 선언되어져있고 값이 null로 선언 되어 있을 때
const f3 = 0;
const f4 = -0;
const f5 = NaN; // 숫자로 표기할 수 없음 Not a Number
const f6 = "";

const result = f1 && "result";
console.log(result);

class A {
  a;
  constructor(a) {
    this.a = a;
  }
}

// 2 truty 값 => 안에 값이 있으면 true
const t1 = "result";
const t2 = 123; // 0이 아닌 모든 값
const t3 = []; // 배열에 빈공백이어도 트루씨한 값임
const t4 = { a: 10, b: 20 }; // 빈 객체 (리터럴 객체표현) json(javascript object)
const t5 = () => {}; // 함수
const t6 = new A(20);

const result2 = t1 && "result2";
console.log(result2);

function printName(test) {
  if (test) {
    console.log(test + "출력된다");
  } else {
    console.log(test + "출력되지 않는다");
    console.log(`${test} 출력되지 않는다`);
  }
}

printName(f5); // f5 = NaN 출력되지 않는다 (falsy)
printName(t5); // t5 = ()=>{} 출력된다 (truty)

function aa(a) {
  if(a) {
    console.log(a);
  }
}

aa({ a: 10, b: 20 });
