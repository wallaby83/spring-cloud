package kr.wallaby.springcloud.userservice.service;

import kr.wallaby.springcloud.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
