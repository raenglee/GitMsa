package org.example;

public class DBox <A,B> {
        private A a;
        private B b;

        public A getA() {
            return a;
        }

        public void setA(A a) {
            this.a = a;
        }

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }

        @Override
        public String toString() {
            return "DBox{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }