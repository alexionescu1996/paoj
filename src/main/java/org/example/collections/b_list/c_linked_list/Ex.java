package org.example.collections.b_list.c_linked_list;

import java.util.LinkedList;

public class Ex {
    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("first");
        queue.add("second");
        queue.add("third");

        queue.addFirst("zero");
        queue.addLast("fourth");
        System.out.println("queue = " + queue);

        System.out.println("getFirst = " + queue.getFirst());
        System.out.println("getLast  = " + queue.getLast());

        queue.removeFirst();
        queue.removeLast();
        System.out.println("after removeFirst/removeLast = " + queue);

        queue.push("pushed");
        System.out.println("after push  = " + queue);
        System.out.println("pop         = " + queue.pop());
        System.out.println("after pop   = " + queue);
    }
}
