package com.ekoshmarik;

import org.junit.Test;
import ua.codegym.serializer.shape.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class JsonSerializerTest {

  @Test
  public void verifyThatSinglePointIsWritingCorrectlyToJson() throws IOException {
    //given
    Shape shape = new Point(0, 1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}", output);
  }

  @Test
  public void verifyThatSingleTriangleIsWritingCorrectlyToJson() throws IOException {
    //given
    Shape shape = new Triangle(new Point(0, 1), new Point(2, 3), new Point(4, 5));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"shapeName\":\"triangle\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, {\"shapeName\":\"point\", \"properties\":[\"x\":2, \"y\":3]}, {\"shapeName\":\"point\", \"properties\":[\"x\":4, \"y\":5]}]}", output);
  }

  @Test
  public void verifyThatSingleCircleIsWritingCorrectlyToJson() throws IOException {
    //given
    Shape shape = new Circle(new Point(0, 1), 2);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"shapeName\":\"circle\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"radius\":2]}", output);
  }

  @Test
  public void verifyThatSingleSquareIsWritingCorrectlyToJson() throws IOException {
    //given
    Shape shape = new Square(new Point(0, 1),2);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"shapeName\":\"square\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"side\":2]}", output);
  }

  @Test
  public void verifyThatSingleGroupIsWritingCorrectlyToJson() throws IOException {
    //given
    Group group = new Group();
    group.add(new Square(new Point(0, 1), 2));
    group.add(new Circle(new Point(0, 1), 2));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer json = SerializerFactory.newJsonSerializer();

    //when
    json.serialize(group, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("{\"group\": [{\"shapeName\":\"square\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"side\":2]}, {\"shapeName\":\"circle\", \"properties\":[{\"shapeName\":\"point\", \"properties\":[\"x\":0, \"y\":1]}, \"radius\":2]}]}", output);
  }

}
