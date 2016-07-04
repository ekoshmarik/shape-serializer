package com.ekoshmarik;

import org.junit.Test;
import ua.codegym.serializer.shape.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class XmlSerializerTest {

  @Test
  public void verifyThatSinglePointIsWritingCorrectlyToXml() throws IOException {
    //given
    Shape shape = new Point(0, 1);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    //when
    xml.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("<point><x>0</x><y>1</y></point>", output);
  }

  @Test
  public void verifyThatSingleTriangleIsWritingCorrectlyToXml() throws IOException {
    //given
    Shape shape = new Triangle(new Point(0, 1), new Point(2, 3), new Point(4, 5));
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    //when
    xml.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("<triangle><point id=\"a\"><x>0</x><y>1</y></point><point id=\"b\"><x>2</x><y>3</y></point><point id=\"c\"><x>4</x><y>5</y></point></triangle>", output);
  }

  @Test
  public void verifyThatSingleCircleIsWritingCorrectlyToXml() throws IOException {
    //given
    Shape shape = new Circle(new Point(0, 1), 2);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    //when
    xml.serialize(shape, out);

    //then
    String output = new String(out.toByteArray());
    assertEquals("<circle><point><x>0</x><y>1</y></point><radius>2</radius></circle>", output);
  }

  @Test
  public void verifyThatSingleSquareIsWritingCorrectlyToXml() throws IOException {
    // given  
    Shape shape = new Square(new Point(0, 1),2);
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();
    
    // when
    xml.serialize(shape, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<square><point><x>0</x><y>1</y></point><side>2</side></square>", output);
  }

  @Test
  public void verifyThatGroupedShapeWritingCorrectlyToXml() throws IOException {
    // given
    Group group = new Group();
    group.add(new Square(new Point(0, 1), 2));
    group.add(new Circle(new Point(0, 1), 2));

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    Serializer xml = SerializerFactory.newXmlSerializer();

    // when
    xml.serialize(group, out);

    // then
    String output = new String(out.toByteArray());
    assertEquals("<group><square><point><x>0</x><y>1</y></point><side>2</side></square><circle><point><x>0</x><y>1</y></point><radius>2</radius></circle></group>", output);
  }
}
