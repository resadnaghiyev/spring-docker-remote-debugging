FROM openjdk:11
EXPOSE 8080 5005
ADD target/spring-docker-remote-debug.jar spring-docker-remote-debug.jar
ADD entrypoint.sh entrypoint.sh
ENTRYPOINT ["sh","/entrypoint.sh"]