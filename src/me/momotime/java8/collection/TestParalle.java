package me.momotime.java8.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Paralle API
 * <br>http://radar.oreilly.com/2015/02/java-8-streams-api-and-parallelism.html
 * @author TM
 * @since 2016/8/4 000419:38
 */
public class TestParalle {

    public static void main(String args[]) {
        List list = new ArrayList<Object>();
        for (int i1 = 0; i1 < 1000; i1++) {
            list.add(i1);
        }

        Predicate<Object> filteredPredicate = (Object t) -> (t != null);
        /**
         * filter API
         */
        List list1 = (List) list.stream().filter(filteredPredicate).collect(Collectors.toList());
    }
}
