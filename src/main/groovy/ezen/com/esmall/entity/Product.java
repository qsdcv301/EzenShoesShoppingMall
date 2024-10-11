package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Builder
    public Product(String name, Integer price, Integer size, Integer stock, String description,
                   LocalDateTime createAt, Long categoryId) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.stock = stock;
        this.description = description;
        this.createAt = createAt;
        this.categoryId = categoryId;
    }

    public void update(String name, Integer price, Integer size, Integer stock, String description) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.stock = stock;
        this.description = description;
    }

}
