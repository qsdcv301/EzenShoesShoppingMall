package ezen.com.esmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "uid", nullable = false, length = 50, unique = true)
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

    @Column(name = "create_at", updatable = false)
    private LocalDateTime createAt;

    @Column(name = "level", nullable = false)
    private Integer level;

    @Column(name = "grade", nullable = false)
    private Integer grade;

    @Column(name = "email", length = 100)
    private String email; // 이메일 필드

    @Column(name = "gender", length = 15)
    private String gender; // 성별 필드

    @Column(name = "birthday") // 생년월일
    private int birthday;

    @Column(name = "ezcoin", nullable = false)
    private Integer ezcoin = 0; // 기본값 0

    @Builder
    public User(String name, String uid, String pw, String tel, Integer addrf, String addrs, String addrt,
                String addrl, LocalDateTime createAt, Integer level, Integer grade, String email,
                String gender, Integer birthday) {
        this.name = name;
        this.uid = uid;
        this.pw = pw;
        this.tel = tel;
        this.addrf = addrf;
        this.addrs = addrs;
        this.addrt = addrt;
        this.addrl = addrl;
        this.createAt = createAt != null ? createAt : LocalDateTime.now(); // 현재 시간으로 초기화
        this.level = level;
        this.grade = grade;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void update(String name, String uid, String pw, String tel, Integer addrf, String addrs, String addrt,
                       String addrl, Integer level, Integer grade, String email, String gender, Integer birthday) {
        this.name = name;
        this.uid = uid;
        if (pw != null && !pw.isEmpty()) {
            this.pw = pw;
        }
        this.tel = tel;
        this.addrf = addrf;
        this.addrs = addrs;
        this.addrt = addrt;
        this.addrl = addrl;
        this.level = level;
        this.grade = grade;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername() {
        return uid;
    }

    @Override
    public String getPassword() {
        return pw;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
