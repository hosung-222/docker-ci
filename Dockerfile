#사용할 베이스 이미지를 선택
FROM adoptopenjdk:11-jre-hotspot

#작업 디렉토리를 생성
WORKDIR /app

#Gradle 빌드 결과물인 JAR 파일을 /app 디렉토리로 복사
COPY build/libs/*.jar app.jar

#컨테이너가 시작될 때 실행할 명령어를 지정
CMD ["java", "-jar", "app.jar"]