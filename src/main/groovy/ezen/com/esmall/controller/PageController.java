package ezen.com.esmall.controller;

import ezen.com.esmall.entity.Category;
import ezen.com.esmall.entity.Product;
import ezen.com.esmall.entity.User;
import ezen.com.esmall.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PageController {

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserDetailService userDetailService;

//    @ModelAttribute
//    public void addUserToModel(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            String username = authentication.getName(); // 로그인한 사용자 이름
//            model.addAttribute("username", username);
//            // 필요시 추가 정보를 가져올 수 있습니다. 예를 들어, User 엔티티를 가져오는 코드 추가
//            // User user = userService.findByUsername(username);
//            // model.addAttribute("user", user);
//        }
//    }

    @GetMapping("/register")
    public String touPage(Model model) {
        return "tou";
    }

    @GetMapping("/registerOk")
    public String registerPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam(value = "uid") String uid, @RequestParam(value = "pw") String pw,
                           @RequestParam(value = "name") String name,
                           Model model) {
        User user = new User("name", uid, pw, "", 0, "", "", "", LocalDateTime.now(), 0, 0);
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }

    @GetMapping({"/home", "/"})
    public String home(Model model) {
//        model.addAttribute("user1", userService.findById(1L));
        return "home";
    }

    @GetMapping("/products")
    public String productsMain(@RequestParam(value = "category", required = false) String category
            , Model model) {
        List<Product> products = productService.findAllByCategoryId(
                categoryService.findByName(category).map(Category::getId).orElseThrow(() -> new IllegalArgumentException("Invalid category: " + category))
        );

        String[] imageUrls = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String imageUrl = String.format("/images/%s/%s_%s.png",
                    category,
                    product.getName(),
                    product.getName().substring(product.getName().length() - 2));
            imageUrls[i] = imageUrl;
        }

        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("imageUrls", imageUrls);
        return "productsMain";
    }

    @GetMapping("/productsDetail")
    public String productsDetail(@RequestParam(value = "productCode") Long productCode,
                                 @RequestParam(value = "category", required = false) String category, Model model) {
        Product product = productService.findById(productCode);
        String[] imageUrls = new String[6];
        for (int i = 0; i < imageUrls.length; i++) {
            imageUrls[i] = String.format("/images/%s/%s_0%d.png",
                    category,
                    product.getName(),
                    i + 1);
        }
        model.addAttribute("imageUrls", imageUrls);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        return "productsDetail";
    }

}
