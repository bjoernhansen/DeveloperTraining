package training.algorithms.acceleration;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;


public class Ball
{	
	private static final float DELTA_T = 0.05f;
		
	
	Point2D pos, speed, a;	
	Ellipse2D shape = new Ellipse2D.Float();
	
	
	Ball()
	{
		this.reset();
	}
	
	
	void reset()
	{
		this.pos = new Point2D.Float(100, 100);
		this.speed = new Point2D.Float(0, 0);
		this.a = new Point2D.Float(0, 0); 
	}
	
	
	void update()
	{
		this.speed.setLocation(	this.speed.getX() + DELTA_T * this.a.getX(), 
								this.speed.getY() + DELTA_T * this.a.getY());
		
		this.pos.setLocation(	this.pos.getX() + DELTA_T * this.speed.getX(), 
								this.pos.getY() + DELTA_T * this.speed.getY());
		
		if(this.pos.getX() > Simulation.DIM.getHeight() || this.pos.getX() < 0)
		{
			this.a.setLocation(-this.a.getX(), this.a.getY());
			this.speed.setLocation(-this.speed.getX(), this.speed.getY());
		}
		if(this.pos.getY() > Simulation.DIM.getHeight() || this.pos.getY() < 0)
		{
			this.a.setLocation(this.a.getX(), -this.a.getY());
			this.speed.setLocation(this.speed.getX(), -this.speed.getY());
		}
		this.shape.setFrame(this.pos.getX() - 10, this.pos.getY() - 10, 20, 20);
	}
	
	
	void paint(Graphics2D g2d)
	{
		g2d.setColor(Color.red);
		g2d.fill(this.shape);
	}
	
	
}
