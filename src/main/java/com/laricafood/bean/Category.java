package com.laricafood.bean;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public enum Category {

    HAMBURGUER(1), CACHORRO_QUENTE(2), SANDUICHE_NATURAL(3), BATATA_FRITA(4), TAPIOCA(5), CALDO(6), SORVETE(7);

    private int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
