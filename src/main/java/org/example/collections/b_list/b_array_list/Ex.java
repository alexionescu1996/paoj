package org.example.collections.b_list.b_array_list;

import java.util.ArrayList;

public class Ex {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            numbers.add(i * 10);
        }

        System.out.println("numbers = " + numbers);
        System.out.println("get(2)  = " + numbers.get(2));

        numbers.add(0, 999);
        System.out.println("after insert at head = " + numbers);

        numbers.remove(Integer.valueOf(30));
        System.out.println("after remove value 30 = " + numbers);

        System.out.println("contains 50 = " + numbers.contains(50));
        System.out.println("size        = " + numbers.size());
    }
}
