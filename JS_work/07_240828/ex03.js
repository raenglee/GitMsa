const obj = {};  // 객체선언은 {} 배열선언은 []

obj.a = 10;
obj.b = () => {
  console.log('obj.b');
}

console.log(obj);
console.log(obj.a);
console.log(obj.b);

obj.b();
