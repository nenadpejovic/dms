package com.silab.dms.Utils;

/**
 * Created by msav on 2/25/2017.
 */
public enum Constants {
    INITIAL_PASSWORD("abc123");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
