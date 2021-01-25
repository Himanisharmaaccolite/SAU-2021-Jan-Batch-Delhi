package com.spring.au;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Triangle {

	private int width;
	private int height;
	private String type;

	@Autowired
	@Qualifier("PointA")
	private Point pointA;

	@Autowired
	@Qualifier("PointB")
	private Point pointB;

	@Autowired
	@Qualifier("PointC")
	private Point pointC;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println(getType()+getPointA().getX()+","+getPointA().getY()+
				+ getPointB().getX()+","+getPointB().getY()+
				+ getPointC().getX()+","+getPointC().getY()+ getWidth()+ getHeight());
	}

	public Triangle(Point pointA, Point pointB, Point pointC, int width, int height, String type) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
		this.width = width;
		this.height = height;
		this.type = type;
	}

	public Triangle(String type, int width, int height) {
		super();
		this.type = type;
		this.width = width;
		this.height = height;
	}

}