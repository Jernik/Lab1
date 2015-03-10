package Maps;
/**
* Level 2 map.  Contains Reena Bowe, who introduces the player to the game.
*/
public class Map2 extends Maps.Map {
	/**
	* {inheritdoc}
	*/
	public Map2() {}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.right=new Maps.Map3B();
		this.right.D=this.D;
		this.up=new Maps.Map3A();
		this.up.D=this.D;
		this.left=new Maps.Map3C();
		this.left.D=this.D;
		this.down=new Maps.Map();
		this.down.D=this.D;
		levelName="Map2";
		ConcreteObject.Entity reena=new Maps.Reena2();
		reena.Color(127,127,127);
		reena.Displacement(400,400);
		reena.D=this.D;
		this.entities.add(reena);
		((Maps.Reena2)reena).init();
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		drawConnections(buffer);
	}

}