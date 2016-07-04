package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Square;
import com.ekoshmarik.shape.Point;

import java.io.IOException;
import java.io.OutputStream;

class SquareJsonSerializer<T extends Shape> implements Serializer<Square> {

  @Override
  public void serialize(Square square, OutputStream os) throws IOException {
    Point a = square.getA();
    int side = square.getSide();
    String out = String.format("{\"shapeName\":\"square\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"side\":2]}", a.getX(), a.getY(), side);
    os.write(out.getBytes());
  }
}
