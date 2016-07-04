package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class JsonSerializer<T extends Shape> implements Serializer<T> {

  private final JsonSerializerFactory factory;

  public JsonSerializer(JsonSerializerFactory factory) {
    this.factory = factory;
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    Serializer serializer = factory.getSerializer(type);
    serializer.serialize(shape, os);
  }
}

