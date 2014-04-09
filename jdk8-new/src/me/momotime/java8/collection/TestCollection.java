/**
 * Copyright (c) 2014, http://momotime.me. All rights reserved.
 * @author momo.
 * @Time: 14-4-6 下午8:58
 */
package me.momotime.java8.collection;

import me.momotime.java8.lambda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author momo.
 */
public class TestCollection {
    public static void main(String args[]) {
        Student s1 = new Student("aa", 12, "male");
        Student s2 = new Student("bb", 18, "female");
        Student s3 = new Student("cc", -2, "female");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        list.stream().
                filter(e -> e.getAge() > 0)
                .forEach(e -> System.out.println(e.getName()));
        //并行处理，能利用多核cpu的能力
        list.parallelStream()
                .filter(e -> e.getAge() > 15)
                .forEach(e -> System.out.println(e.getName()));

        System.out.println(list.parallelStream().filter(e -> e.getAge() > 15).collect(Collectors.toList()));

        list.stream().mapToInt(Student::getAge).average().getAsDouble();

        // 按性别分类
        Map<String, Integer> map = list.parallelStream().collect(
                Collectors.groupingBy(Student::getGender, Collectors.summingInt(p -> 1)));
        System.out.println(map);


        Map<String, List<String>> map2 = list.stream()
                .collect(Collectors.groupingBy(
                        Student::getGender,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(map2);


    }
}
