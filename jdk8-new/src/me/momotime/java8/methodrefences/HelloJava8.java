package me.momotime.java8.methodrefences;

/**
 * Copyright (c) 2009-2014,timengsz@gmail.com. All rights reserved.
 *
 * @author momo.
 *         Time:  14-3-25 下午11:30
 */
public class HelloJava8 implements  HelloJava{
    @Override
    public void sayHello(){
        System.out.println("hello method");
    }

    // static method
    public static void sayMethod(){
        System.out.println("I'm a static method");
    }
}
