// 호이스팅
// 변수 호이스팅
// 함수 호이스팅

const person = {
  age: 20,
  name: "이길동",
  gender: "여자",
};

const func = ( { age, name, gender } )=>{
    console.log(`나이는 ${age}`);
    console.log(`이름은 ${name}`);
    console.log(`성별은 ${gender}`);
  }

  func(person);

  console.log(a);

  // const a = 10; // a 사용못한다고 나옴
  // let a = 10; // a 사용못한다고 나옴
  var a = 10; // 에러안나고 잘나옴 => 변수 호이스팅, 함수 호이스팅 이라고 함

  console.log(a);

// function fuc({age,name,gender}) {
//   console.log(`나이는 ${age}`);
//   console.log(`이름은 ${name}`);
//   console.log(`성별은 ${gender}`);
// }
