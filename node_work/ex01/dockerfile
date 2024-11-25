# 1. Node.js 기반 이미지 사용
FROM node:18

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 패키지 파일 복사
COPY package*.json ./

# 4. 의존성 설치
RUN npm install

# 5. 애플리케이션 코드 복사
COPY . .

# 6. 컨테이너 실행 시 노출할 포트 설정
EXPOSE 3000

# 7. 애플리케이션 실행 명령어
CMD ["node", "server.js"]