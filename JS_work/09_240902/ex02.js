let date = new Date();
console.log(date);
console.log(date.toLocaleString());

class AA{
  a = 10;
  b = 20;
}

let aa = new AA();
console.log(aa);

aa.c = 20;
console.log(aa);

aa.d = () => { console.log("함수"); };
console.log(aa);