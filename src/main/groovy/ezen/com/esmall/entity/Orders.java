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

    @Column(name = "total_price", nullable = false)
    private Integer totalPrice;

    @Column(name = "addrs", nullable = false)
    private String addrs;

    @Column(name = "addrt", nullable = false)
    private String addrt;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Builder
    public Orders(Long userId, Integer totalPrice, String addrs, String addrt) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.addrs = addrs;
        this.addrt = addrt;
        this.orderTime = LocalDateTime.now();
    }

    public void update(Integer totalPrice, String addr, String addrt) {
        this.totalPrice = totalPrice;
        this.addrs = addr;
        this.addrt = addrt;
    }
}
