package org.example.service.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.repository.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean isPasswordValid(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    public User save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles("ROLE_MEMBER");
        return userRepository.save(user);
    }
}














