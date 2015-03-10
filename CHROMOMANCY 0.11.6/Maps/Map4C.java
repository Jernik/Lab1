/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

/**
 *
 * @author Administrator
 */
public class Map4C extends Maps.Map{
    /**
	* {inheritdoc}
	*/
	public Map4C() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.right=new Maps.Map3C();
		this.right.D=this.D;
		ConcreteObject.Entity green=new Maps.Green4C();
		green.Color(0,255,0);
		green.Displacement(400,400);
		green.D=this.D;
		this.entities.add(green);
		((Maps.Green4C)green).init();
                levelName="Map4C";
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		drawConnections(buffer);
	}

    
}
