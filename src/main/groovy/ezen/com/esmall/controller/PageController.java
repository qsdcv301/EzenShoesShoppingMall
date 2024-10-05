package ezen.com.esmall.controller;

import ezen.com.esmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("user1", userService.findById(1L));
        return "home";
    }

    @GetMapping("/products")
    public String productsMain() {
        return "productsMain";
    }

}
