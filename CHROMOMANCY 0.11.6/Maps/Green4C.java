/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

/**
 *
 * @author Administrator
 */
public class Green4C extends ConcreteObject.Entity{
    /**
	* Name of NPC
	*/
	public String name="Green4C";
	/**
	* Constructor.  Must call psudoconstructors to initialize.
	*/
	public Green4C() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
        resistance=16;
        teamTag=2;
        }
	/**
	* {inheritdoc}
	*/
	public void loop(float time) {
		super.loop(time);
		if (colorDifference(D.field.interpolatedDensity((int)xLoc,(int)yLoc),(this.red<<16 | this.green<<8 | this.blue))<resistance) {
			if (this.killed==false) {
				this.killed=true;
				kill();
			}
		}
	}
	/**
	* Kills NPC and creates 20 shrapnel pieces of 2 colors
	*/
	public void kill() {
		for (int i=0;i<10;i++) {
			float angle=(float)(314*Math.random());
			float magnitude=(float)(15*Math.random());
			ShrapnelRed s=new ShrapnelRed();
                        ShrapnelBlue p=new ShrapnelBlue();
			s.Displacement(this.xLoc,this.yLoc);
			s.D=this.D;
			s.Velocity((float)(magnitude*Math.cos(angle)),(float)(magnitude*Math.sin(angle)));
			s.Acceleration((float)(magnitude*Math.cos(angle)/5),(float)(magnitude*Math.sin(angle)/5));
			s.owner=this;
			this.projectiles.add(s);
                        
                        angle=(float)(314*Math.random());
                        magnitude=(float)(15*Math.random());
			p.Displacement(this.xLoc,this.yLoc);
			p.D=this.D;
			p.Velocity((float)(magnitude*Math.cos(angle)),(float)(magnitude*Math.sin(angle)));
			p.Acceleration((float)(magnitude*Math.cos(angle)/5),(float)(magnitude*Math.sin(angle)/5));
			p.owner=this;
			this.projectiles.add(p);
		}
                //D.map.deadEntities.add(this);
               // D.map.entities.remove(this);
	}
    
}
