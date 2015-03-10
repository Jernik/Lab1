package Maps;
/**
* Level 6 map.  Kills player immediately upon entry.
*/
public class Map6 extends Maps.Map {
	/**
	* {inheritdoc}
	*/
	public Map6() {
		this.up=new Maps.Map();
		this.pylon=new Pylon6();
        levelName="Map6";
	}
	/**
	* {inheritdoc}
	*/
	public void init() {
		this.pylon.D=this.D;
		this.pylon.init();
		this.up.D=this.D;
		System.out.println(D);
		//D.you.killed=true;
	}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {}

}