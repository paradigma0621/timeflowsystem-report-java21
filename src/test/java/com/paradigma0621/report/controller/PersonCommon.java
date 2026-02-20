package com.paradigma0621.report.controller;

public class PersonCommon {
    public static final String RESPONSE_PERSON_ONE_REGISTER =
            """
            {
              "id": 1,
              "customerId": 2,
              "name": "Maria Silva",
              "birthDate": "1985-10-20",
              "registerDate": "2026-02-11T09:15:00",
              "removed": true
            }
            """;

    public static final String RESPONSE_PERSONS_BY_CUSTOMER_ID_AND_REMOVED_FLAG =
            """
            [
                {
                    "id": 2,
                    "customerId": 1,
                    "name": "Maria Silva",
                    "birthDate": "1985-10-20",
                    "registerDate": "2026-02-11T09:15:00",
                    "removed": true
                },
                {
                    "id": 3,
                    "customerId": 1,
                    "name": "João Pedro de Souza",
                    "birthDate": "2007-02-13",
                    "registerDate": "2026-02-11T09:15:00",
                    "removed": true
                }
            ]
            """;

    public static final String PERSON_NOT_FOUND =
            """
            {
                "title": "Not found resource",
                "status": 404,
                "detail": "Person not found",
                "code": 404
            }
            """;
}
