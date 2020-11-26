package vananh.springboot.tutorial.springfulltextelasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import vananh.springboot.tutorial.springfulltextelasticsearch.model.Poem;
import vananh.springboot.tutorial.springfulltextelasticsearch.service.PoemService;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringFulltextElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFulltextElasticsearchApplication.class, args);
	}

	@Autowired
	PoemService service;

	@PostConstruct
	public void init() {
		Poem poem1= new Poem();
		Poem poem2= new Poem();

		poem1.setTitle("First title");
		poem1.setContent("say hello java");
		poem2.setTitle("Second title");
		poem2.setContent("say hello elasticsearch");

		service.deleteAll();

		service.save(poem1);
		service.save(poem2);
	}
}
