package kr.wallaby.springcloud.userservice.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Greeting {
    @Value("${greeting.message}")
    private String message;
}
