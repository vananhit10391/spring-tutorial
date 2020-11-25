package vananh.springboot.tutorial.springdataelasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "person")
public class Person {
    @Id
    private String id;
    private String lastName;
    private String firstName;
}
