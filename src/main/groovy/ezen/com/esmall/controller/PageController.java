package ezen.com.esmall.controller;

import ezen.com.esmall.entity.Category;
import ezen.com.esmall.entity.Product;
import ezen.com.esmall.service.CategoryService;
import ezen.com.esmall.service.OrderService;
import ezen.com.esmall.service.ProductService;
import ezen.com.esmall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName(); // 로그인한 사용자 이름
            model.addAttribute("username", username);
            // 필요시 추가 정보를 가져올 수 있습니다. 예를 들어, User 엔티티를 가져오는 코드 추가
            // User user = userService.findByUsername(username);
            // model.addAttribute("user", user);
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String login(@RequestParam String uid, @RequestParam String pw, Model model) {
        return "redirect:/home";
    }

    @GetMapping({"/home", "/"})
    public String home(Model model) {
//        model.addAttribute("user1", userService.findById(1L));
        return "home";
    }

    @GetMapping("/products")
    public String productsMain(@RequestParam(value = "category", required = false) String category,
                               @RequestParam(value = "subcategory", required = false) String subcategory
            , Model model) {
        List<Product> products = productService.findAllByCategoryId(
                categoryService.findByName(category).map(Category::getId).orElse(1l)
        );
        model.addAttribute("category", category);
        model.addAttribute("subcategory", subcategory);
        model.addAttribute("products", products);
        return "productsMain";
    }

    @GetMapping("/productsDetail")
    public String productsDetail(@RequestParam(value = "productCode") Long productCode,
                                 @RequestParam(value = "category", required = false) String category, Model model) {
        Product product = productService.findById(productCode);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "productsDetail";
    }

}
