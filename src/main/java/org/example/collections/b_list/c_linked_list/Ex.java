package org.example.collections.b_list.c_linked_list;

import java.util.LinkedList;

public class Ex {
    public static void main(String[] args) {

        LinkedList<String> printQueue = new LinkedList<>();

        printQueue.add("report.pdf");
        printQueue.add("invoice.pdf");
        printQueue.add("contract.pdf");

        printQueue.addFirst("URGENT-payslip.pdf");
        printQueue.addLast("newsletter.pdf");
        System.out.println("print queue = " + printQueue);

        System.out.println("next to print  = " + printQueue.getFirst());
        System.out.println("last in queue  = " + printQueue.getLast());

        printQueue.removeFirst();
        printQueue.removeLast();
        System.out.println("after printing first + cancelling last = " + printQueue);

        printQueue.push("HOTFIX-banner.pdf");
        System.out.println("after pushing hotfix = " + printQueue);
        System.out.println("pop (handle next)    = " + printQueue.pop());
        System.out.println("after pop            = " + printQueue);
    }
}
