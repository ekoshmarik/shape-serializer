package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Triangle;
import com.ekoshmarik.shape.Point;

import java.io.IOException;
import java.io.OutputStream;

class TriangleXmlSerializer<T extends Shape> implements Serializer<Triangle> {

  @Override
  public void serialize(Triangle triangle, OutputStream os) throws IOException {
    Point a = triangle.getA();
    Point b = triangle.getB();
    Point c = triangle.getC();
    String out = String.format("<triangle><point id=\"a\"><x>%d</x><y>%d</y></point><point id=\"b\"><x>%d</x><y>%d</y></point><point id=\"c\"><x>%d</x><y>%d</y></point></triangle>", a.getX(), a.getY(), b.getX(), b.getY(), c.getX(),c.getY());
    os.write(out.getBytes());
  }
}
