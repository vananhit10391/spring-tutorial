package vananh.springboot.tutorial.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vananh.springboot.tutorial.elasticsearch.document.ProfileDocument;
import vananh.springboot.tutorial.elasticsearch.service.ProfileService;
import java.util.List;

@RestController()
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService service;

    @PostMapping("/")
    public ResponseEntity<ProfileDocument> createProfile(@RequestBody ProfileDocument document) throws Exception {
        service.createProfileDocument(document);
        return ResponseEntity.ok(document);
    }

    @PutMapping
    public ResponseEntity<ProfileDocument> updateProfile(@RequestBody ProfileDocument document) throws Exception {
        service.updateProfile(document);
        return ResponseEntity.ok(document);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDocument> findById(@PathVariable String id) throws Exception {
        ProfileDocument document = service.findById(id);
        return ResponseEntity.ok(document);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProfileDocument>> findAll() throws Exception {
        List<ProfileDocument> documentList = service.findAll();
        return ResponseEntity.ok(documentList);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<ProfileDocument>> search(@RequestParam(value = "technology") String technology) throws Exception {
        List<ProfileDocument> documentList = service.searchByTechnology(technology);
        return ResponseEntity.ok(documentList);
    }

    @GetMapping(value = "/name-search")
    public ResponseEntity<List<ProfileDocument>> searchByName(@RequestParam(value = "name") String name) throws Exception {
        List<ProfileDocument> documentList = service.findProfileByName(name);
        return ResponseEntity.ok(documentList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfileDocument(@PathVariable String id) throws Exception {
        service.deleteProfileDocument(id);
        return ResponseEntity.ok(id);
    }
}
