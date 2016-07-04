package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Circle;
import com.ekoshmarik.shape.Shape;
import com.ekoshmarik.shape.Point;

import java.io.IOException;
import java.io.OutputStream;

class CircleJsonSerializer<T extends Shape> implements Serializer<Circle> {

  @Override
  public void serialize(Circle circle, OutputStream os) throws IOException {
    Point center = circle.getCenter();
    int radius = circle.getRadius();
    String out = String.format("{\"shapeName\":\"circle\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"radius\":2]}", center.getX(), center.getY(), radius);
    os.write(out.getBytes());
  }
}
