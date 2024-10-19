package ezen.com.esmall.controller;

import ezen.com.esmall.entity.*;
import ezen.com.esmall.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private SubCategoryService subCategoryService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private CartService cartService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();
            try {
                Long userId = userDetailService.loadUserByUsername(userName).getId();
                model.addAttribute("username", userName);
                model.addAttribute("userid", userId);
            } catch (UsernameNotFoundException e) {
                model.addAttribute("username", "Guest"); // 예외 발생 시 기본값 설정
            }
        } else {
            model.addAttribute("username", "Guest"); // 인증되지 않은 경우 기본값
        }
    }

    @GetMapping("/register")
    public String touPage(Model model) {
        return "tou";
    }

    @GetMapping("/registerOk")
    public String registerPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user, Model model) {
        User userData = new User(user.getName(), user.getUid(), user.getPw(), user.getTel(), user.getAddrf(),
                user.getAddrs(),
                user.getAddrt(), user.getAddrl(), null, 1, 1, user.getEmail(), user.getGender(), user.getBirthday());
        userService.create(userData);
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
        return "home";
    }

    @GetMapping("/help")
    public String help(Model model) {
        return "help";
    }

    @GetMapping("/products")
    public String productsMain(@RequestParam(value = "category", required = false) String category,
                               @RequestParam(value = "subcategory", required = false) String subcategory,
                               Model model) {
        List<Product> products;

        if (category != null && !category.isEmpty()) {
            // 카테고리가 제공된 경우
            Long categoryId = categoryService.findByName(category)
                    .map(Category::getId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid category: " + category));

            if (subcategory != null && !subcategory.isEmpty()) {
                // 서브카테고리도 제공된 경우
                Long subcategoryId = subCategoryService.findByName(subcategory)
                        .map(SubCategory::getId)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid subcategory: " + subcategory));
                products = productService.findAllByCategoryIdAndSubcategoryId(categoryId, subcategoryId);
            } else {
                // 서브카테고리는 제공되지 않은 경우
                products = productService.findAllByCategoryId(categoryId);
            }
        } else {
            // 카테고리와 서브카테고리 모두 제공되지 않은 경우
            products = productService.findAll();  // 모든 상품을 조회
        }

        String[] imageUrls = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String imageUrl = String.format("/images/%s/%s_%s.png",
                    category != null ? category : "default",  // 카테고리가 없을 경우 default 폴더 사용
                    product.getName(),
                    product.getName().substring(product.getName().length() - 2));
            imageUrls[i] = imageUrl;
        }

        model.addAttribute("subcategory", subcategory);
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        model.addAttribute("imageUrls", imageUrls);
        return "productsMain";
    }

    @GetMapping("/productsDetail")
    public String productsDetail(@RequestParam(value = "productCode") Long productCode,
                                 @RequestParam(value = "category", required = false) String category,
                                 Model model) {
        // 상품 정보 조회
        Product product = productService.findById(productCode);

        // 상품 이미지 URL 생성
        String[] imageUrls = new String[6];
        for (int i = 0; i < imageUrls.length; i++) {
            imageUrls[i] = String.format("/images/%s/%s_0%d.png",
                    category, product.getName(), i + 1);
        }

        // 구입 가능한 사이즈 가져오기
        List<ProductSize> sizes = product.getSizes();

        // 모델에 데이터 추가
        model.addAttribute("imageUrls", imageUrls);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        model.addAttribute("sizes", sizes);  // 사이즈 정보 추가

        return "productsDetail";
    }


}


