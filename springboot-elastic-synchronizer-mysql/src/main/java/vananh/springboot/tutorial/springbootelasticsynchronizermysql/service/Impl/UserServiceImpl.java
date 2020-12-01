package vananh.springboot.tutorial.springbootelasticsynchronizermysql.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.User;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.repository.UserRepository;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.service.UserService;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.util.Constants;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        Date currentDate = new Date();
        repository.updateUserSetStatusForId(id, Constants.DELETED, currentDate);
    }
}
