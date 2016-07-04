package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import ua.codegym.serializer.shape.*;

import java.io.IOException;
import java.io.OutputStream;

class GroupXmlSerializer<T extends Shape> implements Serializer<Group> {

  private final XmlSerializerFactory factory;

  GroupXmlSerializer(XmlSerializerFactory factory) {
    this.factory = factory;
  }

  @Override
  public void serialize(Group group, OutputStream os) throws IOException {
    os.write("<group>".getBytes());
    for (Shape innerShape : group.getShapes()) {
      Serializer innerSerializer = factory.getSerializer(innerShape.getType());
      innerSerializer.serialize(innerShape, os);
    }
    os.write("</group>".getBytes());
  }


}
