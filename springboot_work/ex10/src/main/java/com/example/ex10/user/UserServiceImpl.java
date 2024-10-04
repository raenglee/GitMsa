package com.example.ex10.user;


import com.example.ex10.error.BizException;
import com.example.ex10.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    //email 중복이면 에러코드
    //email 중복이 아니면 insert 정상적으로 입력
    public void insert(UserReqDto userReqDto) {
        // ifPersent = 옵셔널유저가 있으면, 존재하면
        Optional<User> optionalUser = userRepository.findByEmail(userReqDto.getEmail());
        optionalUser.ifPresent(user -> {
            throw new BizException(ErrorCode.DUPLICATE_USERS);
        });

        System.out.println("실행 = " + userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = " + user);
        userRepository.save(user);
    }

    @Override
    public void update(UserReqDto userReqDto) {
        User dbUser = userRepository.findById(
                userReqDto.getIdx()).orElseThrow(() -> { throw new BizException(ErrorCode.NOT_FOUND); } );

        // list 가 없어지기 때문에 작성했는글이 수정된다.
//        dbUser = modelMapper.map(userReqDto, User.class);

        dbUser.setName(userReqDto.getName());

        userRepository.save(dbUser);
    }
}