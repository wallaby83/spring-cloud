package kr.wallaby.springcloud.userservice.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseUser {
    private String email;
    private String name;
    private String userId;
}
