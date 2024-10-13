package ezen.com.esmall.service;

import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        // 비밀번호 암호화
        user.setPw(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        if (user != null) {
            if (userDetails.getPw() != null && !userDetails.getPw().isEmpty()) {
                user.setPw(passwordEncoder.encode(userDetails.getPw()));
            }
            user.update(userDetails.getName(), userDetails.getUid(),
                    user.getPw(),
                    userDetails.getTel(),
                    userDetails.getAddrf(), userDetails.getAddrs(),
                    userDetails.getAddrt(), userDetails.getAddrl(),
                    userDetails.getLevel(), userDetails.getGrade());
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
