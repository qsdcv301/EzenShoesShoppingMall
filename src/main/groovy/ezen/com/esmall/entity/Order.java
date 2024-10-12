package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "order_number", nullable = false, length = 50)
    private String orderNumber;

    @Column(name = "totalprice", nullable = false)
    private Integer totalPrice;

    @Column(name = "payment", nullable = false, length = 255)
    private String payment;

    @Column(name = "addr", nullable = false)
    private String addr;

    @Column(name = "ordertime")
    private LocalDateTime orderTime;

    @Builder
    public Order(Long userId, String orderNumber, Integer totalPrice, String payment, String addr, LocalDateTime orderTime) {
        this.userId = userId;
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.addr = addr;
        this.orderTime = orderTime;
    }

    public void update(String orderNumber, Integer totalPrice, String payment, String addr) {
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.addr = addr;
    }
}
