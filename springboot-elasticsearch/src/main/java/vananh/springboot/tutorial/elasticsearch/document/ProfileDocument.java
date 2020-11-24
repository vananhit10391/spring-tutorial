package vananh.springboot.tutorial.elasticsearch.document;

import lombok.Data;
import vananh.springboot.tutorial.elasticsearch.model.Technologies;
import java.util.List;

@Data
public class ProfileDocument {
    private String id;
    private String firstName;
    private String lastName;
    private List<Technologies> technologies;
    private Location location;
    private List<String> emails;
}
