# Time Flow System
Backend and Frontend implementation of software to measure time quality in work.
- Built on PostgreSQL.

## Microsservices
[Core](https://github.com/paradigma0621/timeflowsystem-core-java21) <br>
[Report](https://github.com/paradigma0621/timeflowsystem-report-java21) <br>
[Eureka](https://github.com/paradigma0621/timeflowsystem-eureka-java17) <br>
[Gateway](https://github.com/paradigma0621/timeflowsystem-gateway-java17) <br>
[API](https://github.com/paradigma0621/timeflowsystem-api-java17) <br>

## Report
This project is designed to run in *Java 21*.

2026-02-11 - Started Report Microservice project.
2026-02-20 - Introduced asynchronous (RabbitMQ) messaging

## RabbitMQ
### Instalation
Run: `docker run -it --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management` <br>
Access: `http://localhost:15672/`   (user: guest, password: guest)
## Frontend
To be accessed by the  "Timeflow Frontend" [React 18.3 App project](https://github.com/paradigma0621/timeflowsystem-react-app)

