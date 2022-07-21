# G-able DTD Backend Java Recruitment Assessment

Author - Luke Nguyen

## Table of contents

* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Requirements](#requirements)
* [Explanations](#explanation)


## General Info

This is a project to develop a web service to get data from Coin-Gecko Server and format it to a specific response

## Technologies

* Java 11
* Spring Boot 2.7.1
* PostgreSQL 42.4.0

## Setup

**Precondition:**

- Postgres DB runs at port 5432. Change username/password/database in application.yml

**Run:**
- Open the project in IDE and run the project
- Select 'dev' as active profile
- After booting up the system, test the API with request below:

``````
curl --location --request POST 'localhost:8081/api/auth/v1/registration' \
--header 'Content-Type: application/json' \
--data-raw '{
    "currency":(usd, thb,...),
    "page": current page,
    "per_page":item per page
}'
``````
- There are validations for the request body:
    - page min value is 1, max value is 50
    - per_page min value is 1, max value is 100

## Requirements

- Create the API [get coins] to access data from the Coingecko server and provide a response with a preset structure.
- When api.coingecko.com is unavailable, this API must provide backup functionality (network error, site is down, etc.)

## Explanations

- The data provided by coin gecko is reformatted as the backend server's primary function. Additionally, 
it saves the coins and currencies from the coin server so that it can subsequently query them 
if the coin server cannot be contacted. To support this, the service will make a call to the coin server during startup 
in order to load all supported currencies. The service can verify the requested currency and, if the coin data was previously loaded, 
return it even if the coin server is down.
- In case the database doesn't have data, a dummy object will be returned.


