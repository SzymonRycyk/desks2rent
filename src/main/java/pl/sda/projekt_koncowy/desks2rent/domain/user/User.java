package pl.sda.projekt_koncowy.desks2rent.domain.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    @NotNull(message="user name cannot be NULL")
    private String user_name;
    @NotEmpty(message="password cannot be EMPTY")
    private String user_pass;
    @NotEmpty(message = "role cannot be NULL")
    private String user_role;
    @NotEmpty(message = "user firm cannto be EMPTY")
    private String user_firm;
    @Email
    private String user_mail;
}
