package vananh.springboot.tutorial.springfulltextelasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import vananh.springboot.tutorial.springfulltextelasticsearch.model.Poem;

public interface PoemRepository extends ElasticsearchRepository<Poem, String> {
    Page<Poem> findByContentLike(String content, Pageable pageable);
}
