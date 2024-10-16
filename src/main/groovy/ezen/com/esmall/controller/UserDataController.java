package ezen.com.esmall.controller;

import ezen.com.esmall.entity.Cart;
import ezen.com.esmall.entity.Product;
import ezen.com.esmall.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class UserDataController {

    @Autowired
    private final UserDetailService userDetailService;
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
    private CartService cartService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName(); // 로그인한 사용자 이름
            Long userId = userDetailService.loadUserByUsername(userName).getId();
            model.addAttribute("username", userName);
            model.addAttribute("userid", userId);
        }
        // 인증되지 않은 경우에는 아무런 일이 없으므로 추가적인 작업이 필요 없음
    }


    @GetMapping("/cart")
    public String cartPage(Model model) {
        Long userId = (Long) model.getAttribute("userid");
        if (userId == null) {
            return "redirect:/login";
        }
        List<Cart> cartList = cartService.findAllByUserId(userId);
        List<Product> productList = new ArrayList<>();
        for (Cart cart : cartList) {
            Product product = productService.findById(cart.getProductId());
            if (product != null) {
                productList.add(product);
            }
        }
        model.addAttribute("cartList", cartList);
        model.addAttribute("productList", productList);
        return "cart";
    }
}