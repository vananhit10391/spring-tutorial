package vananh.springboot.tutorial.springbootelasticsynchronizermysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableElasticsearchRepositories("vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository*")
@EnableScheduling
public class SpringbootElasticSynchronizerMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootElasticSynchronizerMysqlApplication.class, args);
	}
}
