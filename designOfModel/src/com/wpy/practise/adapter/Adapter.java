package com.wpy.practise.adapter;

public class Adapter extends Target{
	private Adaptee adaptee  = new Adaptee();
	
	@Override
	public void Request() {
		// TODO Auto-generated method stub
		adaptee.specificRequest();
	}
}
