package ezen.com.esmall.controller;

import ezen.com.esmall.entity.*;
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

import java.time.format.DateTimeFormatter;
import java.util.*;
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
    @Autowired
    private OrderViewService orderViewService;
    @Autowired
    private ReviewService reviewService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName(); // 로그인한 사용자 이름
            Long userId = userDetailService.loadUserByUsername(userName).getId();
            User user = userService.findById(userId);
            model.addAttribute("username", user.getName());
            model.addAttribute("usercoin", user.getEzcoin());
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
        List<OrderView> orders = orderViewService.findByUserId(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        User user = userService.findById(userId);
        List<Review> reviews = reviewService.findAllByUserId(userId);
        List<Map<String, Object>> orderList = new ArrayList<>();
        for (OrderView order : orders) {
            Map<String, Object> orderData = new HashMap<>();
            Product product = productService.findById(order.getProductId());
            Orders orderItem = ordersService.findById(order.getOrderId());
            for (Review review : reviews) {
                if (Objects.equals(review.getProductId(), product.getId()) && order.getDeliveryStatus().equals("배송완료")) {
                    order.setDeliveryStatus("작성완료");
                }
            }
            orderData.put("order", order);
            orderData.put("product", product);
            orderData.put("formattedCreateAt", orderItem.getOrderTime().format(formatter));
            orderList.add(orderData);
        }
        model.addAttribute("user", user);
        model.addAttribute("userId", user.getName());
        model.addAttribute("orderList", orderList);
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
        User user = userService.findById(userId);
        model.addAttribute("user", user);
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
        Long productId = Long.parseLong((String) request.get("product_id"));
        Integer size = Integer.parseInt((String) request.get("size"));
        Integer quantity = Integer.parseInt((String) request.get("quantity"));

        // 장바구니에 추가하는 로직 작성
        Cart newCartItem = Cart.builder()
                .userId(userId)
                .productId(productId)
                .size(size)
                .quantity(quantity)
                .build();

        // 장바구니에 상품 추가
        cartService.create(newCartItem);

        return ResponseEntity.ok(Map.of("success", true, "message", "상품이 장바구니에 추가되었습니다."));
    }

    @PostMapping("/updateCart")
    public String updateCart(@RequestParam(value = "productId") String ProductId,
                             @RequestParam(value = "size") String size,
                             @RequestParam(value = "quantity") String quantity,
                             Model model) {
        Long userId = getCurrentUserId();
        if (userId == null) {
            return "redirect:/login";
        }
        Cart cart = cartService.findByUserIdAndProductId(userId, Long.parseLong(ProductId));

        cart.setSize(Integer.parseInt(size));
        cart.setQuantity(Integer.parseInt(quantity));

        cartService.update(cart.getId(), cart);

        return "redirect:/cart";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user, Model model) {
        Long userId = getCurrentUserId();
        if (userId == null) {
            return "redirect:/login";
        }
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

    @PostMapping("/addReview")
    public String addReview(@RequestParam(value = "name") String productName,
                            @RequestParam(value = "title") String title,
                            @RequestParam(value = "comment") String comment,
                            @RequestParam(value = "starRate") Integer starRate,
                            Model model) {
        Long userId = getCurrentUserId();
        if (userId == null) {
            return "redirect:/login";
        }
        Product product = productService.findProductByName(productName);
        Review newReview = Review.builder()
                .userId(userId)
                .productId(product.getId())
                .comment(comment)
                .title(title)
                .starRate(starRate)
                .build();

        reviewService.create(newReview);
        return "redirect:/mypage";
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestParam(value = "productNames") String productNames,
                           @RequestParam(value = "sizes") String sizes,
                           @RequestParam(value = "quantities") String quantities,
                           @RequestParam(value = "totalPrice") Integer totalPrice,
                           Model model) {
        Long userId = getCurrentUserId();
        if (userId == null) {
            return "redirect:/login";
        }
        String[] namesArray = productNames.split(",");
        String[] sizesArray = sizes.split(",");
        String[] quantitiesArray = quantities.split(",");

        User user = userService.findById(userId);

        Orders newOrder =
                Orders.builder().userId(userId).totalPrice(totalPrice).addrs(user.getAddrs()).addrt(user.getAddrt()).build();
        ordersService.create(newOrder);
        List<Long> productList = new ArrayList<>();
        for (int i = 0; i < namesArray.length; i++) {
            Integer quantity = Integer.parseInt(quantitiesArray[i]);
            Product product = productService.findProductByName(namesArray[i]);
            ProductSize productSize = productSizeService.findByfindByProductIdAndAndSize(product.getId(),Integer.parseInt(sizesArray[i]));

            productSize.setStock(productSize.getStock() - quantity);
            productSizeService.update(productSize.getId(), productSize);

            OrderView newOrderView = OrderView.builder()
                    .orderId(newOrder.getId())
                    .userId(userId)
                    .productId(product.getId())
                    .quantity(quantity)
                    .productPrice(product.getPrice())
                    .totalPrice(product.getPrice() * quantity)
                    .deliveryStatus("배송대기")
                    .build();
            orderViewService.create(newOrderView);
            productList.add(product.getId());
        }

        List<Cart> carts = cartService.findByUserIdAndProductIds(userId, productList);
        for (Cart cart : carts) {
            cartService.delete(cart.getId());
        }
        user.setEzcoin(user.getEzcoin() - totalPrice);
        userService.update(userId, user);

        return "redirect:/cart";
    }

    @PostMapping("/chargeCoin")
    public ResponseEntity<Map<String, Boolean>> chargeCoin(@RequestParam("coin") String coin) {
        Long userId = getCurrentUserId();
        User user = userService.findById(userId);

        try {
            // 코인 값 업데이트
            user.setEzcoin(user.getEzcoin() + Integer.parseInt(coin));
            userService.update(userId, user);

            // 업데이트 성공 여부를 true로 설정
            Map<String, Boolean> response = new HashMap<>();
            response.put("updateCoin", true);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 에러 발생 시 false로 설정
            Map<String, Boolean> response = new HashMap<>();
            response.put("updateCoin", false);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
