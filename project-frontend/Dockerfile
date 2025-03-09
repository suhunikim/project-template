# Node.js를 기반 이미지로 사용하여 React 빌드
FROM node:18-slim AS build

# 작업 디렉토리 설정
WORKDIR /app

# package.json과 package-lock.json 파일을 먼저 복사하고, 의존성 설치
COPY package.json package-lock.json ./
RUN npm install

# React 앱 소스 파일을 복사
COPY . .

# React 애플리케이션 빌드
RUN npm run build

# React 앱을 서비스할 웹 서버로 Nginx 사용
FROM nginx:alpine

# React 빌드 결과물을 Nginx의 기본 웹 루트 디렉토리로 복사
COPY --from=0 /app/build /usr/share/nginx/html

# Nginx 포트 오픈
EXPOSE 80
