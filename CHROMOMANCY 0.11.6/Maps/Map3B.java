package Maps;
/**
* Level 3B map.  Contains Blue enemy.
*/
public class Map3B extends Maps.Map {
	/**
	* {inheritdoc}
	*/
	public Map3B() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.left=new Maps.Map2();
		this.left.D=this.D;
		ConcreteObject.Entity blue=new Maps.Blue3B();
		blue.Color(0,0,255);
		blue.Displacement(400,400);
		blue.D=this.D;
		this.entities.add(blue);
		((Maps.Blue3B)blue).init();
                levelName="Map3B";
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		drawConnections(buffer);
	}

}