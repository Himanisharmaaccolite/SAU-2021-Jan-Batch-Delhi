package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Rectangle {

    public Rectangle() {
        super();
    }

    public Point getPointB() {
       return pointB;   }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Autowired
    @Qualifier("PointA")
    private Point pointA;

    @Autowired
    @Qualifier("PointB")
    private Point pointB;

    @Autowired
    @Qualifier("PointC")
    private Point pointC;

    @Autowired
    @Qualifier("PointD")
    private Point pointD;

    public void draw() {
        System.out.println(getPointA().getX()+","+getPointA().getY());
        System.out.println(getPointB().getX()+","+getPointB().getY());
        System.out.println(getPointC().getX()+","+getPointC().getY());
        System.out.println(getPointD().getX()+","+getPointD().getY());
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

}
