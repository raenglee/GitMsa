const doA = () => {
  const promise = new Promise((resolve, reject) => {
    setTimeout(() => {
      // resolve("잘 됨");
      reject("안 됨");
    }, 3000);
  });
  return promise;
};

// console.log(promise);

doA()
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.log(error);
  });
