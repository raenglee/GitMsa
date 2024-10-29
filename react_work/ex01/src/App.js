import {useState} from 'react';
import "./App.css";
import Person from './componentes/Person.jsx'

function App() {

  const [data,setData] = useState(0);
  const [age, setAge] = useState(0);

  const doClcik1 = () => {
    setData(data+1);
  };

  const doClcik2 = () => {
    setAge(age+5);
  };

  return (
    <div className="App">
      <Person name="홍길동" age={20}></Person>
      <Person name="이길동" age={50}></Person>
      <Person name="박길동" age={30}></Person>
      <h1>안녕 React</h1>
      <h2>count: {data}</h2>
      <h3>age: {age}</h3>
      <button onClick={doClcik1}>data누름</button>
      <button onClick={doClcik2}>age누름</button>
    </div>
  );
}

export default App;
