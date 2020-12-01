package vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;

@Repository
public interface UserESRepository extends ElasticsearchRepository<UserES, String> {
}
