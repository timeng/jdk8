/**
 * Copyright (c) 2014, http://momotime.me. All rights reserved.
 * @author momo.
 * @Time: 14-3-29 下午10:22
 */
package me.momotime.java8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型测试
 * @author momo.
 */
public class GgenericsTest {

    public static  void main(String args[]){
        String[] strs = new String[] {"1", "2"};
        List l = Arrays.asList(strs);
        //jdk 1.7之前
        List<String> list = new ArrayList<String>();
        // jdk1.7时
        List<String> list1 = new ArrayList<>();
        list1.addAll(Arrays.asList());

        // jdk1.8中
        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.addAll(Arrays.asList());

    }
}
