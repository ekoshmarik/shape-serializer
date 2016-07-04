package com.ekoshmarik;

import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public interface Serializer<T extends Shape> {
    void serialize(T shape, OutputStream os) throws IOException;
}