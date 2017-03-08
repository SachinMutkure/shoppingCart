package com.pattern.factoryPattern;

public class FactoryPatternDemo {

	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();		
		
		// get an object of circle and call its draw method
		Shape shape1 = shapeFactory.getShape("Circle");
		shape1.draw();
		
		// get an object of Rectangle and call its draw method
		Shape shape2 = shapeFactory.getShape("Rectangle");
		shape2.draw();
		
		//get an object of Square and call its draw method
		Shape shape3 = shapeFactory.getShape("Square");
		shape3.draw();
	}
}
