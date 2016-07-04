package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import com.ekoshmarik.shape.Group;
import com.ekoshmarik.shape.Shape;

import java.io.IOException;
import java.io.OutputStream;

class GroupJsonSerializer implements Serializer {

  private final JsonSerializerFactory factory;

  GroupJsonSerializer(JsonSerializerFactory factory) {
    this.factory = factory;
  }

  @Override
  public void serialize(Shape shape, OutputStream os) throws IOException {
    Group group = (Group) shape;
    int amountOfShapes = group.getShapes().size();
    int counter = 0;
    os.write("{\"group\": [".getBytes());
    for (Shape innerShape : group.getShapes()) {
      counter++;
      Serializer innerSerializer = factory.getSerializer(innerShape.getType());
      innerSerializer.serialize(innerShape, os);
      if (counter < amountOfShapes) {
        os.write(", ".getBytes());
      }
    }
    os.write("]}".getBytes());
  }
}
