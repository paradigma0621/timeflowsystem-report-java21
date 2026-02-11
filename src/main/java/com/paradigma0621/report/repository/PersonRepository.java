package com.paradigma0621.report.repository;

import com.paradigma0621.report.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.paradigma0621.report.repository.PersonSQLStaticQueries.*;
import static com.paradigma0621.report.repository.commons.SQLFields.*;

@RequiredArgsConstructor
@Repository
public class PersonRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<PersonDto> findBy(Long customerId, Boolean removed) {

        var sql = PERSON_FIND_BY_CUSTOMER_ID_AND_REMOVED_FLAG;

        var params = Map.of(
                CUSTOMER_ID, customerId,
                REMOVED, removed
        );

        return namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) ->
                new PersonDto(
                        rs.getLong(ID),
                        rs.getLong(CUSTOMER_ID),
                        rs.getString(NAME),
                        rs.getObject(BIRTH_DATE, LocalDate.class),
                        rs.getObject(REGISTER_DATE, LocalDateTime.class),
                        rs.getBoolean(REMOVED)
                )
        );
    }

    public List<PersonDto> findAll() {

        var sql = PERSON_FIND_ALL;

        return namedParameterJdbcTemplate.query(sql, Collections.emptyMap(), (rs, rowNum) ->
                new PersonDto(
                        rs.getLong(ID),
                        rs.getLong(CUSTOMER_ID),
                        rs.getString(NAME),
                        rs.getObject(BIRTH_DATE, LocalDate.class),
                        rs.getObject(REGISTER_DATE, LocalDateTime.class),
                        rs.getBoolean(REMOVED)
                )
        );
    }

    public Optional<PersonDto> findById(Long id) {

        var sql = PERSON_FIND_BY_ID;

        var results = namedParameterJdbcTemplate.query(
                sql,
                Map.of(ID, id),
                (rs, rowNum) -> new PersonDto(
                        rs.getLong(ID),
                        rs.getLong(CUSTOMER_ID),
                        rs.getString(NAME),
                        rs.getObject(BIRTH_DATE, LocalDate.class),
                        rs.getObject(REGISTER_DATE, LocalDateTime.class),
                        rs.getBoolean(REMOVED)
                )
        );

        return results.stream().findFirst();
    }

    public int delete(Long id) {

        var sql = PERSON_DELETE_BY_ID;

        return namedParameterJdbcTemplate.update(
                sql,
                Map.of(ID, id)
        );
    }
}
