
package me.momotime.java8.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * 并行计算测试
 *
 * @author TM
 * @since 2016/8/4 000419:07
 */
public class TestPerformanceCollection {
    public static void main(String args[]) {
        List list = new ArrayList<Object>();
        for (int i1 = 0; i1 < 1000000; i1++) {
            list.add(i1);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            list.stream().filter(e -> e != null).forEach(e -> e.toString());
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            list.parallelStream().filter(e -> e != null).forEach(e -> e.toString());
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
