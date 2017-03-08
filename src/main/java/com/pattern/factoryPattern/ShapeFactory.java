package com.pattern.factoryPattern;

/**
 * Factory Class to Generate the object of concrete class based on the given
 * information
 * 
 * @author webwerks
 *
 */
public class ShapeFactory {
	//use shape method to get the object of type shape
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("Circle")){
			return new Circle();
			
		}else if(shapeType.equalsIgnoreCase("Rectangle")){
			return new Rectangle();
			
		}else if(shapeType.equalsIgnoreCase("Square")){
			return new Square();
		}
		
		return null;
	}
}
