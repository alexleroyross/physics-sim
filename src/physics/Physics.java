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

	public boolean CirclevsCircle(Manifold m)
	{
		
	}
	
	public void resolveCollision(RigidBody a, RigidBody b)
	{
		// relative velocity
		Vec2 rv = vSub(b.velocity, a.velocity);
		
		// is this how you do it??
		Vec2 normal = normalize(rv);
		
		// velocity along the normal
		float velAlongNorm = dotProduct(rv, normal);
		
		// no resolution if velocities are separating
		if(velAlongNorm > 0)
			return;
		
		// restitution
		float e = Math.min(a.restitution, b.restitution);
		
		// impulse scalar
		float j = -(1 + e) * velAlongNorm;
		j /= a.invMass + b.invMass;
		
		// apply impulse
		Vec2 impulse = new Vec2(j * normal.x, j * normal.y);
		a.velocity.x -= a.invMass * impulse.x;
		a.velocity.y -= a.invMass * impulse.y;
		b.velocity.x += b.invMass * impulse.x;
		b.velocity.y += b.invMass * impulse.y;
	}
	
	public Vec2 normalize(Vec2 v)
	{
		double mag = Math.sqrt(v.x * v.x + v.y * v.y);
		return new Vec2(v.x / mag, v.y  / mag);
	}

	// this is horrible and you just need to rewrite all of it
	/*
	public void correctPosition(RigidBody a, RigidBody b)
	{
		double percent = 0.2;
		double slop = 0.01;
		double penetration = 0;
		Vec2 n = new Vec2(0, 0);
		double correction = Math.max(penetration - slop, 0.0f) / (a.invMass + b.invMass) * percent * n;
		a.position.x -= a.invMass * correction;
		a.position.y -= a.invMass * correction;
		b.position.x += b.invMass * correction;
		b.position.y += b.invMass * correction;
	}
	*/
	
	public float dotProduct(Vec2 a, Vec2 b)
	{
		return a.x * b.x + a.y * b.y;
	}
	
	// add vectors
	public Vec2 vAdd(Vec2 a, Vec2 b)
	{
		return new Vec2(a.x + b.x, a.y + b.y);
	}
	
	// subtract vectors
	public Vec2 vSub(Vec2 a, Vec2 b)
	{
		return new Vec2(a.x - b.x, a.y - b.y);
	}
}
