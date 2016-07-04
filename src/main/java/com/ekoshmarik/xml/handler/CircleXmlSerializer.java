package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Circle;
import com.ekoshmarik.shape.Point;
import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

class CircleXmlSerializer<T extends Shape> implements Serializer<Circle> {

  @Override
  public void serialize(Circle circle, OutputStream os) throws IOException {
    Point center = circle.getCenter();
    int radius = circle.getRadius();
    String out = String.format("<circle><point><x>%d</x><y>%d</y></point><radius>%d</radius></circle>", center.getX(), center.getY(), radius);
    os.write(out.getBytes());
  }
}
