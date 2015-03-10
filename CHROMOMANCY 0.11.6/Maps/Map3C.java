package Maps;
/**
* Level 3C map.  Contains Green enemy.
*/
public class Map3C extends Maps.Map {
	/**
	* {inheritdoc}
	*/
	public Map3C() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.right=new Maps.Map2();
		this.right.D=this.D;
                this.left=new Maps.Map4C();
		this.left.D=this.D;
                levelName="Map3C";
                
		ConcreteObject.Entity green=new Maps.Green3C();
		green.Color(0,255,0);
		green.Displacement(100,400);
		green.D=this.D;
		this.entities.add(green);
		((Maps.Green3C)green).init();
                
		/*ConcreteObject.Entity green2=new Maps.Green4C();
		green2.Color(0,230,0);
		green2.Displacement(100,600);
		green2.D=this.D;
		this.entities.add(green2);
		((Maps.Green4C)green2).init();*/
                
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		drawConnections(buffer);
	}

}