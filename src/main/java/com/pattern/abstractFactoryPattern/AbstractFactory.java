package com.pattern.abstractFactoryPattern;

public abstract class AbstractFactory {

	abstract Color getColor(String colorType);
	abstract Shape getShape(String shapeType);
}
