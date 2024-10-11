package com.example.org.login;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.org.login.jwt.JWTManager;
import com.example.org.user.User;
import com.example.org.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTManager jwtManager;

    @PostMapping("/join")
    //리스폰스엔티티안쓰면 에러에도 200ok가 떨어져서 사용 하는것
    public ResponseEntity join(@RequestBody JoinDto joinDto) {
        loginService.join(joinDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/check")
    public ResponseEntity<User> check(
            @RequestParam("jwt") String jwt,
            HttpServletResponse response) throws IOException {

        //jwt가 유효한지 확인, 유효하지 않으면 갑자기 Exception 발생
        Jws<Claims> claimsJws = jwtManager.getClaims(jwt);
        //jwt가 유효하면 email 가져오기
        String email = claimsJws.getPayload().get("email").toString();
        // email로 DB테이블 조회
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );
        return ResponseEntity.ok(user);
    }
}

// 해당 되는 email 이 있는지
//        User user = userRepository.findByEmail(email).orElseThrow(
//                () -> new UsernameNotFoundException(email)
//        );
//
//        boolean isMatch = passwordEncoder.matches(password, user.getPassword());
//        if(isMatch){
//            String jwt = jwtManager.createJWT(user.getEmail(), user.getRole());
//            return ResponseEntity.ok(jwt);
//        }else{
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body("이메일과 패스워드를 확인하세요");
//        }
//    }
//}

// swagger 문서에서 사용 가능하도록
//    @GetMapping("/login")
//    public void redirectWithPost(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            HttpServletResponse response) throws IOException {
//        // login으로 진행 해라
//        response.sendRedirect("/login");
//    }
