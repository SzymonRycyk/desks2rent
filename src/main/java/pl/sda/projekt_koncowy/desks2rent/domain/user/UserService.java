package pl.sda.projekt_koncowy.desks2rent.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(User user) {
        if (userRepository.getByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("User with given login already exists");
        }
        user.encodePassword(passwordEncoder, user.getUserpass());

        userRepository.create(user);
    }
}

