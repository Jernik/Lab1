package Maps;
/**
 *Shrapnel from killing Green4C entity
 */
public class ShrapnelGreen4C extends ConcreteObject.Projectile{
    /**
	* Time this object stays on the field
	*/
	int life=(int)(Math.random()*2000);
	/**
	* Constructor.  Must call psudoconstructors to initialize.
	*/
	public ShrapnelGreen4C() {}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		int color=(int)(((int)(Math.random()*256)*256+Math.random())*256);
		for (int j=0;j<4;j++) {
			for (int i=0;i<4;i++) {
				int x=(int)(i+this.xLoc-2f);
				int y=(int)(j+this.yLoc-2f);
				if (!(x<0 || x>799 || y<0 || y>799)) {
					buffer.setElem(800*y+x,color);
				}
			}
		}
		for (int i=0;i<this.projectiles.size();i++) {
			this.projectiles.get(i).draw(buffer);
		}
	}
	/**
	* {inheritdoc}
	*/
	public void loop(float time) {
		super.loop(time);
		this.life--;
		if (this.life<=0) {
			this.owner.projectiles.remove(this);
		}
	}
    
}
