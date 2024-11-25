// server.js

const express = require('express'); // Express 모듈 가져오기
const app = express();             // Express 앱 생성
const port = 3000;                 // 서버가 실행될 포트 번호

// 기본 경로('/')에 대한 GET 요청 처리
app.get('/', (req, res) => {
  res.send('Hello, Express!');
});

// '/api' 경로에 대한 GET 요청 처리
app.get('/api', (req, res) => {
  res.json({ message: 'Welcome to the API!' });
});

// 서버 실행
app.listen(port, "0.0.0.0", () => {
  console.log(`Server is running at http://localhost:${port}`);
});
