/**
 * Created by momo
 * Time: 14-3-20 上午11:11
 */
package me.momotime.java8.lambda;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈java8新特性之lambda〉<br>
 *
 * @author momo
 */
public class Test {
    interface MyLambda {
        //int square(int a);

        default int max(int a, int b) {
            System.out.println("default " + a);
            return a;
        }

    }

    static class MyLambdaImpl implements MyLambda {

    }

    interface IMap {
        Map<String, Object> newMap(Map m);
    }

    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();
        list.add("111");
        list.add("22");
        list.forEach(s -> System.out.println(s));
        list.forEach(Test::methodRef);

        File dir = new File("/an/dir/");
        File[] dirs = dir.listFiles((File f) -> {
            System.out.println("Log:...");
            return f.isDirectory();
        }
        );

        /*MyLambda addition = (a, b) -> {
            if (a > b) {
                return a;
            } else {
                return b;
            }
        };
        MyLambda refMethod =  Test::pp(1, 2);
        System.out.println(addition.max(20, 30));*/
        //(new MyLambdaImpl()).max(1, 2);
        MyLambda myLambdaImpl = new MyLambdaImpl();
        myLambdaImpl.max(2, 3);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ha", "111111");
        IMap iMap = (Map m) -> {
            System.out.println(m);
            return m;
        };
        iMap.newMap(map);
    }

    static void methodRef(Object o) {
        System.out.println("ref " + o);
    }

    static int pp(int a, int b) {
        return 0;
    }
}
