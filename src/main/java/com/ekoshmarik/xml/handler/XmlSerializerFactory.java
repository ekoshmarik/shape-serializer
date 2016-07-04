package com.ekoshmarik.xml.handler;

import com.ekoshmarik.Serializer;
import ua.codegym.serializer.shape.*;

import java.util.HashMap;
import java.util.Map;

public class XmlSerializerFactory { // it creates a specific type of serializer or get it from cache

  private Map<String, Serializer> serializers = new HashMap<>();

  public XmlSerializerFactory() {
    serializers.put(Point.class.getCanonicalName(), new PointXmlSerializer());
    serializers.put(Triangle.class.getCanonicalName(), new TriangleXmlSerializer());
    serializers.put(Circle.class.getCanonicalName(), new CircleXmlSerializer());
    serializers.put(Square.class.getCanonicalName(), new SquareXmlSerializer());
    serializers.put(Group.class.getCanonicalName(), new GroupXmlSerializer(this));
  }

  public Serializer getSerializer(String type) {
    return serializers.get(type);
  }
}
