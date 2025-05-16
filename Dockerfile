# 1. Base 이미지로 OpenJDK 17 사용
FROM openjdk:21-jdk

# 2. 애플리케이션을 위한 디렉토리 생성 및 설정
WORKDIR /app

# 3. 로컬 jar 파일을 컨테이너의 /app 디렉토리로 복사
COPY build/libs/imagine-0.0.1-SNAPSHOT.jar app.jar

# 4. 포트 노출 (Spring Boot 애플리케이션의 기본 포트)
EXPOSE 8080

# 5. 애플리케이션 실행 명령어
CMD ["java", "-jar", "app.jar"]