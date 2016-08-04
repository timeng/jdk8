package me.momotime.java8.methodrefences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author momo.
 */
public class Test {
    public static void main(String args[]) {
        HelloJava helloJava8 = new HelloJava8();
        testMethod(helloJava8::sayHello);

        testMethod(HelloJava8::sayMethod);

        testMethod(HelloJavaNew::new);

        String a = "aa";
        String b = "bb";
        List<String> list = new ArrayList<String>();
        list.add(a);
        list.add(b);
        list.forEach(System.out::println);
    }


    public static void testMethod(HelloJava helloJava8) {
        helloJava8.sayHello();
    }
}
