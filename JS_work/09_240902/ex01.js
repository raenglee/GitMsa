import readline from 'readline';

const myobj = {
  input: process.stdin,
  output: process.stdout
}

const rl = readline.createInterface(myobj);

let num1;
let num2;

rl.question('num1 입력', res => {
  console.log(`res = ${res}`);
  num1 = Number(res);
  
  rl.question("num2 입력", res => {
    console.log(`res = ${res}`);
    num2 = Number(res);
    
    rl.close();
    
    console.log(`${num1}+${num2}=${num1 + num2}`);
    
  });
});
  