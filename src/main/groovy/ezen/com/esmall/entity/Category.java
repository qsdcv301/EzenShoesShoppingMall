package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 225)
    private String name;

    @Builder
    public Category(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
