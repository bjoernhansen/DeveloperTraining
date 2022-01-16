package com.javafx.gui.canvas;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class ColorPoint extends Point2D {
	
	private Color c;

	public ColorPoint(int x, int y, Color c) {
		super(x, y);
		this.setC(c);
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "ColorPoint [c=" + c + ", getX()=" + getX() + ", getY()=" + getY() + "]";
	}
	
	

}
