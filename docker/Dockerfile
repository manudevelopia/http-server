FROM amazoncorretto:19-alpine-jdk

MAINTAINER developia.info

COPY build/libs/*.jar app.jar

EXPOSE 8888:8888

ENTRYPOINT ["java","-jar","--enable-preview","/app.jar"]