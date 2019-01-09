package physics;

public class Vec2 {
	public int x;
	public int y;
	
	public Vec2()
	{
		x = 0;
		y = 0;
	}
	
	public Vec2(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vec2(Vec2 v)
	{
		this.x = v.x;
		this.y = v.y;
	}
	
	public void set(Vec2 v)
	{
		this.x = v.x;
		this.y = v.y;
	}
}
