package com.paradigma0621.report.service;

import com.paradigma0621.report.dto.PersonDto;
import com.paradigma0621.report.exception.ResourceNotFoundException;
import com.paradigma0621.report.helper.TestUnitHelper;
import com.paradigma0621.report.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


class PersonServiceTest extends TestUnitHelper {

    @Mock
    private PersonRepository repo;

    @InjectMocks
    private PersonService service;

    private PersonDto person1() {
        return new PersonDto(
                1L,
                10L,
                "Lucas Favaro",
                LocalDate.of(1990, 5, 12),
                LocalDateTime.of(2026, 2, 11, 8, 30, 0),
                false
        );
    }

    private PersonDto person2() {
        return new PersonDto(
                2L,
                10L,
                "Maria Silva",
                LocalDate.of(1985, 10, 20),
                LocalDateTime.of(2026, 2, 11, 9, 15, 0),
                true
        );
    }

    @Test
    void deveRetornarListaQuandoFindAll() {
        var expected = List.of(person1(), person2());
        when(repo.findAll()).thenReturn(expected);

        var result = service.findAll();

        assertThat(result).isSameAs(expected);
        verify(repo).findAll();
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarListaVaziaQuandoFindAllSemResultados() {
        when(repo.findAll()).thenReturn(List.of());

        var result = service.findAll();

        assertThat(result).isEmpty();
        verify(repo).findAll();
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarPessoaQuandoGetByIdExistente() {
        var expected = person1();
        when(repo.findById(1L)).thenReturn(Optional.of(expected));

        var result = service.getById(1L);

        assertThat(result).isSameAs(expected);
        verify(repo).findById(1L);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveLancarExcecaoQuandoGetByIdNaoEncontrado() {
        when(repo.findById(999L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getById(999L))
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Person not found");

        verify(repo).findById(999L);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarListaQuandoListByCustomer() {
        var expected = List.of(person1());
        when(repo.findBy(10L, false)).thenReturn(expected);

        var result = service.listByCustomer(10L, false);

        assertThat(result).isSameAs(expected);
        verify(repo).findBy(10L, false);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarListaVaziaQuandoListByCustomerSemResultados() {
        when(repo.findBy(10L, true)).thenReturn(List.of());

        var result = service.listByCustomer(10L, true);

        assertThat(result).isEmpty();
        verify(repo).findBy(10L, true);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarTrueQuandoDeleteRemoverRegistro() {
        when(repo.delete(1L)).thenReturn(1);

        var result = service.delete(1L);

        assertThat(result).isTrue();
        verify(repo).delete(1L);
        verifyNoMoreInteractions(repo);
    }

    @Test
    void deveRetornarFalseQuandoDeleteNaoRemoverRegistro() {
        when(repo.delete(999L)).thenReturn(0);

        var result = service.delete(999L);

        assertThat(result).isFalse();
        verify(repo).delete(999L);
        verifyNoMoreInteractions(repo);
    }

}
