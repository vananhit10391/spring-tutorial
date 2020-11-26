package vananh.springboot.tutorial.springfulltextelasticsearch.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vananh.springboot.tutorial.springfulltextelasticsearch.model.Poem;

public interface PoemService {
   Page<Poem> search(String content, Pageable pageable);
   Poem save(Poem poem);
   Page<Poem> searchAll(Pageable pageable);
   void deleteAll();
}
