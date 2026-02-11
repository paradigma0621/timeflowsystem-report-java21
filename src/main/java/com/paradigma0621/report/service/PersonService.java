package com.paradigma0621.report.service;

import com.paradigma0621.report.dto.PersonDto;
import com.paradigma0621.report.exception.ResourceNotFoundException;
import com.paradigma0621.report.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository repo;

    public List<PersonDto> findAll() {
        return repo.findAll();
    }

    public PersonDto getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public List<PersonDto> listByCustomer(Long customerId, boolean removed) {
        return repo.findBy(customerId, removed);
    }

    public boolean delete(Long id) {
        return repo.delete(id) > 0;
    }
}
