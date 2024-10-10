package com.example.org.test;

//@RestController
//@RequestMapping("test")
public class TestController {

//    private final Environment environment;
//    private final String secretKey;
//    private final JWTManager jwtManager;

//    public TestController(Environment environment, JWTManager jwtManager) {
//        this.environment = environment;
//        this.secretKey = environment.getProperty("spring.jwt.secret");
//        this.jwtManager = jwtManager;
//    }
//
//    @GetMapping("maketoken")
//    public String maketoken(){
//        String jwt = jwtManager.createJWT(secretKey);
//        return "maketoken "+ jwt;
//    }
//
//    @GetMapping("validtoken")
//    public String validtoken(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization){
//        // jwt 토큰을 검증
//        String result = jwtManager.validJWT(authorization.split(" ")[1], secretKey);
//        return "validtoken "+ result;
//    }
}
