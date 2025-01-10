import { useState } from "react";
import "./App.css";

function App() {
  // ref() 대신 usestate 사용

  const doA = () => {
    return [ 10, () => { console.log("doA") } ];
  };

  const [bb,bbb] = doA();

  const [aa, setAA] = useState(10);

  const clickA = () => {
    console.log("clickA 클릭");
    setAA(aa + 1);
  };

  console.log("렌더링")
  console.log(bb);
  console.log(bbb);

  return (
    <>
      <h1>깔끔</h1>
      <h1>{aa}</h1>
      <button onClick={clickA}>누르면 aa값 증가</button>
    </>
  );
}

export default App;
