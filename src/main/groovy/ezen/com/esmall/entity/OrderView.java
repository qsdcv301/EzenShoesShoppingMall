package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orderview")
public class OrderView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "delivary_status", nullable = false)
    private Integer deliveryStatus;

    @CreatedDate
    @Column(name = "delivary_at", nullable = false)
    private LocalDateTime deliveryAt;

    @Builder
    public OrderView(Long orderId, Integer deliveryStatus, LocalDateTime deliveryAt) {
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryAt = deliveryAt;
    }

    public void update(Integer deliveryStatus, LocalDateTime deliveryAt) {
        this.deliveryStatus = deliveryStatus;
        this.deliveryAt = deliveryAt;
    }
}
