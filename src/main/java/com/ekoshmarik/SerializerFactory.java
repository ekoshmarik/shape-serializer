package com.ekoshmarik;

import com.ekoshmarik.json.handler.JsonSerializer;
import com.ekoshmarik.json.handler.JsonSerializerFactory;
import com.ekoshmarik.xml.handler.XmlSerializer;
import com.ekoshmarik.xml.handler.XmlSerializerFactory;

final class SerializerFactory {

  private SerializerFactory() {
  }

  static Serializer newXmlSerializer() {
    return new XmlSerializer(new XmlSerializerFactory());
  }

  static Serializer newJsonSerializer() {
    return new JsonSerializer(new JsonSerializerFactory());
  }
}
