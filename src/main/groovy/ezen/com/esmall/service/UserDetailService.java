package ezen.com.esmall.service;

import ezen.com.esmall.entity.User;
import ezen.com.esmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String userid) {
        return userRepository.findByUid(userid)
                .orElseThrow(() -> new IllegalArgumentException((userid)));
    }
}