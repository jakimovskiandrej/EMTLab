package mk.ukim.finki.wp.lab1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1b.model.domain.User;
import mk.ukim.finki.wp.lab1b.model.enums.Role;
import mk.ukim.finki.wp.lab1b.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializerForAdminUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializerForAdminUser(UserRepository userRepository,
                                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        if (!userRepository.existsByEmail("bojana@gmail.com") &&
                !userRepository.existsByUsername("bojana")) {
            User administrator = new User(
                    "bojana",
                    "bojanova",
                    "bojana@gmail.com",
                    "bojana",
                    passwordEncoder.encode("bojana"),
                    Role.ROLE_ADMINISTRATOR
            );
            userRepository.save(administrator);
        }
    }
}