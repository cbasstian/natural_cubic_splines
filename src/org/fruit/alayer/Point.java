package org.fruit.alayer;

import org.fruit.Assert;
import java.io.Serializable;

public final class Point implements Serializable {

	private static final long serialVersionUID = -8319702986528318327L;
	private final double x, y;
		
	public static Point from(double x, double y){ return new Point(x, y); }
	
	private Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double x(){ return x; }
	public double y(){ return y; }

	public String toString(){ return "(" + x + ", " + y + ")"; }
	
	public boolean equals(Object o){
		if(this == o)
			return true;
		
		if(o instanceof Point){
			Point po = (Point) o;
			return x == po.x && y == po.y;
		}
		return false;
	}
	
	public int hashCode(){
		long ret = Double.doubleToLongBits(x);
		ret ^= Double.doubleToLongBits(y) * 31;
		return (((int) ret) ^ ((int) (ret >> 32)));
	}
}
