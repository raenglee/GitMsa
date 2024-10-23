package com.jh.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KakaoApplication {

	public static String templateString() {
		return "{\n" +
				"        \"object_type\": \"feed\",\n" +
				"        \"content\": {\n" +
				"            \"title\": \"오늘의 MSA\",\n" +
				"            \"description\": \"여기서 내용 변경이 가능합니다\",\n" +
				"            \"image_url\": \"https://mud-kage.kakao.com/dn/NTmhS/btqfEUdFAUf/FjKzkZsnoeE4o19klTOVI1/openlink_640x640s.jpg\",\n" +
				"            \"image_width\": 640,\n" +
				"            \"image_height\": 640,\n" +
				"            \"link\": {\n" +
				"                \"web_url\": \"http://www.daum.net\",\n" +
				"                \"mobile_web_url\": \"http://m.daum.net\",\n" +
				"                \"android_execution_params\": \"contentId=100\",\n" +
				"                \"ios_execution_params\": \"contentId=100\"\n" +
				"            }\n" +
				"        },\n" +
				"        \"item_content\" : {\n" +
				"            \"profile_text\" :\"Kakao\",\n" +
				"            \"profile_image_url\" :\"https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png\",\n" +
				"            \"title_image_url\" : \"https://mud-kage.kakao.com/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png\",\n" +
				"            \"title_image_text\" :\"Cheese cake\",\n" +
				"            \"title_image_category\" : \"Cake\",\n" +
				"            \"items\" : [\n" +
				"                {\n" +
				"                    \"item\" :\"Cake1\",\n" +
				"                    \"item_op\" : \"1000원\"\n" +
				"                },\n" +
				"                {\n" +
				"                    \"item\" :\"Cake2\",\n" +
				"                    \"item_op\" : \"2000원\"\n" +
				"                },\n" +
				"                {\n" +
				"                    \"item\" :\"Cake3\",\n" +
				"                    \"item_op\" : \"3000원\"\n" +
				"                },\n" +
				"                {\n" +
				"                    \"item\" :\"Cake4\",\n" +
				"                    \"item_op\" : \"4000원\"\n" +
				"                },\n" +
				"                {\n" +
				"                    \"item\" :\"Cake5\",\n" +
				"                    \"item_op\" : \"5000원\"\n" +
				"                }\n" +
				"            ],\n" +
				"            \"sum\" :\"Total\",\n" +
				"            \"sum_op\" : \"15000원\"\n" +
				"        },\n" +
				"        \"social\": {\n" +
				"            \"like_count\": 100,\n" +
				"            \"comment_count\": 200,\n" +
				"            \"shared_count\": 300,\n" +
				"            \"view_count\": 400,\n" +
				"            \"subscriber_count\": 500\n" +
				"        },\n" +
				"        \"buttons\": [\n" +
				"            {\n" +
				"                \"title\": \"웹으로 이동\",\n" +
				"                \"link\": {\n" +
				"                    \"web_url\": \"http://www.daum.net\",\n" +
				"                    \"mobile_web_url\": \"http://m.daum.net\"\n" +
				"                }\n" +
				"            },\n" +
				"            {\n" +
				"                \"title\": \"앱으로 이동\",\n" +
				"                \"link\": {\n" +
				"                    \"android_execution_params\": \"contentId=100\",\n" +
				"                    \"ios_execution_params\": \"contentId=100\"\n" +
				"                }\n" +
				"            }\n" +
				"        ]\n" +
				"    }";
	}

	public static void main(String[] args) {
		SpringApplication.run(KakaoApplication.class, args);
	}

}
