package com.example.ex10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//@SpringBootTest
class Ex10ApplicationTests {

	@Test
	void contextLoads() {

		String []str = {"10입니다", "20입니다", "30입니다"};

		Arrays.stream(str).forEach(System.out::println);
//		Arrays.stream(str).reduce("",(s, s2) -> {return s+s2;} );
		String result = Arrays.stream(str).reduce("",(s, s2) -> s+s2 );
		System.out.println("result = " + result);
	}
}