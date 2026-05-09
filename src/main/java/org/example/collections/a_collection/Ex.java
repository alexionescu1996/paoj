package org.example.collections.a_collection;

import java.util.ArrayList;
import java.util.Collection;

public class Ex {
    public static void main(String[] args) {

        // Collection — root interface for List, Set, Queue (single-element ops)

        Collection<String> cart = new ArrayList<>();

        cart.add("Headphones");
        cart.add("Mug");
        cart.add("Keyboard");

        System.out.println("size              = " + cart.size());
        System.out.println("isEmpty           = " + cart.isEmpty());
        System.out.println("contains Keyboard = " + cart.contains("Keyboard"));

        cart.remove("Mug");
        System.out.println("after remove(Mug) = " + cart);

        Collection<String> wishlist = new ArrayList<>();
        wishlist.add("Speaker");
        wishlist.add("USB-C Hub");

        cart.addAll(wishlist);
        System.out.println("after addAll(wishlist) = " + cart);

        cart.clear();
        System.out.println("after checkout / clear = " + cart + ", size=" + cart.size());
    }
}
