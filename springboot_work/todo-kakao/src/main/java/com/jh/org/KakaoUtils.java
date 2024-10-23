package com.jh.org;

public class KakaoUtils {

    public static String messageString() {
        return "{\n" +
                "        \"object_type\": \"text\",\n" +
                "        \"text\": \"%s %s\",\n" +
                "        \"link\": {\n" +
                "            \"web_url\": \"http://first.hellomh.site/first/test\",\n" +
                "            \"mobile_web_url\": \"http://first.hellomh.site/first/test\"\n" +
                "        },\n" +
                "        \"button_title\": \"바로 확인\"\n" +
                "    }";
    }

}
