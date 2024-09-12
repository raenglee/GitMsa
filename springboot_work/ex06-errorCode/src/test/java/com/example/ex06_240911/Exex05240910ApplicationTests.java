package com.example.ex06_240911;

import com.example.ex06_240911.obj.AA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Exex05240910ApplicationTests {

	@Autowired	//테스트에서 AA클래스 쓸라면 이거 써야함
public AA aa;


	@Test
	void contextLoads() {
		aa.doA();
	}

}
