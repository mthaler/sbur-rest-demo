# sbur-rest-demo
Spring Boot Up &amp; Running REST API demo project converted to Kotlin

## Usage

The application will listen on port 8080. The [httpie](https://httpie.io/) is a user-friendly HTTP client that can be used to test the API:

List all coffees:

```bash
$ http localhost:8080/coffees
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Fri, 11 Jun 2021 12:39:27 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "id": "717d8eb7-41fe-465f-8246-02ef3303f60f",
        "name": "Café Cereza"
    },
    {
        "id": "71d57267-d93a-4f53-9832-c6681eb694f8",
        "name": "Café Ganador"
    },
    {
        "id": "76071538-1c67-41fb-8fdf-954dc24a55ae",
        "name": "Café Lareño"
    },
    {
        "id": "23bd820b-8a97-4f78-bc50-c2c477383b54",
        "name": "Café Três Pontas"
    }
]

```

List a coffee by id:

```bash
$ http localhost:8080/coffees/717d8eb7-41fe-465f-8246-02ef3303f60f
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Fri, 11 Jun 2021 12:41:59 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "id": "717d8eb7-41fe-465f-8246-02ef3303f60f",
    "name": "Café Cereza"
}

```

To add a coffee, create a file `/tmp/coffee.json` with the following contents:

```json
{
    "id": "e9b27d06-3512-4b0c-8831-c27ffbbff15e",
    "name": "Café Gardena"
}
```

The run the following command:

```bash
$ http localhost:8080/coffees < /tmp/coffee.json 
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Fri, 11 Jun 2021 12:47:39 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "id": "e9b27d06-3512-4b0c-8831-c27ffbbff15e",
    "name": "Café Gardena"
}
```
