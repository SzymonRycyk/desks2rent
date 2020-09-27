package pl.sda.projekt_koncowy.desks2rent.domain.user;

import java.util.Optional;

public interface UserRepository {
    void create(User user);
    Optional<User> getByUsername(String username);
}
