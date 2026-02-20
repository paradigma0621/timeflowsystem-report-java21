package com.paradigma0621.report.controller;

import com.paradigma0621.report.helper.TestIntegrationHelper;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;

import static com.paradigma0621.report.controller.PersonCommon.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PersonControllerIT extends TestIntegrationHelper {

    private static final String URI_BY_ID = "/persons/{personId}";
    private static final String URI_BY_CUSTOMER_ID = "/persons/customer/{customerId}";


    @Test
    @Sql(value = "/data/person/one-person-population.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(value = "/data/person/cleanup.sql", executionPhase = AFTER_TEST_METHOD)
    void deveBuscarEEncontrarPessoa() throws Exception {
        var userId = 1L;
        mockMvc.perform(get(URI_BY_ID, userId).accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().json(RESPONSE_PERSON_ONE_REGISTER));
    }


    @Test
    @Sql(value = "/data/person/many-persons-population.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(value = "/data/person/cleanup.sql", executionPhase = AFTER_TEST_METHOD)
    void deveBuscarEEncontrarPessoasPorCustomerId() throws Exception {

        var customerId = 1L;
        var removed = true;

        mockMvc.perform(get(URI_BY_CUSTOMER_ID, customerId)
                    .queryParam("removed", String.valueOf(removed))
                    .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(RESPONSE_PERSONS_BY_CUSTOMER_ID_AND_REMOVED_FLAG));
        }

    @Test
    @Sql(value = "/data/person/one-person-population.sql", executionPhase = BEFORE_TEST_METHOD)
    @Sql(value = "/data/person/cleanup.sql", executionPhase = AFTER_TEST_METHOD)
    void deveRetornar404QuandoNaoEncontrar() throws Exception {
                mockMvc.perform(
                        get(URI_BY_ID, 999L)
                            .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(content().json(PERSON_NOT_FOUND, false))
                .andExpect(status().isNotFound());
    }

}
