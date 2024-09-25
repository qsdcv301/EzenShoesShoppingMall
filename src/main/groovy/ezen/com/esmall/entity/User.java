package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "uid", nullable = false, length = 50)
    private String uid;

    @Column(name = "pw", nullable = false, length = 225)
    private String pw;

    @Column(name = "tel", nullable = false, length = 15)
    private String tel;

    @Column(name = "addrf", nullable = false)
    private Integer addrf;

    @Column(name = "addrs", nullable = false, length = 225)
    private String addrs;

    @Column(name = "addrt", nullable = false, length = 225)
    private String addrt;

    @Column(name = "addrl", length = 225)
    private String addrl;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "cart_id", nullable = false)
    private Integer cartId;

    @Builder
    public User(String name, String uid, String pw, String tel, Integer addrf, String addrs, String addrt, String addrl, LocalDateTime createAt, Integer level, Integer grade, Integer cartId) {
        this.name = name;
        this.uid = uid;
        this.pw = pw;
        this.tel = tel;
        this.addrf = addrf;
        this.addrs = addrs;
        this.addrt = addrt;
        this.addrl = addrl;
        this.createAt = createAt;
        this.level = level;
        this.grade = grade;
        this.cartId = cartId;
    }

    public void update(String name, String uid, String pw, String tel, Integer addrf, String addrs, String addrt, String addrl, Integer level, Integer grade) {
        this.name = name;
        this.uid = uid;
        this.pw = pw;
        this.tel = tel;
        this.addrf = addrf;
        this.addrs = addrs;
        this.addrt = addrt;
        this.addrl = addrl;
        this.level = level;
        this.grade = grade;
    }
}
