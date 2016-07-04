package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Point;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Triangle;

import java.io.IOException;
import java.io.OutputStream;

class TriangleJsonSerializer<T extends Shape> implements Serializer<Triangle> {

  @Override
  public void serialize(Triangle triangle, OutputStream os) throws IOException {
    Point a = triangle.getA();
    Point b = triangle.getB();
    Point c = triangle.getC();
    String out = String.format("{\"shapeName\":\"triangle\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, {\"shapeName\":\"point\", \"properties\":[\"x\":2, \"y\":3]}, {\"shapeName\":\"point\", \"properties\":[\"x\":4, \"y\":5]}]}", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(),c.getY());
    os.write(out.getBytes());
  }
}
