package org.example;

public class AA extends Object {

    private String name;

    public AA(String name) {
        this.name = name;
    }

    public void printThis(Object obj) {
        System.out.println("obj = " + obj);
        System.out.println("(A)obj = " + (AA) obj);
        System.out.println("this.name = " + this.name);
        System.out.println("((A)obj)name = " + ((AA) obj).name);
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equals(((AA) o).name);
    }
}
