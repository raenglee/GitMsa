package com.example.org.login;

import ch.qos.logback.classic.encoder.JsonEncoder;
import com.example.org.login.jwt.JWTManager;
import com.example.org.user.User;
import com.example.org.user.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class LoginController {

    private final LoginService loginService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTManager jwtManager;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody JoinDto joinDto){
        log.info(joinDto.toString());
        loginService.join(joinDto);
        return ResponseEntity.ok("success");
    }

    @GetMapping("/login")
    public ResponseEntity<String> redirectWithPost(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            HttpServletResponse response) throws IOException {

        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(email)
        );

        boolean isMatch = passwordEncoder.matches(password, user.getPassword());
        if(isMatch){
            String jwt = jwtManager.createJWT(user.getEmail(), user.getRole());
            return ResponseEntity.ok(jwt);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("이메일과 패스워드를 확인하세요");
        }
    }

    @GetMapping("/check")
    public ResponseEntity<User> check(
            @RequestParam("jwt") String jwt,
            HttpServletResponse response) throws IOException {
        System.out.println("jwt = "+jwt);

        Jws<Claims> claimsJws = jwtManager.getClaims(jwt);
        String email = claimsJws.getPayload().get("email").toString();
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
