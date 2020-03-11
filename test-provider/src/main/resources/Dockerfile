FROM tubetrue01/openjdk:11.0.6-jre

ADD *.jar /usr/local/web/user-provider.jar

ENV JVM_OPTS="-Xss256k -Duser.timezone=Asia/Shanghai -Djava.security.egd=file:/dev/./urandom"
ENV JAVA_OPTS=""
ENV APP_OPTS=""

EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JVM_OPTS $JAVA_OPTS -jar /usr/local/web/user-provider.jar $APP_OPTS" ]
