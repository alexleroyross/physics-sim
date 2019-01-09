package physics;

public class AABB {
	
	// coordinates for minimum point
	Vec2 min;
	
	// coordinates for maximum point
	Vec2 max;
	
	public AABB()
	{
		min = new Vec2();
		max = new Vec2();
	}
	
	public AABB(Vec2 min, Vec2 max)
	{
		this.min = new Vec2(min);
		this.max = new Vec2(max);
	}
	
	public AABB(int x, int y, int w, int h)
	{
		this.min = new Vec2(x, y);
		this.max = new Vec2(x + w, y + h);
	}
	
	public void set(AABB a)
	{
		this.min.set(a.min);
		this.max.set(a.max);
	}
}
