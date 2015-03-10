package Maps;
/**
* The Blue NPC at level 1
*/
public class Blue extends ConcreteObject.Entity {
	/**
	* The name of the NPC
	*/
	public String name="Blue";
	/**
	* Angle of movement
	*/
	public float angle=(float)(11*Math.PI/6);
	/**
	* Constructor.  Must call psudoconstructors to initialize.
	*/
	public Blue() {}
	/**
	* {inheritdoc}
	*/
	public void loop(float time) {
		angle+=time/10f;
		this.xLoc=(float)(400f+300f*Math.sin(angle));
		this.yLoc=(float)(400f+300f*Math.cos(angle));
		for (ConcreteObject.Projectile p:this.projectiles) {
			p.loop(time);
		}
	}
	/**
	* {inheritdoc}
	*/
	public void emit(DisplayObjects.FluidField field) {
		int stepLen=this.D.field.stepLen;
		int left=(int)xLoc/stepLen;
		int right=left+1;
		int up=(int)yLoc/stepLen;
		int down=up+1;
		field.dXVel[DisplayObjects.FluidSolver.IX(left,up)]=(400-xLoc)*0.002f*(right*stepLen-xLoc)*(down*stepLen-yLoc);
		field.dYVel[DisplayObjects.FluidSolver.IX(left,up)]=(400-yLoc)*0.002f*(right*stepLen-xLoc)*(down*stepLen-yLoc);
		field.dXVel[DisplayObjects.FluidSolver.IX(right,up)]=(400-xLoc)*0.002f*(xLoc-left*stepLen)*(down*stepLen-yLoc);
		field.dYVel[DisplayObjects.FluidSolver.IX(right,up)]=(400-yLoc)*0.002f*(xLoc-left*stepLen)*(down*stepLen-yLoc);
		field.dXVel[DisplayObjects.FluidSolver.IX(left,down)]=(400-xLoc)*0.002f*(right*stepLen-xLoc)*(yLoc-up*stepLen);
		field.dYVel[DisplayObjects.FluidSolver.IX(left,down)]=(400-yLoc)*0.002f*(right*stepLen-xLoc)*(yLoc-up*stepLen);
		field.dXVel[DisplayObjects.FluidSolver.IX(right,down)]=(400-xLoc)*0.002f*(xLoc-left*stepLen)*(yLoc-up*stepLen);
		field.dYVel[DisplayObjects.FluidSolver.IX(right,down)]=(400-yLoc)*0.002f*(xLoc-left*stepLen)*(yLoc-up*stepLen);
		field.bSource[DisplayObjects.FluidSolver.IX(left,up)]=20.0f*(right*stepLen-xLoc)*(down*stepLen-yLoc);
		field.bSource[DisplayObjects.FluidSolver.IX(right,up)]=20.0f*(xLoc-left*stepLen)*(down*stepLen-yLoc);
		field.bSource[DisplayObjects.FluidSolver.IX(left,down)]=20.0f*(right*stepLen-xLoc)*(yLoc-up*stepLen);
		field.bSource[DisplayObjects.FluidSolver.IX(right,down)]=20.0f*(xLoc-left*stepLen)*(yLoc-up*stepLen);
	}
	
}