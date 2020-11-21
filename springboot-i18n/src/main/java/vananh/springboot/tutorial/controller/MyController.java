package vananh.springboot.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        String message = messageSource.getMessage("hello", null, "default message", request.getLocale());
        model.addAttribute("message", message);
        return "index";
    }
}
