package ezen.com.esmall.controller;

import ezen.com.esmall.entity.*;
import ezen.com.esmall.repository.UserRepository;
import ezen.com.esmall.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Controller
public class PageController {

    private static final String VERIFICATION_CODE_SESSION_KEY = "verificationCode";

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserService userService;
    private final ProductService productService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private CartService cartService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public EmailService emailService;
    @Autowired
    private ProductSizeService productSizeService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String userName = authentication.getName();
            try {
                Long userId = userDetailService.loadUserByUsername(userName).getId();
                User user = userService.findById(userId);
                model.addAttribute("username", user.getName());
                model.addAttribute("usercoin", user.getEzcoin());
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
                user.getAddrt(), user.getAddrl(), 1, 1, user.getEmail(), user.getGender(), user.getBirthday());
        userService.create(userData);
        return "redirect:/";
    }


    @PostMapping("/duplicateId")
    public ResponseEntity<Map<String, Boolean>> checkDuplicateId(@RequestParam("uid") String uid) {
        System.out.println(uid);
        boolean isDuplicate = userRepository.findByUid(uid).isPresent();
        System.out.println(isDuplicate);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isDuplicate", isDuplicate); // 실제 중복 여부에 따라 설정
        return ResponseEntity.ok(response);
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
        List<Product> products = productService.findAll();
        String[] imageUrls = new String[products.size()];
        String[] categories = new String[products.size()];
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            String categoryFolder;
            // 카테고리 ID에 따라 폴더 이름 결정
            if (product.getCategoryId() == 1) {
                categoryFolder = "nike";
            } else if (product.getCategoryId() == 2) {
                categoryFolder = "adidas";
            } else if (product.getCategoryId() == 3) {
                categoryFolder = "vans";
                // 다른 카테고리 추가 가능
            } else {
                categoryFolder = "default"; // 카테고리가 없을 경우 default 폴더 사용
            }
            categories[i] = categoryFolder;
            String imageUrl = String.format("/images/%s/%s_%s.png",
                    product.getCategoryId() != null ? categoryFolder : "default",  // 카테고리가 없을 경우 default 폴더 사용
                    product.getName(),
                    product.getName().substring(product.getName().length() - 2));
            imageUrls[i] = imageUrl;
        }
        model.addAttribute("imageUrls", imageUrls);
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
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
                                 @RequestParam(value = "category", defaultValue = "default", required = false) String category,
                                 Model model) {
        // 상품 정보 조회
        Product product = productService.findById(productCode);
        List<Review> reviews = reviewService.findAllByProductId(productCode);
        int reviewsCount = reviewService.countAllByProductId(productCode);

        // 각 리뷰에 대해 사용자 정보 포함한 데이터를 준비
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        List<Map<String, Object>> reviewDetails = new ArrayList<>();
        for (Review review : reviews) {
            Map<String, Object> reviewData = new HashMap<>();
            reviewData.put("review", review);
            reviewData.put("userId", userService.findById(review.getUserId()).getUid());
            reviewData.put("formattedCreateAt", review.getCreateAt().format(formatter));
            reviewDetails.add(reviewData);
        }

        // 상품 이미지 URL 생성
        String[] imageUrls = new String[6];
        for (int i = 0; i < imageUrls.length; i++) {
            imageUrls[i] = String.format("/images/%s/%s_0%d.png",
                    category, product.getName(), i + 1);
        }

        // 구입 가능한 사이즈 가져오기
        Map<String, Boolean> sizes = new LinkedHashMap<>();
        List<ProductSize> sizeList = productSizeService.findALLByProductId(product.getId());
        for (ProductSize size : sizeList) {
            sizes.put(size.getSize(), size.getStock() > 0);
        }
        System.out.println(sizes);
        // 모델에 데이터 추가
        model.addAttribute("imageUrls", imageUrls);
        model.addAttribute("category", category);
        model.addAttribute("product", product);
        model.addAttribute("sizes", sizes);  // 사이즈 정보 추가
        model.addAttribute("reviewsCount", reviewsCount);
        model.addAttribute("reviewDetails", reviewDetails); // 리뷰 데이터 추가

        return "productsDetail";
    }

    @GetMapping("/findIdPw")
    public String findIdPw(Model model) {
        return "findIdPw";
    }

    @PostMapping("/emailAuthentication")
    public ResponseEntity<Map<String, Boolean>> emailAuthentication(@RequestParam("email") String email, HttpSession session) {
        // 무작위 6자리 번호 생성
        String verificationCode = generateVerificationCode();
        session.setAttribute(VERIFICATION_CODE_SESSION_KEY, verificationCode);
        // 이메일 발송
        emailService.sendEmail(email, "EzMall 이메일 인증", "귀하의 인증 번호는: " + verificationCode);

        Map<String, Boolean> response = new HashMap<>();
        boolean isEmail = true;
        response.put("isEmail", isEmail);
        return ResponseEntity.ok(response);
    }

    // 무작위 6자리 인증 번호 생성
    private String generateVerificationCode() {
        Random random = new Random();
        int code = random.nextInt(999999); // 0부터 999999까지 무작위 숫자 생성
        return String.format("%06d", code); // 6자리로 포맷
    }

    @PostMapping("/findId")
    public ResponseEntity<Map<String, Object>> findId(@RequestParam("name") String name,
                                                      @RequestParam("email") String email,
                                                      @RequestParam("verificationCode") String verificationCode,
                                                      HttpSession session, Model model) {
        String storedCode = (String) session.getAttribute(VERIFICATION_CODE_SESSION_KEY);
        Map<String, Object> response = new HashMap<>();

        if (storedCode != null && storedCode.equals(verificationCode)) {
            Optional<User> userOptional = userService.findByNameAndEmail(name, email);
            if (userOptional.isPresent()) {
                response.put("success", true);
                response.put("findUserName", userOptional.get().getUsername());
            } else {
                response.put("success", false);
            }
        } else {
            response.put("success", false);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/newPassword")
    public ResponseEntity<Map<String, Boolean>> newPassword(@RequestParam("uid") String uid,
                                                            @RequestParam("email") String email,
                                                            @RequestParam("verificationCode") String verificationCode,
                                                            Model model, HttpSession session) {
        String storedCode = (String) session.getAttribute(VERIFICATION_CODE_SESSION_KEY);
        Map<String, Boolean> response = new HashMap<>();

        if (storedCode != null && storedCode.equals(verificationCode)) {
            Optional<User> userOptional = userService.findByUidAndEmail(uid, email);
            if (userOptional.isPresent()) {
                response.put("success", true);
            } else {
                response.put("success", false);
            }
        } else {
            response.put("success", false);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateUserPw")
    public ResponseEntity<Map<String, Boolean>> updateUserPw(@RequestParam("uid") String uid,
                                                             @RequestParam("newPw") String newPw, Model model) {
        Map<String, Boolean> response = new HashMap<>();

        Optional<User> userOptional = userService.findByUid(uid);
        if (userOptional.isPresent()) {
            userOptional.get().setPw(newPw);
            userService.pwUpdate(userOptional.get().getId(), userOptional.get());
            response.put("success", true);
        } else {
            response.put("success", false);
        }
        return ResponseEntity.ok(response);
    }

}


