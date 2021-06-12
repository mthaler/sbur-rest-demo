# sbur-rest-demo
Spring Boot Up &amp; Running REST API demo project converted to Kotlin

## Usage

The application will listen on port 8080. The [httpie](https://httpie.io/) is a user-friendly HTTP client that can be used to test the API:

List all coffees:

```bash
$ http :8080/coffees
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Sat, 12 Jun 2021 12:38:51 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

[
    {
        "id": "1f2fe4b7-2d00-42c9-ad92-39b6e0f1eae3",
        "name": "Café Cereza"
    },
    {
        "id": "c276b750-2b5c-407e-832b-f439f0eb4956",
        "name": "Café Ganador"
    },
    {
        "id": "b6d1d371-7572-40ca-bda9-add530a9002e",
        "name": "Café Lareño"
    },
    {
        "id": "61e39b3f-da37-4f80-aea2-2d7824a076aa",
        "name": "Café Três Pontas"
    }
]

```

List a coffee by id:

```bash
$ http :8080/coffees/1f2fe4b7-2d00-42c9-ad92-39b6e0f1eae3
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Sat, 12 Jun 2021 12:42:09 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "id": "1f2fe4b7-2d00-42c9-ad92-39b6e0f1eae3",
    "name": "Café Cereza"
}

```

To add a coffee, run the following command:

```bash
$ http :8080/coffees <<<'{
    "id": "e9b27d06-3512-4b0c-8831-c27ffbbff15e",
    "name": "Café Gardena"
}'
```
