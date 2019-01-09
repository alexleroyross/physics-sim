package physics;

public class Circle {
	
	// radius
	public float r;
	
	// position vector
	public Vec2 pos;
	
	public Circle()
	{
		r = 0;
		pos = new Vec2();
	}
	
	public Circle(int x, int y, int r)
	{
		this.r = r;
		pos = new Vec2(x, y);
	}
	
	public Circle(Vec2 v, int r)
	{
		this.r = r;
		this.pos = new Vec2(v);
	}
	
	public void set(Circle c)
	{
		this.pos.set(c.pos);
		this.r = c.r;
	}
}
