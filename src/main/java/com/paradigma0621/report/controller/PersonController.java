package com.paradigma0621.report.controller;

import com.paradigma0621.report.dto.PersonDto;
import com.paradigma0621.report.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    @GetMapping
    public List<PersonDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<PersonDto> listByCustomer(
            @PathVariable Long customerId,
            @RequestParam(defaultValue = "false") boolean removed
    ) {
        return service.listByCustomer(customerId, removed);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
