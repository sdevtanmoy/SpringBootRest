package com.java.professional;

 class Program40 {

}

class Frame extends Canvas implements Drawable{
	public void resize() {
		
	}
}

class Paper extends Canvas{

	protected void draw(int draw) {
		
	}
}

abstract class Board extends Canvas{}

class Canvas implements Drawable{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
interface Drawable{
	public abstract void draw();
}