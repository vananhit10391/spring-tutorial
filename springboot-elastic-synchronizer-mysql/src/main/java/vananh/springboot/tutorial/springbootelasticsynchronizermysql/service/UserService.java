package vananh.springboot.tutorial.springbootelasticsynchronizermysql.service;

import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User save(User user);

    void delete(Long id);
}
