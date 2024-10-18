package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 225)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    // Product와 ProductSize 간의 연관관계 매핑
    @OneToMany
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private List<ProductSize> sizes;


    @Builder
    public Product(String name, Integer price, String description,
                   LocalDateTime createAt, Long categoryId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.createAt = createAt;
        this.categoryId = categoryId;
    }

    public void update(String name, Integer price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
