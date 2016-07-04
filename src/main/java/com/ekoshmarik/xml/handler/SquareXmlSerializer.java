package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Square;
import com.ekoshmarik.shape.Point;

import java.io.IOException;
import java.io.OutputStream;

class SquareXmlSerializer<T extends Shape> implements Serializer<Square> {

  @Override
  public void serialize(Square square, OutputStream os) throws IOException {
    Point a = square.getA();
    int side = square.getSide();
    String out = String.format("<square><point><x>%d</x><y>%d</y></point><side>%d</side></square>", a.getX(), a.getY(), side);
    os.write(out.getBytes());
  }
}