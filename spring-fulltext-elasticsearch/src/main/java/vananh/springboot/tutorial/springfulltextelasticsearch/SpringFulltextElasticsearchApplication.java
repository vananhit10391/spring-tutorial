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
		service.deleteAll();

		Poem poem1 = new Poem();
		Poem poem2 = new Poem();
		Poem poem3 = new Poem();
		poem1.setTitle("First title");
		poem1.setContent("Say hi java");
		poem2.setTitle("Second title");
		poem2.setContent("say hello elasticsearch");
		poem3.setTitle("Thirst title");
		poem3.setContent("other content");

		service.save(poem1);
		service.save(poem2);
		service.save(poem3);
	}
}
