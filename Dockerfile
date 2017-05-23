FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/balance-delta.jar /balance-delta/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/balance-delta/app.jar"]
