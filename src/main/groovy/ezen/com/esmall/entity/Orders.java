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
@Table(name = "orders")  // 테이블 이름을 MySQL 덤프와 일치시킴
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "total_price", nullable = false)  // 필드 이름을 MySQL과 일치시킴
    private Integer totalPrice;

    @Column(name = "addrs", nullable = false)  // 필드 이름을 MySQL과 일치시킴
    private String addr;

    @Column(name = "order_time")  // 필드 이름을 MySQL과 일치시킴
    private LocalDateTime orderTime;

    @Builder
    public Orders(Long userId, Integer totalPrice, String addr, LocalDateTime orderTime) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.addr = addr;
        this.orderTime = orderTime;
    }

    public void update(Integer totalPrice, String addr) {
        this.totalPrice = totalPrice;
        this.addr = addr;
    }
}
