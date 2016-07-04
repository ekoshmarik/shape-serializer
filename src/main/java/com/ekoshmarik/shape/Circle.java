package com.ekoshmarik.shape;

public class Circle extends AbstractShape {

  private Point center;
  private int radius;

  public Circle(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }

  public Point getCenter() {
    return center;
  }

  public int getRadius() {
    return radius;
  }
}
