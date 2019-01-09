package physics;

public class Physics {

	
	public boolean AABBvsAABB(AABB a, AABB b)
	{
		if(a.max.x < b.min.x || a.min.x > b.max.x || a.max.y < b.min.y || a.min.y > b.max.x)
			return false;
		return true;
	}
	
	public boolean CirclevsCircle(Circle a, Circle b)
	{
		float r = a.r + b.r;
		float dx = (a.pos.x + b.pos.x) * (a.pos.x + b.pos.x);
		float dy = (a.pos.y + b.pos.y) * (a.pos.y + b.pos.y);
		r *= r;
		return (r < dx + dy);
	}
}
