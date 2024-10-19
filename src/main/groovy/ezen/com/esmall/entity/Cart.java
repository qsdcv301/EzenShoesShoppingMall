package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "size")
    private Integer size;

    @Column(name = "quantity")
    private Integer quantity;

    @Builder
    public Cart(Long userId, Long productId, Integer size, Integer quantity) {
        this.userId = userId;
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
    }

    public void update(Long productId, Integer quantity) {
        this.productId = productId;
        this.size = size;
        this.quantity = quantity;
    }
}
