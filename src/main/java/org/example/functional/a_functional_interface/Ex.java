package org.example.functional.a_functional_interface;

public class Ex {
    public static void main(String[] args) {

        Discount blackFriday = new Discount() {
            @Override
            public double apply(double price) {
                return price * 0.5;
            }
        };

        Discount studentDiscount = price -> price * 0.85;
        Discount loyaltyDiscount = price -> price - 10;

        double cartTotal = 120.0;
        System.out.println("original         = " + cartTotal);
        System.out.println("black friday     = " + blackFriday.apply(cartTotal));
        System.out.println("student discount = " + studentDiscount.apply(cartTotal));
        System.out.println("loyalty discount = " + loyaltyDiscount.apply(cartTotal));
    }
}
