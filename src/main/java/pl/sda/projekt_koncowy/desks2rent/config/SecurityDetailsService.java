package pl.sda.projekt_koncowy.desks2rent.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.sda.projekt_koncowy.desks2rent.domain.user.User;
import pl.sda.projekt_koncowy.desks2rent.domain.user.UserRepository;

import java.util.Collections;
import java.util.List;

public class SecurityDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.getByUsername(username).map(usr -> new User(usr.getUsername(), usr.getUserpass(),
                usr.getUserfirm(), usr.getUsermail(), mapRole(usr.getUserrole())))
                .orElseThrow(() -> new UsernameNotFoundException("User does not exists"));
    }

    private List<GrantedAuthority> mapRole(String userrole){
        GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+userrole);
        return Collections.singletonList(authority);
    }
}
