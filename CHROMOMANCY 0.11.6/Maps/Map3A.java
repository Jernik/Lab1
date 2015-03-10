package Maps;
/**
* Level 3A map.  Contains Red NPC.
*/
public class Map3A extends Maps.Map {
	/**
	* {inheritdoc}
	*/
	public Map3A() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.down=new Maps.Map2();
		this.down.D=this.D;
		ConcreteObject.Entity red=new Maps.Red3A();
		red.Color(255,0,0);
		red.Displacement(400,400);
		red.D=this.D;
		this.entities.add(red);
		((Maps.Red3A)red).init();
        levelName="Map3A";
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		drawConnections(buffer);
	}

}