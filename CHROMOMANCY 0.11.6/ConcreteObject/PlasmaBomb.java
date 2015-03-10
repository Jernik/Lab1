package ConcreteObject;

/**
 *
 * This is the attack that detonates after a short period of time and shoots plasma out in a wave around it
 */
import java.awt.Rectangle;
public class PlasmaBomb extends ConcreteObject.Projectile{

	/**
	* The amount of time that passes before detonation
	*/
	int delay=1000;
	/**
	* The amount of time the detonation lasts
	*/
	int power=500;
	/**
	* When the power goes below the mass, there is no longer anymore color
	* to eject, but there is still an outward velocity stream
	*/
	int mass=100;
	/**
	* Reduces power of stream and amount of color released
	*/
	int decay=1;

	/**
	* animate and whatnot
	* @param time 
	*/
	public void loop(float time) {
		super.loop(time);
		if (this.delay>0) {
			this.delay--;
		}
		if (this.delay<=0 && this.power>0) {
			this.power--;
		}
	}
   
	public int getColor(){
		int color=this.red*256*256+this.green*256+this.blue;
		return color;
	}
	
	public void emit(DisplayObjects.FluidField field) {
		if (delay<=0 && power>=0) {
			int stepLen=field.stepLen;
			int left=(int)(xLoc/stepLen-2);
			int right=(int)(xLoc/stepLen+2);
			int up=(int)(yLoc/stepLen-2);
			int down=(int)(yLoc/stepLen+2);
			field.dXVel[DisplayObjects.FluidSolver.IX(left,up)]-=1.0*power/decay;
			field.dYVel[DisplayObjects.FluidSolver.IX(left,up)]-=1.0*power/decay;
			field.dXVel[DisplayObjects.FluidSolver.IX(right,up)]+=1.0*power/decay;
			field.dYVel[DisplayObjects.FluidSolver.IX(right,up)]-=1.0*power/decay;
			field.dXVel[DisplayObjects.FluidSolver.IX(left,down)]-=1.0*power/decay;
			field.dYVel[DisplayObjects.FluidSolver.IX(left,down)]+=1.0*power/decay;
			field.dXVel[DisplayObjects.FluidSolver.IX(right,down)]+=1.0*power/decay;
			field.dYVel[DisplayObjects.FluidSolver.IX(right,down)]+=1.0*power/decay;
			if (power>mass) {
				double rootOfPower=Math.sqrt(power);
				field.rSource[DisplayObjects.FluidSolver.IX(left,up)]+=rootOfPower*this.red/decay;
				field.gSource[DisplayObjects.FluidSolver.IX(left,up)]+=rootOfPower*this.green/decay;
				field.bSource[DisplayObjects.FluidSolver.IX(left,up)]+=rootOfPower*this.blue/decay;
				field.rSource[DisplayObjects.FluidSolver.IX(right,up)]+=rootOfPower*this.red/decay;
				field.gSource[DisplayObjects.FluidSolver.IX(right,up)]+=rootOfPower*this.green/decay;
				field.bSource[DisplayObjects.FluidSolver.IX(right,up)]+=rootOfPower*this.blue/decay;
				field.rSource[DisplayObjects.FluidSolver.IX(left,down)]+=rootOfPower*this.red/decay;
				field.gSource[DisplayObjects.FluidSolver.IX(left,down)]+=rootOfPower*this.green/decay;
				field.bSource[DisplayObjects.FluidSolver.IX(left,down)]+=rootOfPower*this.blue/decay;
				field.rSource[DisplayObjects.FluidSolver.IX(right,down)]+=rootOfPower*this.red/decay;
				field.gSource[DisplayObjects.FluidSolver.IX(right,down)]+=rootOfPower*this.green/decay;
				field.bSource[DisplayObjects.FluidSolver.IX(right,down)]+=rootOfPower*this.blue/decay;
			}
		}
	}
	
	/**
	 * kill method
	 */
	public void kill(){
		detonate();
	}
	/**
	 * this will affect the plasma field and stuff and things
	 */
	//TODO get Brendan to do this <strike>plasma</strike> WITCHCRAFT stuff (HTML tags totally work in java comments, right?)
	public void detonate(){
		
	}
	/**
	 * this will actually check
	 * @param entity
	 * @return 
	 */
	public boolean intersect(ConcreteObject.Entity entity){
		int entityWidth= (int)5f;//same here, I dont know what these values should be
		int entityHeight = (int) 5f;
		int thisHeight = (int) 2f;
		int thisWidth = (int) 2f;
		Rectangle entityRect = new Rectangle((int)entity.xLoc,(int)entity.yLoc, entityHeight, entityWidth);
		Rectangle projectileRect= new Rectangle((int)this.xLoc, (int)this.yLoc,thisHeight, thisWidth);
		boolean intersect=entityRect.intersects(projectileRect);
		if(intersect) {
			detonate();
			System.out.println("INTERSECT");
		}
		return intersect;
	}
}
