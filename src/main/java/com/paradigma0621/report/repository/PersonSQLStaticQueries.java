package com.paradigma0621.report.repository;

public class PersonSQLStaticQueries {

    PersonSQLStaticQueries() { }

    public static final String PERSON_FIND_BY_CUSTOMER_ID_AND_REMOVED_FLAG =
                """
                SELECT id,
                       customer_id,
                       name,
                       birth_date,
                       register_date,
                       removed
                FROM person
                WHERE customer_id = :customer_id
                  AND removed = :removed
                """;

    public static final String PERSON_FIND_ALL =
                """
                SELECT id,
                       customer_id,
                       name,
                       birth_date,
                       register_date,
                       removed
                FROM person
                ORDER BY id
                """;

    public static final String PERSON_FIND_BY_ID =
                """
                SELECT id,
                       customer_id,
                       name,
                       birth_date,
                       register_date,
                       removed
                FROM person
                WHERE id = :id
                """;

    public static final String PERSON_DELETE_BY_ID =
                """
                DELETE FROM person
                WHERE id = :id
                """;
}
