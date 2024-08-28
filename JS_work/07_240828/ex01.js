import {dofunction} from './myfunction.js';

const doA = function (a, b) {
  console.log("a = " + a);
  console.log("b = " + b);
}

doA(10, 20);
dofunction(10); /*안보내면 undefined 뜸*/