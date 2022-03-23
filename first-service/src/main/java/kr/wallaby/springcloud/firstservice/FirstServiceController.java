package kr.wallaby.springcloud.firstservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/first-service/")
@Slf4j
public class FirstServiceController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the first service";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("first-request") String header) {
        log.info(header);
        return "Hello world in first service.";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server Port: {}", request.getServerPort());
        return String.format("Hi, there. This is message from First Service on Port %s", request.getServerPort());
    }
}
