package org.example.collections.b_list.b_array_list;

import java.util.ArrayList;

public class Ex {
    public static void main(String[] args) {

        ArrayList<Integer> dailyTemps = new ArrayList<>();

        int[] readings = {12, 14, 11, 9, 13, 16, 15};
        for (int t : readings) {
            dailyTemps.add(t);
        }

        System.out.println("week temps      = " + dailyTemps);
        System.out.println("wednesday (idx 2) = " + dailyTemps.get(2) + "°C");

        dailyTemps.add(0, 10);
        System.out.println("after prepend prior-sunday = " + dailyTemps);

        dailyTemps.remove(Integer.valueOf(11));
        System.out.println("after dropping reading 11°C = " + dailyTemps);

        System.out.println("contains 16°C  = " + dailyTemps.contains(16));
        System.out.println("number of days = " + dailyTemps.size());
    }
}
