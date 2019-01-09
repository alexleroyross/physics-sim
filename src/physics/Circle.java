package physics;

public class Circle {
	public float radius;
	public Vec2 pos;
	
	public Circle()
	{
		radius = 0;
		pos.x = 0;
		pos.y = 0;
	}
	
	public Circle(int x, int y, int r)
	{
		this.radius = r;
		this.pos.x = x;
		this.pos.y = y;
	}
	
	public Circle(Vec2 v, int r)
	{
		this.radius = r;
		this.pos.set(v);
	}
}
