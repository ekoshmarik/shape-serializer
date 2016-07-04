package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

public class XmlSerializer implements Serializer {

  private final XmlSerializerFactory factory;

  public XmlSerializer(XmlSerializerFactory factory) {
    this.factory = factory;
  }

  public void serialize(Shape shape, OutputStream os) throws IOException {
    String type = shape.getType();
    Serializer serializer = factory.getSerializer(type);
    serializer.serialize(shape, os);
  }
}