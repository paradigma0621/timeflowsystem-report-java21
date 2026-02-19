package com.paradigma0621.report.service;

import com.paradigma0621.report.dto.PersonDto;
import com.paradigma0621.report.exception.ResourceNotFoundException;
import com.paradigma0621.report.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        log.info("Executing the request from this console.");
        return repo.findBy(customerId, removed);
    }

    public boolean delete(Long id) {
        return repo.delete(id) > 0;
    }
}
