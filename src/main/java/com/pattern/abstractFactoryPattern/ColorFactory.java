package com.pattern.abstractFactoryPattern;

public class ColorFactory extends AbstractFactory{

	@Override
	Color getColor(String colorType) {
		if(colorType == null){
			return null;			
		}
		if(colorType.equalsIgnoreCase("Green")){
			return new Green();
			
		}else if(colorType.equalsIgnoreCase("Red")){
			return new Red();
			
		}else if(colorType.equalsIgnoreCase("Blue")){
			return new Blue();
		}
		
		return null;
	}

	@Override
	Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
