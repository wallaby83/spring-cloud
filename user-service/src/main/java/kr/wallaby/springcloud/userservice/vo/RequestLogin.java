package kr.wallaby.springcloud.userservice.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RequestLogin {
    @NotNull(message = "Email cannot be null.")
    @Size(min = 2, message = "Email not be less than two characters")
    private String email;

    @NotNull(message = "Password cannot be null.")
    @Size(min = 8, message = "Password must me equal or grater than 8 characters")
    private String password;
}
