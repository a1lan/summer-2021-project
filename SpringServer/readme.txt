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