package core.concurrent;

import java.util.ArrayList;

public class streamTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 1000; i++) {
            list.add(i);
        }
        list.parallelStream().forEach(item -> {
            StringBuffer sb = new StringBuffer();
//            item
        });
    }

}
