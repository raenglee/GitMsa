package com.example.ex10.login;

import com.example.ex10.user.User;
import com.example.ex10.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public void join(JoinDto joinDto) {
    User user = modelMapper.map(joinDto, User.class);
    // username -> name
    user.setName(joinDto.getUsername());
    // password 암호화(관리자도 고객의 패스워드를 알 수 없도록)
    user.setPassword(
            passwordEncoder.encode(joinDto.getPassword()));

//    user.setRole("ROLE_USER");
    user.setRole("ROLE_ADMIN");

    User dbUser = userRepository.save(user);

}
}