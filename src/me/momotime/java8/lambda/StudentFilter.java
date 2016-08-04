package me.momotime.java8.lambda;

/**
 * 检查Student是否符合规则
 * @
 * @author momo
 *         Time: 14-3-20 下午5:33
 */
@FunctionalInterface
public interface StudentFilter {
    /**
     * 检查是否符合规则
     *
     * @param s 学生
     * @return 满足条件返回true
     */
    boolean test(Student s);

    /**
     * 接口默认方法
     *
     * @param s 学生
     * @return 年龄大于0返回true
     */
    default boolean test2(Student s) {
        return s.getAge() > 0;
    }
}
