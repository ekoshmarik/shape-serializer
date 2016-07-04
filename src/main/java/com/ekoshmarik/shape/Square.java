package com.ekoshmarik.shape;

public class Square extends AbstractShape {

  private Point a;
  private int side;

  public Square(Point a, int side) {
    this.a = a;
    this.side = side;
  }

  public Point getA() {
    return a;
  }

  public int getSide() {
    return side;
  }
}
