package org.example.rpg.marker;

import org.example.rpg.enums.Element;
import org.example.rpg.enums.Rarity;

import java.util.List;

public class Ex {
    public static void main(String[] args) {
        // Cream diferite tipuri de item-uri
        Weapon sword = new Weapon("Excalibur", Rarity.LEGENDARY, 150, Element.LIGHTNING);
        Potion healthPotion = new Potion("Health Potion", Rarity.COMMON, 50);
        QuestItem ring = new QuestItem("Ring of Power", Rarity.EPIC, "Destroy the Ring");

        List<GameItem> inventory = List.of(sword, healthPotion, ring);

        // === MARKER INTERFACE: verificam cu instanceof ===
        System.out.println("=== Marker Interfaces: verificare cu instanceof ===");
        for (GameItem item : inventory) {
            System.out.println(item);
            System.out.println("  Tradeable?   " + (item instanceof Tradeable));
            System.out.println("  Enchantable? " + (item instanceof Enchantable));
            System.out.println("  Cloneable?   " + (item instanceof Cloneable));
            System.out.println();
        }

        // === CLONEABLE: duplicam o arma ===
        System.out.println("=== Cloneable: clonare weapon ===");
        Weapon clonedSword = sword.clone();
        System.out.println("Original:  " + sword + " | hashCode=" + System.identityHashCode(sword));
        System.out.println("Clona:     " + clonedSword + " | hashCode=" + System.identityHashCode(clonedSword));
        System.out.println("Sunt acelasi obiect? " + (sword == clonedSword));
        System.out.println("Sunt egale (equals)? " + sword.equals(clonedSword));

        // === Simulam un "magazin" care accepta doar Tradeable ===
        System.out.println("\n=== Magazin: doar item-uri Tradeable ===");
        for (GameItem item : inventory) {
            if (item instanceof Tradeable) {
                System.out.println("  ACCEPT la vanzare: " + item);
            } else {
                System.out.println("  REFUZ - nu este tradeable: " + item);
            }
        }

        // === Ce se intampla daca incercam clone pe un obiect non-Cloneable? ===
        System.out.println("\n=== CloneNotSupportedException demo ===");
        try {
            // QuestItem NU implementeaza Cloneable
            // Object.clone() va arunca CloneNotSupportedException
            QuestItem clonedRing = (QuestItem) ring.getClass()
                    .getMethod("clone")
                    .invoke(ring);
        } catch (Exception e) {
            System.out.println("Nu putem clona QuestItem: " + e.getCause().getClass().getSimpleName());
            System.out.println("Motivul: QuestItem nu implementeaza Cloneable!");
        }
    }
}
