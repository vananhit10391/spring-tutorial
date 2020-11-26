package vananh.springboot.tutorial.springfulltextelasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "poem")
public class Poem {
    @Id
    private String id;
    private String title;
    private String content;
}
