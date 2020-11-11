package com.gildedrose.exception;

public class ObjectIsNotAnInstanceOfStoreItem extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ObjectIsNotAnInstanceOfStoreItem(String errorMessage) {
        super(errorMessage);
    }
    
}
