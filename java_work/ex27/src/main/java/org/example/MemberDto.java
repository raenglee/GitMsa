package org.example;

public class MemberDto {
    private static String URL="http://kakaoLogin";

    static class MemberReqDto{
        private String name;
        private int age;

        public MemberReqDto(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "MemberReqDto{" +
                    "URL='" + URL + '\'' +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



    static class MemberResDto{
        private String name;
        private int age;

        public MemberResDto(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "MemberResDto{" +
                    "URL='" + URL + '\'' +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
