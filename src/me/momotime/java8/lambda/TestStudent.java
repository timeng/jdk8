/**
 *
 * @author momo
 * Time: 14-3-20 下午5:43
 */
package me.momotime.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈测试类〉<br>
 *
 * @author momo
 */
public class TestStudent {

    /**
     * 一点都不华丽的分割线
     */
    static final String DIVIDING_LINE = "============================================================";

    public static void main(String args[]) {
        Student s1 = new Student("aa", 12, "male");
        Student s2 = new Student("bb", 18, "female");
        Student s3 = new Student("cc", -2, "female");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        // 传统方式
        printStudent(list, new StudentFilter() {
            @Override
            public boolean test(Student s) {
                //如果年龄大于15返回true
                return s.getAge() > 15;
            }
        });

        //使用lamda表达式
        System.out.println(DIVIDING_LINE);
        System.out.println("使用lambda表达式");
        printStudent(list, (Student s) -> s.getAge() > 15);

        // 多行代码需要使用花括号
        System.out.println(DIVIDING_LINE);
        printStudent(list, (Student s) -> {
            if (s.getAge() > 15) {
                return true;
            } else {
                System.err.println(s.getName() + "不满足条件");
                return false;
            }
        });

        //使用方法引用
        System.out.println(DIVIDING_LINE);
        System.out.println("使用方法引用");
        printStudent(list, StudentFilterImpl::check);

        //使用接口默认方法
        System.out.println(DIVIDING_LINE);
        System.out.println("使用接口默认方法");
        StudentFilter filter = new StudentFilterImpl2();
        printStudent(list, filter::test2);
    }

    /**
     * 打印输出满足条件的学生
     *
     * @param list   list<学生>
     * @param filter 筛选
     */
    static void printStudent(List<Student> list, StudentFilter filter) {
        for (Student student : list) {
            if (filter.test(student)) {
                System.out.println("符合条件的同学是: " + student.getName());
            }
        }
    }
}
