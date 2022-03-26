package kr.wallaby.springcloud.userservice.controller;

import kr.wallaby.springcloud.userservice.dto.UserDto;
import kr.wallaby.springcloud.userservice.jpa.UserEntity;
import kr.wallaby.springcloud.userservice.service.UserService;
import kr.wallaby.springcloud.userservice.vo.Greeting;
import kr.wallaby.springcloud.userservice.vo.RequestUser;
import kr.wallaby.springcloud.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-service")
public class UserController {
    private final Greeting greeting;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status() {
        return "It's Working in User Service.";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return greeting.getName() + ", " + greeting.getMessage();
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = mapper.map(user, UserDto.class);
        ResponseUser responseUser = mapper.map(this.userService.createUser(userDto), ResponseUser.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userList = this.userService.getUserByAll();

        List<ResponseUser> result = new ArrayList<>();
        userList.forEach(v -> result.add(new ModelMapper().map(v, ResponseUser.class)));

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUserById(@PathVariable("userId") String userId) {
        UserDto userDto = this.userService.getUserByUserId(userId);
        ResponseUser responseUser = new ModelMapper().map(userDto, ResponseUser.class);
        return ResponseEntity.status(HttpStatus.OK).body(responseUser);
    }
}
