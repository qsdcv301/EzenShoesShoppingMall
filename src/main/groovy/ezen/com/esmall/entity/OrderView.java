package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

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

    @Column(name = "delivery_status", nullable = false, length = 50)
    private String deliveryStatus;

    @CreatedDate
    @Column(name = "delivery_at", nullable = true)
    private LocalDateTime deliveryAt;

    @Builder
    public OrderView(Long orderId, Long userId, Long productId, Integer quantity, Integer productPrice,
                     Integer totalPrice, String deliveryStatus, LocalDateTime deliveryAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.deliveryStatus = deliveryStatus;
        this.deliveryAt = deliveryAt;
    }

    public void update(String deliveryStatus, LocalDateTime deliveryAt) {
        this.deliveryStatus = deliveryStatus;
        this.deliveryAt = deliveryAt;
    }
}
