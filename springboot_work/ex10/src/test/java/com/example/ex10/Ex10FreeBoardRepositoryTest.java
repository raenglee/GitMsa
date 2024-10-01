//package com.example.ex10;
//
//import com.example.ex10.freeboard.FreeBoard;
//import com.example.ex10.freeboard.FreeBoardRepository;
//import com.example.ex10.user.User;
//import com.example.ex10.user.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class Ex10FreeBoardRepositoryTest {
//
//    //1. UserRepository 가져오기
//    //2. Cascade JAP 속성
//    @Autowired
//    FreeBoardRepository freeBoardRepository;
//
////    @Autowired
//    UserRepository userRepository;
//
//    @Test
////    @Transactional //테스트한 인서트들 없애줌
//    void insertTest(){
//        User user = User.builder()
//                .name("gg")
//                .age(20)
//                .email("2asdadd@naver.com")
//                .password("Gg")
//                .build();
//
////        userRepository.save(user);
//
//        FreeBoard freeBoard =  FreeBoard.builder()
//                .title("제목")
//                .content("내용")
//                .user(user)
//                .build();
//        freeBoardRepository.save(freeBoard);
//    }
//
//    @Test
//    void selectTest(){
//        List<FreeBoard> list = freeBoardRepository.findAll();
//        list.stream().forEach(System.out::println);
//    }
//
//    @Test
//    void deleteTest(){
//        freeBoardRepository.deleteById(1l);
//    }
//
//    void updateTest(){
////        User user = User.builder()
////                .idx(1l)
////                .name("강아지")
////                .age(20)
////                .email("dog@naver.com")
////                .password("Gg")
////                .build();
//
//        User user = userRepository.findById(1l).orElseThrow();
//
//        FreeBoard freeBoard =  FreeBoard.builder()
////                .idx(2l)
//                .title("제목")
//                .content("내용")
//                .user(user)
//                .build();
//        freeBoardRepository.save(freeBoard);
//    }
//}
