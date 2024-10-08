package com.example.org.login;

import com.example.org.user.User;
import com.example.org.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    //회원가입
    public void join(JoinDto joinDto) {
        User user = modelMapper.map(joinDto, User.class);
        user.setPassword(
                passwordEncoder.encode(joinDto.getPassword())
        );
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        //해당되는 이메일이 있는지 DB에서 확인
        //없으면 throw로 UsernameNotFoundException 실행
        User user = userRepository.findByEmail(username).orElseThrow(
                ()-> new UsernameNotFoundException(username)
        );

        //password가 1234면 ADMIN 으로 로그인
        return org.springframework.security.core.userdetails
                .User
                .builder()
                .username(user.getEmail())
                // 데이터베이스 안에 이미 암호화 되어있는 값이 나옴
                .password(user.getPassword())
                //암호화되어있는 값을 또 암호화
//                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();
    }
}