package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Point;

import java.io.IOException;
import java.io.OutputStream;

class PointXmlSerializer<T extends Shape> implements Serializer<Point> {

  @Override
  public void serialize(Point point, OutputStream os) throws IOException {
    int x = point.getX();
    int y = point.getY();
    String out = String.format("<point><x>%d</x><y>%d</y></point>", x, y);
    os.write(out.getBytes());
  }
}
