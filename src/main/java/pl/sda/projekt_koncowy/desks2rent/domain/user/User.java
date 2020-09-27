package pl.sda.projekt_koncowy.desks2rent.domain.user;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Integer id;
    @NotNull(message="user name cannot be NULL")
    private String username;
    @NotEmpty(message="password cannot be EMPTY")
    private String userpass;
    @NotEmpty(message = "role cannot be EMPTY")
    private String userrole;
    @NotEmpty(message = "user firm cannot be EMPTY")
    private String userfirm;
    @Email
    private String usermail;

    public void encodePassword(PasswordEncoder passwordEncoder, String rawPassword) {
        this.userpass = passwordEncoder.encode(rawPassword);
    }
}
