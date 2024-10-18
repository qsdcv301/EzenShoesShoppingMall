package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "productsize")
public class ProductSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "size", nullable = false, length = 10)
    private String size;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @Builder
    public ProductSize(Long productId, String size, Integer stock) {
        this.productId = productId;
        this.size = size;
        this.stock = stock;
    }

    public void updateStock(Integer stock) {
        this.stock = stock;
    }
}
