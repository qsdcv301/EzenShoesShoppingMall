package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orderview")
public class OrderView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "product_price", nullable = false)
    private Integer productPrice;

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "delivery_status", length = 50)
    private String deliveryStatus;

    @Builder
    public OrderView(Long orderId, Long userId, Long productId, Integer quantity, Integer productPrice,
                     Integer totalPrice, String deliveryStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.deliveryStatus = deliveryStatus;
    }

    public void update(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
