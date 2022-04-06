package kr.wallaby.springcloud.userservice.service;

import kr.wallaby.springcloud.userservice.dto.UserDto;
import kr.wallaby.springcloud.userservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
