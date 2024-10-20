package ezen.com.esmall.controller;

import ezen.com.esmall.entity.Cart;
import ezen.com.esmall.entity.Product;
import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.CartRepository;
import ezen.com.esmall.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private OrdersService ordersService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductSizeService productSizeService;

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

    @GetMapping("/mypage")
    public String myPage(Model model) {
        Long userId = (Long) model.getAttribute("userid");
        if (userId == null) {
            return "redirect:/login";
        }
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "mypage";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        Long userId = (Long) model.getAttribute("userid");
        if (userId == null) {
            return "redirect:/login";
        }
        List<Cart> cartList = cartService.findAllByUserId(userId);
        List<Product> productList = new ArrayList<>();
        List<String> imageUrls = new ArrayList<>();
        for (Cart cart : cartList) {
            Product product = productService.findById(cart.getProductId());
            if (product != null) {
                productList.add(product);
                String imageUrl = String.format("/images/%s/%s_%s.png",
                        categoryService.findById(product.getCategoryId()).getName(),
                        product.getName(),
                        product.getName().substring(product.getName().length() - 2));
                imageUrls.add(imageUrl);
                System.out.println(imageUrls);
            }
        }
        model.addAttribute("cartList", cartList);
        model.addAttribute("productList", productList);
        model.addAttribute("imageUrls", imageUrls);
        return "cart";
    }

    @PostMapping("/deleteCart")
    public ResponseEntity<?> deleteProducts(@RequestBody Map<String, List<String>> request) {
        Long currentUserId = getCurrentUserId();
        List<String> productIds = request.get("productIds");

        if (productIds == null || productIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "삭제할 상품이 없습니다."));
        }

        // cartService에서 현재 사용자와 해당 productIds에 해당하는 cart 항목들만 조회
        List<Cart> cartList = cartService.findByUserIdAndProductIds(currentUserId, productIds.stream()
                .map(Long::parseLong).collect(Collectors.toList()));

        if (cartList.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "해당하는 장바구니 항목이 없습니다."));
        }

        // 일치하는 cart 항목 삭제
        for (Cart cart : cartList) {
            cartService.delete(cart.getId());
        }

        return ResponseEntity.ok().body(Map.of("success", true));
    }

    private Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            User userDetails = (User) authentication.getPrincipal();
            return userDetails.getId(); // User 클래스에 getId() 메서드가 있어야 합니다.
        }
        return null; // 로그인하지 않은 경우
    }

    @PostMapping("/addCart")
    @ResponseBody
    public ResponseEntity<?> addCart(@RequestBody Map<String, Object> request, Model model) {
        Long userId = getCurrentUserId();
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("redirect", "/login"));
        }
        Long currentUserId = getCurrentUserId(); // 현재 사용자 ID 가져오기
        Long productId = Long.parseLong((String) request.get("product_id"));
        Integer size = Integer.parseInt((String) request.get("size"));
        Integer quantity = Integer.parseInt((String) request.get("quantity"));

        // 장바구니에 추가하는 로직 작성
        Cart newCartItem = Cart.builder()
                .userId(currentUserId)
                .productId(productId)
                .size(size)
                .quantity(quantity)
                .build();

        // 장바구니에 상품 추가
        cartService.create(newCartItem);

        return ResponseEntity.ok(Map.of("success", true, "message", "상품이 장바구니에 추가되었습니다."));
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user, Model model) {
        Long userId = getCurrentUserId();
        User existingUser = userService.findById(userId);
        existingUser.setTel(user.getTel());
        existingUser.setAddrf(user.getAddrf());
        existingUser.setAddrs(user.getAddrs());
        existingUser.setAddrt(user.getAddrt());
        existingUser.setAddrl(user.getAddrl());
        existingUser.setEmail(user.getEmail());

//        // 비밀번호는 제공된 경우에만 업데이트
//        if (user.getPw() != null && !user.getPw().isEmpty()) {
//            existingUser.setPw(user.getPw()); // 비밀번호 암호화
//        }

        userService.update(userId, existingUser);

        return "redirect:/mypage";
    }

}
