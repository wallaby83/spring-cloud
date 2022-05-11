package kr.wallaby.springcloud.apigatewayservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequiredArgsConstructor
@RestController
public class ApiGatewayServiceApplication {
    private final Environment env;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceApplication.class, args);
    }

    @Bean
    public HttpTraceRepository httpTraceRepository() {
        return new InMemoryHttpTraceRepository();
    }


    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service." +
                " port(local.server.port)=" + env.getProperty("local.server.port") +
                "\n port(server.port)=" + env.getProperty("server.port") +
                "\n token secret=" + env.getProperty("token.secret") +
                "\n token expiration time=" + env.getProperty("token.expiration_time")
                ;
    }
}
