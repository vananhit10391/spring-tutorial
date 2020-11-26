package vananh.springboot.tutorial.springfulltextelasticsearch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vananh.springboot.tutorial.springfulltextelasticsearch.model.Poem;
import vananh.springboot.tutorial.springfulltextelasticsearch.repository.PoemRepository;

@Service
public class PoemServiceImpl implements PoemService{

    @Autowired
    private PoemRepository repository;

    @Override
    public Page<Poem> search(String content, Pageable pageable) {
        return repository.findByContentLike(content, pageable);
    }

    @Override
    public Poem save(Poem poem) {
        return repository.save(poem);
    }

    @Override
    public Page<Poem> searchAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
