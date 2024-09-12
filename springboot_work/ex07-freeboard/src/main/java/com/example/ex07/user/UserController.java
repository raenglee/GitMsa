package com.example.ex07.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")     //user에 select, insert 되도록해줌
@RequiredArgsConstructor
@CrossOrigin

public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("select")
    public ResponseEntity<List<User>> select() {
        return ResponseEntity.status(200).body(userRepository.findAll());  // 에러확인
//        return userRepository.findAll();    //findAll()->try~catch처리 다해줌
    }


    @PostMapping("insert")
    public ResponseEntity<String> insert(@Valid @RequestBody UserReqDto userReqDto) {

        userService.insert(userReqDto);

        //select * from where idx = ?
//        userRepository.findAllById()
        //select * from where email = ?
//        userRepository.find??? -> userservice 에서 지정해줌


    //insert 전에 유효성검사.. 빌드 dependencies~validation 추가 후@NotEmpty 붙여주면 그 객체의 정보가 없을 때 처리안하고 오류뜸
    //RequestBody User user -> DB에 insert 실행
    //RequestBody User user 이것만 쓰면 데이터가 비어있어도 걍 완료처리됨
    //그래서 UserReqDto클래스를 만들어서
    //UserReqDto->들어가야할 데이터 걸러줌
    //User에 바로 @NotEmpty 적지 말고 UserReqDto 클래스 따로 빼서 지정해줘야함...걍 개발패턴이라 이렇게 하십시오...

//        System.out.println("실행");
//
////        userRepository.save(user);
//
////        userRepository.save(userReqDto);
////        -> UserRepository에 제네릭이 JpaRepository<User,Long>로 되어있어서 실행 안 됨
//        //쓸라면 User,Long을 UserReqDto,Long으로 바꿔야함
//
//
//        ModelMapper modelMapper = new ModelMapper();    //빌드에 ModelMapper dependencies 추가햇음
//        //userReqDto 내용을 복사해서 User.class로
//        User user = modelMapper.map(userReqDto, User.class);
//        System.out.println("user = " + user);
//        userRepository.save(user);
        return ResponseEntity.status(200).body("success insert");
    }

    @PutMapping("update")
    public String update(@Valid @RequestBody UserReqDto userReqDto) {
        System.out.println("실행");
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = " + user);
        userRepository.save(user);
        return "ok";
    }

    @DeleteMapping("delete/{idx}")
    public String delete(@PathVariable long idx){
        userRepository.deleteById(idx);
        return "delete";


        //http://localhost:8080/user/delete/1 ->1: 삭제할 idx
    }

}
