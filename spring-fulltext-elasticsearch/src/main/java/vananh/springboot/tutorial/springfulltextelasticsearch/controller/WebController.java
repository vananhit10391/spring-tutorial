package vananh.springboot.tutorial.springfulltextelasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vananh.springboot.tutorial.springfulltextelasticsearch.model.Poem;
import vananh.springboot.tutorial.springfulltextelasticsearch.service.PoemServiceImpl;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    private PoemServiceImpl poemService;

    @RequestMapping("/")
    public String index(Pageable pageable, Model model) {
        Page<Poem> poems = poemService.searchAll(pageable);
        List<Poem> list = poems.getContent();
        model.addAttribute("poems", list);
        return "index";
    }

    @RequestMapping("/search")
    public String search(String content, Pageable pageable, Model model) {
        Page<Poem> poems = poemService.search(content, pageable);
        List<Poem> list = poems.getContent();
        model.addAttribute("poems", list);
        return "index";
    }
}
