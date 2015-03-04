package com.laricafood.bean;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public enum UserType {

    PROPRETARIO(1), CLIENTE(2);

    private int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

