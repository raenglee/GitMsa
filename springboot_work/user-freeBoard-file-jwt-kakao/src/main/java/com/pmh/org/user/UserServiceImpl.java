package com.pmh.org.user;

import com.pmh.org.error.BizException;
import com.pmh.org.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public void insert(UserReqDto userReqDto){

        Optional<User> optionalUser = userRepository.findByEmail(userReqDto.getEmail());
        optionalUser.ifPresent(user -> {
            throw new BizException(ErrorCode.DUPLICATE_USERS);
        });

        System.out.println("실행"+ userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+ user);
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
