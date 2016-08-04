/**
 *
 * @author momo
 * Time: 14-3-20 下午7:18
 */
package me.momotime.java8.lambda;

/**
 * 〈〉<br>
 *
 * @author momo
 */
public class StudentFilterImpl {
    public static boolean check(Student s) {
        //如果年龄大于15返回true
        return  s.getAge() > 15;
    }
}
