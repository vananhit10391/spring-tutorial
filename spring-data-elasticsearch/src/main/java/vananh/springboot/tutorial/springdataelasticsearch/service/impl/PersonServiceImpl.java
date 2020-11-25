package vananh.springboot.tutorial.springdataelasticsearch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vananh.springboot.tutorial.springdataelasticsearch.model.Person;
import vananh.springboot.tutorial.springdataelasticsearch.repository.PersonRepository;
import vananh.springboot.tutorial.springdataelasticsearch.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository repository;

    @Override
    public Page<Person> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void create(Person person) {
        repository.save(person);
    }
}
