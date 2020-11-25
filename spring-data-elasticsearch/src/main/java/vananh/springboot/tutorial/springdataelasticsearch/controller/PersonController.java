package vananh.springboot.tutorial.springdataelasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vananh.springboot.tutorial.springdataelasticsearch.model.Person;
import vananh.springboot.tutorial.springdataelasticsearch.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService service;

    @GetMapping("/")
    public ResponseEntity<Page<Person>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @PostMapping("/")
    public ResponseEntity<Person> create(@RequestBody Person person) {
        service.create(person);
        return ResponseEntity.ok(person);
    }
}
