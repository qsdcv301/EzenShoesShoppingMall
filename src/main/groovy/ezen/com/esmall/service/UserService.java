package ezen.com.esmall.service;

import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User userDetails) {
        User user = findById(id);
        if (user != null) {
            user.update(userDetails.getName(), userDetails.getUid(), userDetails.getPw(),
                    userDetails.getTel(), userDetails.getAddrf(),
                    userDetails.getAddrs(), userDetails.getAddrt(),
                    userDetails.getAddrl(), userDetails.getLevel(),
                    userDetails.getGrade());
            return userRepository.save(user);
        }
        return null;
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
