package com.compulsory;

public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(Exception exc) {
        super("Invalid catalog file.", exc);
    }
}
