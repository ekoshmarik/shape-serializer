package com.ekoshmarik.json.handler;

import com.ekoshmarik.Serializer;
import ua.codegym.serializer.shape.*;

import java.util.HashMap;
import java.util.Map;

public class JsonSerializerFactory { // it creates a specific type of serializer or get it from cache

  private Map<String, Serializer> serializers = new HashMap<>();

  public JsonSerializerFactory() {
    serializers.put(Point.class.getCanonicalName(), new PointJsonSerializer());
    serializers.put(Triangle.class.getCanonicalName(), new TriangleJsonSerializer());
    serializers.put(Circle.class.getCanonicalName(), new CircleJsonSerializer());
    serializers.put(Square.class.getCanonicalName(), new SquareJsonSerializer());
    serializers.put(Group.class.getCanonicalName(), new GroupJsonSerializer(this));
  }

  public Serializer getSerializer(String type) {
    return serializers.get(type);
  }
}
