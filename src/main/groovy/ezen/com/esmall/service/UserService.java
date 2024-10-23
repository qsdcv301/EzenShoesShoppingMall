package ezen.com.esmall.service;

import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        user.setPw(passwordEncoder.encode(user.getPw())); // 비밀번호 설정 부분 수정
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        if (user != null) {
            // 비밀번호가 제공되면 암호화 후 설정
//            if (userDetails.getPw() != null && !userDetails.getPw().isEmpty()) {
//                user.setPw(passwordEncoder.encode(userDetails.getPw())); // 새 비밀번호로 업데이트
//            } else {
//                // 새 비밀번호가 제공되지 않으면 기존 비밀번호를 유지
//                userDetails.setPw(user.getPw());
//            }
            // 모든 필드 업데이트
            user.update(userDetails.getName(), userDetails.getUid(),
//                    userDetails.getPw(), // 비밀번호는 현재 비밀번호로 설정
                    userDetails.getTel(),
                    userDetails.getAddrf(), userDetails.getAddrs(),
                    userDetails.getAddrt(), userDetails.getAddrl(),
                    userDetails.getLevel(), userDetails.getGrade(),
                    userDetails.getEmail(), // 이메일 업데이트
                    userDetails.getGender(), // 성별 업데이트
                    userDetails.getBirthday()); // 생년월일 업데이트
            return userRepository.save(user);
        }
        return null; // 사용자가 존재하지 않을 경우 null 반환
    }

    public User pwUpdate(Long id, User userDetails) {
        User user = findById(id);
        user.pwUpdate(userDetails.getName(), userDetails.getUid(),
                passwordEncoder.encode(user.getPw()),
                userDetails.getTel(),
                userDetails.getAddrf(), userDetails.getAddrs(),
                userDetails.getAddrt(), userDetails.getAddrl(),
                userDetails.getLevel(), userDetails.getGrade(),
                userDetails.getEmail(), // 이메일 업데이트
                userDetails.getGender(), // 성별 업데이트
                userDetails.getBirthday()); // 생년월일 업데이트
        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findByUidAndEmail(String uid, String email) {
        return userRepository.findByUidAndEmail(uid, email);
    }
}
