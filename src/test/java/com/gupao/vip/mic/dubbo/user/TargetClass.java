package com.gupao.vip.mic.dubbo.user;

public class TargetClass {

    private String value;

    public TargetClass(){

    }

    public TargetClass(String value){
        this.value = value;
    }

    private String privateMethod(String inStr){
        return "privateMethod ==> " + inStr;
    }

    public String publicMethod(String inStr){
        return "publicMethod ==> " + inStr;
    }

    @Override
    public String toString() {
        return "TargetClass{" +
                "value='" + value + '\'' +
                '}';
    }

}
