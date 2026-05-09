package org.example.functional.c_method_reference;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Ex {

    public static String slogan(String brand) {
        return brand.toUpperCase() + " — buy now!";
    }

    public static void main(String[] args) {

        // method reference — shorthand for a lambda that just calls one method
        // 4 forms:
        //   ClassName::staticMethod      e.g. Integer::parseInt
        //   instance::method             e.g. prefix::concat       (bound)
        //   ClassName::instanceMethod    e.g. String::length       (unbound)
        //   ClassName::new               e.g. StringBuilder::new   (constructor)

        Function<String, Integer> parseLambda = s -> Integer.parseInt(s);
        Function<String, Integer> parseRef = Integer::parseInt;
        System.out.println("static ref Integer::parseInt('1042') = " + parseRef.apply("1042"));
        System.out.println("equivalent lambda result            = " + parseLambda.apply("1042"));

        Function<String, String> ad = Ex::slogan;
        System.out.println("static ref Ex::slogan('acme') = " + ad.apply("acme"));

        String orderPrefix = "ORD-";
        Function<String, String> orderId = orderPrefix::concat;
        System.out.println("bound ref prefix::concat('1042') = " + orderId.apply("1042"));

        Function<String, Integer> length = String::length;
        BiFunction<String, String, Boolean> startsWith = String::startsWith;
        System.out.println("unbound ref String::length('Headphones')   = " + length.apply("Headphones"));
        System.out.println("unbound ref String::startsWith('iPhone',i) = " + startsWith.apply("iPhone", "i"));

        Supplier<StringBuilder> receiptFactory = StringBuilder::new;
        StringBuilder receipt = receiptFactory.get();
        receipt.append("=== receipt #1042 ===");
        System.out.println(receipt);

        List<String> orders = List.of("ORD-1001", "ORD-1002", "ORD-1003");
        orders.forEach(System.out::println);
    }
}
