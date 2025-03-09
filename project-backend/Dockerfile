# OpenJDK 23을 기반 이미지로 사용
FROM openjdk:23-jdk-slim AS build

# JAR 파일을 빌드하고 복사할 디렉터리 생성
WORKDIR /app

# 프로젝트 소스 코드 복사
COPY . .

# Gradle을 사용하여 JAR 빌드
RUN ./gradlew clean build --no-daemon

# 작업 디렉토리 설정
WORKDIR /app

# 빌드 된 JAR 파일을 복사
COPY --from=build /app/build/libs/*.jar app-jar

# Spring Boot 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

# 포트 8080을 오픈
EXPOSE 8080
