package ConcreteObject;

import java.util.ArrayList;
/**
* Text Projectiles that disappear when the player moves over them.
* They are primarilly used for dialogue purposes.
*/
public class Text extends Projectile {
	/**
	* What the text is to say.
	*/
	public String words;
	/**
	* ArrayList of other possible dialogue selections.  These also disappear
	* when the player moves over this.
	*/
	public ArrayList<ConcreteObject.Text> companions=new ArrayList<ConcreteObject.Text>();
	/**
	* Null constructor.  For initialization, psudoconstructors must be used.
	*/
	public Text() {}
	/**
	* Psudoconstructor to set the text
	* @param w The text that this displays
	*/
	public void Words(String w) {
		this.words=w;
	}
	/**
	* {@inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		if (!killed) {
			int color=this.red*256*256+this.green*256+this.blue;
			if (this.words!=null) {
				String s=this.words.toUpperCase();
				int x=(int)this.xLoc-s.length()*3;
				int y=(int)this.yLoc-6;
				for (int k=0;k<s.length();k++) {
					if (s.charAt(k)!=' ') {
						boolean[][] letter=Maps.Map.letter(s.charAt(k));
						for (int j=0;j<letter.length;j++) {
							for (int i=0;i<letter[0].length;i++) {
								if (letter[j][i]) {
									buffer.setElem(800*(j+y)+i+x+6*k,color);
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	* {@inheritdoc}
	*/
	public void loop(float time) {
		this.xAccel+=(float)(Math.random()-0.5)/1000/time;
		this.yAccel+=(float)(Math.random()-0.5)/1000/time;
		this.xAccel*=0.999;
		this.yAccel*=0.999;
		super.loop(time);
		collisionDetect();
	}
	/**
	* This method detects and responds to collision between this text and
	* the player by testing for overlap in x and y displacement values.
	*/
	public void collisionDetect() {
		if (!killed) {
			int left=(int)this.xLoc-words.length()*3;
			int right=(int)this.xLoc+words.length()*3;
			int up=(int)this.yLoc-6;
			int down=(int)this.yLoc+6;
			if (left<this.D.you.xLoc+5 && right>this.D.you.xLoc-5 && up<this.D.you.yLoc+5 && down>this.D.you.yLoc-5) {
				this.owner.saying=this.talk;
				for (int i=0;i<companions.size();i++) {
					this.owner.projectiles.remove(companions.get(i));
				}
				if (this.owner.saying.options!=null) {
					ArrayList<ConcreteObject.Text> c=new ArrayList<ConcreteObject.Text>();
					for (int i=0;i<this.owner.saying.options.length;i++) {
						ConcreteObject.Text t=new ConcreteObject.Text();
						t.D=this.D;
						t.Words(this.talk.options[i]);
						t.Displacement(this.owner.xLoc,this.owner.yLoc);
						float a=(float)(100*Math.random());
						t.Velocity((float)(10*Math.sin(a)),(float)(10*Math.cos(a)));
						t.Color(this.red,this.green,this.blue);
						t.talk=this.talk.responses[i];
						t.owner=this.owner;
						c.add(t);
					}
					for (int i=0;i<c.size();i++) {
						for (int j=0;j<c.size();j++) {
							c.get(i).companions.add(c.get(j));
						}
						this.owner.projectiles.add(c.get(i));
					}
				}
				this.killed=true;
			}
		}
	}

}