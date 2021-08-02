n.b. Tests and server rely on maven, docker, and docker-compose being installed
      Docker must be started before running

To install docker:
	Follow instructions at:
	https://docs.docker.com/engine/install/
	Then follow Post-installation steps:
	https://docs.docker.com/engine/install/linux-postinstall/
	And then install docker-compose at:
	https://docs.docker.com/compose/install/

To start docker:
	service docker start

To run server:
    mvn clean package ; docker-compose build ; docker-compose up

To run tests:
    mvn test
