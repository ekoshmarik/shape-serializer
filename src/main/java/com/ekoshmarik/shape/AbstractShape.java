package com.ekoshmarik.shape;

public class AbstractShape implements Shape {
    public String getType() {
        return this.getClass().getCanonicalName();
    }
}
