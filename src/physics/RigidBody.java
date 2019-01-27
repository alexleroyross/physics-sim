package physics;

public class RigidBody {

	public RigidBody()
	{
		int mass = 10;

		if(mass == 0)
			invMass = 0;
		else
			invMass = 1 / mass;

		restitution = 10;
		velocity = new Vec2(0, 0);
		position = new Vec2(0, 0);
	}

	// inverse mass
	public int invMass;
	
	// elasticity
	public int restitution;
	
	// velocity
	public Vec2 velocity;

	// position
	public Vec2 position;
}
