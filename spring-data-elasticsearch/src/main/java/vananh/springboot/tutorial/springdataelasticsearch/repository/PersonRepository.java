package vananh.springboot.tutorial.springdataelasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import vananh.springboot.tutorial.springdataelasticsearch.model.Person;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
}
