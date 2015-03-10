package Maps;

import java.awt.*;

public class Pylon6 extends ConcreteObject.Pylon {

	boolean lit=false;

	public Pylon6() {}
	
	public void init() {
		actionFrame=new PylonScreen6();
		actionFrame.D=this.D;
		actionFrame.pylon=this;
	}
	
	public void paint(Graphics g) {
		if (activated) {
			actionFrame.paint(g);
		}
		if (!activated) {
			if (this.lit) {
				g.setColor(Color.YELLOW);
				g.fillOval(350,500,100,100);
			}
			g.setColor(Color.WHITE);
			g.drawOval(250,400,300,300);
			for (int i=0;i<=6;i++) {
				g.drawLine(325,250+25*i,475,250+25*i);
				if (i!=3) {
					g.drawLine(325+25*i,250,325+25*i,550-(int)Math.sqrt(150*150-(325+25*i-400)*(325+25*i-400)));
				}
			}
			g.drawRect(350,225,100,25);
			g.drawLine(400,150,400,225);
			g.drawLine(400,400,400,600);
			g.drawRect(375,400,50,150);
			for (int i=0;i<=3;i++) {
				g.drawArc(388,425+50*i-32,64,64,129,102);
				g.drawArc(348,425+50*i-32,64,64,-51,102);
			}
		}
	}

}