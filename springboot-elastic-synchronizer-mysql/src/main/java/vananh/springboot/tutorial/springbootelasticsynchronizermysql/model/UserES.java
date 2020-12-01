package vananh.springboot.tutorial.springbootelasticsynchronizermysql.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import javax.persistence.Id;
import java.util.Date;

@Data
@Document(indexName = "user")
public class UserES {
    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Date modificationDate;

    private Boolean status;
}
