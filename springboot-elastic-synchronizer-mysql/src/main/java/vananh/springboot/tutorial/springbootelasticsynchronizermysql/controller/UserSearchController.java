package vananh.springboot.tutorial.springbootelasticsynchronizermysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.model.UserES;
import vananh.springboot.tutorial.springbootelasticsynchronizermysql.service.UserSearchService;

@RestController
@RequestMapping("/search/user")
public class UserSearchController {
    @Autowired
    UserSearchService service;

    @GetMapping("/")
    public ResponseEntity<Page<UserES>> findAll(Pageable pageable) {
        Page<UserES> userESPage = service.findAll(pageable);
        return ResponseEntity.ok(userESPage);
    }
}
