# cryptonate-spring-boot-example

## Description

`cryptonate-spring-boot-example` is a minimal Spring Boot application that shows how to use the `cryptonate` library and the `cryptonate-spring-boot-starter` package.

## Requirements

* Java 8 or higher
* Apache Maven 3.6 or higher

## Running the Application

```
mvn clean package
mvn spring-boot:run
```

## Verifying Encryption of Domain Model Fields

### List Entities in the Database (via the H2 Console)

First, verify that `cryptonate` is encrypting domain model fields:

1. In your web browser, navigate to **http://localhost:8080/h2-console/**.
2. Use `jdbc:h2:mem:DEV_DB` as the JDBC URL.
3. Click 'Connect'
4. Execute the following SQL query:  `SELECT * FROM SAMPLE_ENTITY `

The results of the SQL query should reveal that the `EMAIL_ADDRESS` column contains base-64 data, and not clear-text email addresses.

This base-64 data is the encrypted email address for each entry in the result set.

### List Entities in the Database (via `curl`)

Next, verify that `cryptonate` is decrypting domain model fields by hitting the RESTful endpoint for the sample entities:

```
curl http://localhost:8080/api/sampleEntities
```

`curl` should output a JSON object showing five sample entities, each with an unencrypted email address field.
