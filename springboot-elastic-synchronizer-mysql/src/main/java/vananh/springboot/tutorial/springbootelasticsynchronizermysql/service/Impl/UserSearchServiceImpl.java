package vananh.springboot.tutorial.springbootelasticsynchronizermysql.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository.UserESRepository;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.service.UserSearchService;

@Service
public class UserSearchServiceImpl implements UserSearchService {
    @Autowired
    UserESRepository repository;

    @Override
    public Page<UserES> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
