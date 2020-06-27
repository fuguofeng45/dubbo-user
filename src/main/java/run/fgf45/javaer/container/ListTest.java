package run.fgf45.javaer.container;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 容器list 线程安全 线程不安全
 * @author fuguofeng
 */
public class ListTest {

    public static void main(String[] args) {
        //listNotSafe();
    }

    /**
     * 证明arraylist线程不安全
     */
    private static void listNotSafe() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

}
