package ezen.com.esmall.service;

import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String uid) {
        return userRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + uid));
    }
}