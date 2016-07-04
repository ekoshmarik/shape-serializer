package com.ekoshmarik.shape;

public class Triangle extends AbstractShape {

  private Point a;
  private Point b;
  private Point c;

  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Point getA() {
    return a;
  }

  public Point getB() {
    return b;
  }

  public Point getC() {
    return c;
  }
}
