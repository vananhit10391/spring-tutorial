package vananh.springboot.tutorial.springbootelasticsynchronizermysql.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;

public interface UserSearchService {
    Page<UserES> findAll(Pageable pageable);
}
