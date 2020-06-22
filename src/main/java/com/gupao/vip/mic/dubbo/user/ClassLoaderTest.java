package com.gupao.vip.mic.dubbo.user;

public class ClassLoaderTest {

    private int f = 40;

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public static int f1(int x) {
        x = 20;
        System.out.println(x);
        return x;
    }

    public void f2(ClassLoaderTest test, int index) {
        test.setF(index);
    }

    public String f3(String inStr) {
        inStr = "321";
        return inStr;
    }

    public static void main(String[] args) {
        
    }

}
