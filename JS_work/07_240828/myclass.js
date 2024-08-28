export default {
  a: 10,
  b: function () {
    console.log("test");
  },
};

export const aa = {
  z: 10,
  zz: 20,
  zzz: function () { console.log('test'); }
};

export const bb = () => {
  let a = 10;
  let b = 20;

  console.log('bb');

  let c = 30;
  return 10;
}
  export const cc = function (a, b) {
    
    // return "asdf";
    return 10;
}