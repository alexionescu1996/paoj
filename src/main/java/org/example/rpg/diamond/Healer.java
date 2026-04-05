package org.example.rpg.diamond;

/**
 * Interfata Healer - are ACEEASI default method prepare() ca si Warrior!
 * Aceasta creeaza PROBLEMA ROMBULUI (Diamond Problem).
 */
public interface Healer {

    String getName();

    default String prepare() {
        return getName() + " pregateste potiuni si rugaciuni de vindecare.";
    }

    default String heal() {
        return getName() + " vindeca aliatul!";
    }
}
