package com.wpy.practise.Decorate;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decorateShape) {
		super(decorateShape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		decorateShape.draw();
		setReadBorder(decorateShape);
	}
	
	public void setReadBorder(Shape decorateshape) {
		System.out.println("border color: red");
	}
}
