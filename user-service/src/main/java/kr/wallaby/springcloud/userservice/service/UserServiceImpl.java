package kr.wallaby.springcloud.userservice.service;

import kr.wallaby.springcloud.userservice.dto.UserDto;
import kr.wallaby.springcloud.userservice.jpa.UserEntity;
import kr.wallaby.springcloud.userservice.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDto, UserEntity.class);
        userEntity.setEncryptedPwd(this.passwordEncoder.encode(userDto.getPwd()));

        this.userRepository.save(userEntity);

        return mapper.map(userEntity, UserDto.class);
    }
}
