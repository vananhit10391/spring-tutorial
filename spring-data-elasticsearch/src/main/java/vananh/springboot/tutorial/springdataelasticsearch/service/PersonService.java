package vananh.springboot.tutorial.springdataelasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vananh.springboot.tutorial.springdataelasticsearch.model.Person;

public interface PersonService {
    Page<Person> getAll(Pageable pageable);
    void create(Person person);
}
