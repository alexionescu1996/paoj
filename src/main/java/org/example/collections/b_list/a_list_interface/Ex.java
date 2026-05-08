package org.example.collections.b_list.a_list_interface;

import java.util.ArrayList;
import java.util.List;

public class Ex {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        System.out.println("get(0)        = " + list.get(0));
        System.out.println("indexOf('b')  = " + list.indexOf("b"));

        list.set(1, "B");
        System.out.println("after set(1)  = " + list);

        list.add(1, "x");
        System.out.println("after add(1)  = " + list);

        list.remove(0);
        System.out.println("after remove(0) = " + list);

        List<String> sub = list.subList(0, 2);
        System.out.println("subList(0,2)  = " + sub);
    }
}
