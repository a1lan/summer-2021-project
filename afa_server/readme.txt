To run server:
    Create tunnel to St Andrews cs computer with:
        ssh bp50@bp50.host.cs.st-andrews.ac.uk -L 3306:localhost:3306 -N
    Then to start server:
        ./mvnw spring-boot:run

To run tests:
    Create tunnel to St Andrews cs computer with:
        ssh bp50@bp50.host.cs.st-andrews.ac.uk -L 3306:localhost:3306 -N
    Then to run tests:
        mvn test

To create clean jar:
	mvn clean package

To create new docker image:
    ./mvnw spring-boot:build-image

To start docker:
    service docker start


docker run -p 8887:3306 test_afa_image:latest


./mvnw spring-boot:build-image
docker-compose build
docker-compose up