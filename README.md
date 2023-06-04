# Todo List API

A simple, containerized, Todo List API built with Java and Spring Boot.

## Getting Started

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Running the API

1. Run `docker-compose --profile dev up --build -d`
2. To see the logs, run `docker logs -f tl-api-dev`
3. The API will be available at `http://localhost:8080/api/tasks/`

## Running the tests

1. Run `docker-compose --profile test up --build`
2. The tests will run and the results will be displayed in the console.

