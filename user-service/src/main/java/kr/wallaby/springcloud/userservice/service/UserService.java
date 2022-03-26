package kr.wallaby.springcloud.userservice.service;

import kr.wallaby.springcloud.userservice.dto.UserDto;
import kr.wallaby.springcloud.userservice.jpa.UserEntity;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
