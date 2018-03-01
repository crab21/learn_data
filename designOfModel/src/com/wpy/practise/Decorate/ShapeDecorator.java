package com.wpy.practise.Decorate;

public class ShapeDecorator implements Shape {

	protected Shape decorateShape;
	public ShapeDecorator(Shape decorateShape) {
		this.decorateShape = decorateShape;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		decorateShape.draw();
	}

}
