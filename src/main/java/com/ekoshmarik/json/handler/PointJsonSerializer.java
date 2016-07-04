package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Point;
import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

class PointJsonSerializer<T extends Shape> implements Serializer<Point> {
  @Override
  public void serialize(Point point, OutputStream os) throws IOException {
    int x = point.getX();
    int y = point.getY();
    String out = String.format("{\"shapeName\":\"point\", \"properties\":[\"x\":%d, \"y\":%d]}", x, y);
    os.write(out.getBytes());
  }
}
