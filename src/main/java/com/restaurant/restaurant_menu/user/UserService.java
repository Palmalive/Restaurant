package com.restaurant.restaurant_menu.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(){
        User user = new User();
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode("1"));
        user.getRoles().add(UserRole.ROLE_ADMIN);
        userRepository.save(user);
    }

    public User getUserByPrincipal(Principal principal) {
        if(principal == null){
            return new User();
        }
        return userRepository.findByUsername(principal.getName());
    }
}
