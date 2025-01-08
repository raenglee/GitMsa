const a = [1, 2, 3, 4];

const [el1, el2, el3, el4, el5 = null] = a;

console.log(`el1 = ${el1}`);
console.log(`el2 = ${el2}`);
console.log(`el3 = ${el3}`);
console.log(`el4 = ${el4}`);
console.log(`el5 = ${el5}`);

function aa([a, b, c]) {
  console.log(`a = ${a}`);
  console.log(`b = ${b}`);
  console.log(`c = ${c}`);
}

aa([10, 20, 30]);
