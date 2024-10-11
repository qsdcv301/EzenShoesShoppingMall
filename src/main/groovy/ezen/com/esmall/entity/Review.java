package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "star_rate", nullable = false)
    private Integer starRate;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Builder
    public Review(Long userId, Long productId, String comment, String title, Integer starRate, LocalDateTime createAt) {
        this.userId = userId;
        this.productId = productId;
        this.comment = comment;
        this.title = title;
        this.starRate = starRate;
        this.createAt = createAt;
    }

    public void update(String comment, String title, Integer starRate) {
        this.comment = comment;
        this.title = title;
        this.starRate = starRate;
    }
}
