package Maps;

import java.util.ArrayList;
import ConcreteObject.*;
/**
* Super class for all maps.  These hold level data.
* Also the level 1 map.
*/
public class Map {
	/**
	* List of Entities that are a part of said map.
	*/
	public ArrayList<ConcreteObject.Entity> entities=new ArrayList<ConcreteObject.Entity>();
	/**
	* list of dead entities
	* Made because Kross was messing about
	*/
	public ArrayList<ConcreteObject.Entity> deadEntities = new ArrayList<ConcreteObject.Entity>();
	/**
	* Name of the level
	*/
	public String levelName="Map1";
	/**
	* Display object that allows access to other variables.
	*/
	public DisplayObjects.Display D;
	/**
	* Map connected to the north door.
	*/
	public Map up=null;
	/**
	* Map connected to the south door.
	*/
	public Map down=null;
	/**
	* Map connected to west door.
	*/
	public Map left=null;
	/**
	* Map connected to east door.
	*/
	public Map right=null;
	/**
	* Interactive object at the center of some levels.  Null if there isnt one.
	*/
	public Pylon pylon=null;
	/**
	* Constructor.
	*/
	public Map() {}
	/**
	* Initialization code.  Creates NPCs and enemies.
	*/
	public void init() {
		this.up=new Maps.Map2();
		this.up.D=this.D;
		this.down=new Maps.Map6();
		this.down.D=this.D;
		ConcreteObject.Entity red=new Maps.Red();
		red.Color(255,0,0);
		red.D=this.D;
		this.entities.add(red);
		ConcreteObject.Entity green=new Maps.Green();
		green.Color(0,255,0);
		green.D=this.D;
		this.entities.add(green);
		ConcreteObject.Entity blue=new Maps.Blue();
		blue.Color(0,0,255);
		blue.D=this.D;
		this.entities.add(blue);
	}
	/**
	* Draws map text, which inclues directions and signs.
	* @param buffer The databuffer to draw to.
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		String s="GO UP TO START";
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!=' ') {
				boolean[][] letter=Map.letter(s.charAt(i));
				for (int y=0;y<letter.length;y++) {
					for (int x=0;x<letter[0].length;x++) {
						if (letter[y][x]) {
							buffer.setElem(800*(y+11)+x+358+6*i,255*256*256+255*256+255);
						}
					}
				}
			}
		}
		s="MADE BY BRENDAN BERGER AND LUKE MILLER AND MINAS BENYAMIN";
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!=' ') {
				boolean[][] letter=Map.letter(s.charAt(i));
				for (int y=0;y<letter.length;y++) {
					for (int x=0;x<letter[0].length;x++) {
						if (letter[y][x]) {
							buffer.setElem(800*(y+700)+x+277+6*i,255*256*256+255*256+255);
						}
					}
				}
			}
		}
		s="DEATH BEYOND HERE";
		for (int i=0;i<s.length();i++) {
			if (s.charAt(i)!=' ') {
				boolean[][] letter=Map.letter(s.charAt(i));
				for (int y=0;y<letter.length;y++) {
					for (int x=0;x<letter[0].length;x++) {
						if (letter[y][x]) {
							buffer.setElem(800*(y+770)+x+349+6*i,255*256*256+255*256+255);
						}
					}
				}
			}
		}
		drawConnections(buffer);
	}
	/**
	* Draws doors that connect levels.
	* @param buffer The data buffer to draw to
	*/
	public void drawConnections(java.awt.image.DataBuffer buffer) {
		if (this.up!=null) {
			for (int len=350;len<=450;len++) {
				for (int wid=0;wid<10;wid++) {
					buffer.setElem(800*wid+len,255*256*256+255*256+255);
				}
			}
		}
		if (this.down!=null) {
			for (int len=350;len<=450;len++) {
				for (int wid=790;wid<800;wid++) {
					buffer.setElem(800*wid+len,255*256*256+255*256+255);
				}
			}
		}
		if (this.left!=null) {
			for (int len=350;len<=450;len++) {
				for (int wid=0;wid<10;wid++) {
					buffer.setElem(800*len+wid,255*256*256+255*256+255);
				}
			}
		}
		if (this.right!=null) {
			for (int len=350;len<=450;len++) {
				for (int wid=790;wid<800;wid++) {
					buffer.setElem(800*len+wid,255*256*256+255*256+255);
				}
			}
		}
	}
	
	/**
	* This takes a letter and calls the appropriate method from the 
	* Letter class.
	*/
	public static boolean[][] letter(char c) {
		switch(c) {
		case 'A':return ConcreteObject.Letter.a();
		case 'B':return ConcreteObject.Letter.b();
		case 'C':return ConcreteObject.Letter.c();
		case 'D':return ConcreteObject.Letter.d();
		case 'E':return ConcreteObject.Letter.e();
		case 'F':return ConcreteObject.Letter.f();
		case 'G':return ConcreteObject.Letter.g();
		case 'H':return ConcreteObject.Letter.h();
		case 'I':return ConcreteObject.Letter.i();
		case 'J':return ConcreteObject.Letter.j();
		case 'K':return ConcreteObject.Letter.k();
		case 'L':return ConcreteObject.Letter.l();
		case 'M':return ConcreteObject.Letter.m();
		case 'N':return ConcreteObject.Letter.n();
		case 'O':return ConcreteObject.Letter.o();
		case 'P':return ConcreteObject.Letter.p();
		case 'Q':return ConcreteObject.Letter.q();
		case 'R':return ConcreteObject.Letter.r();
		case 'S':return ConcreteObject.Letter.s();
		case 'T':return ConcreteObject.Letter.t();
		case 'U':return ConcreteObject.Letter.u();
		case 'V':return ConcreteObject.Letter.v();
		case 'W':return ConcreteObject.Letter.w();
		case 'X':return ConcreteObject.Letter.x();
		case 'Y':return ConcreteObject.Letter.y();
		case 'Z':return ConcreteObject.Letter.z();
				case ',':return ConcreteObject.Letter.comma();
				case '!':return ConcreteObject.Letter.exclamation();
				case '.':return ConcreteObject.Letter.period();
				case '\'':return ConcreteObject.Letter.apostraphe(); 
				case '?': return ConcreteObject.Letter.question();
		}
		return null;
	}

}