package pl.sda.projekt_koncowy.desks2rent.external.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.projekt_koncowy.desks2rent.domain.user.User;
import pl.sda.projekt_koncowy.desks2rent.domain.user.UserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DatabaseUserRepository implements UserRepository {

    private JpaUserRepository userRepository;

    @Override
    public void create(User user) {
        UserEntity entity = UserEntity.builder()
                .username(user.getUsername())
                .userpass(user.getUserpass())
                .userrole(user.getUserrole())
                .userfirm(user.getUserfirm())
                .usermail(user.getUsermail())
                .build();
        userRepository.save(entity);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(ent -> new User(ent.getId(),
                        ent.getUsername(),
                        ent.getUserpass(),
                        ent.getUserrole(),
                        ent.getUserfirm(),
                        ent.getUsermail()));
    }
}
