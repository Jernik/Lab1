package Maps;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PylonScreen6 extends DisplayObjects.PylonScreen {

	String message="";
	Utility.Console buffer=new Utility.Console(30);
	boolean acceptInput=false;

	public PylonScreen6() {
		super();
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(100,100,600,600);
		g.setColor(Color.RED);
		g.drawRect(100,100,600,600);
		g.setFont(new Font("Courier",Font.PLAIN,20));
		g.setColor(Color.BLACK);
		g.drawString("NEMO HEAL U",350,150);
		g.setFont(new Font("Courier",Font.PLAIN,12));
		g.drawString(message,400-12*message.length()/3,675);
		for (int i=0;i<buffer.size;i++) {
			g.drawString(buffer.array[i],400-12*buffer.array[i].length()/3,200+15*i);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int code=e.getKeyCode();
		if (!acceptInput) {
			acceptInput=true;
			return;
		}
		if (code>=KeyEvent.VK_A && code<=KeyEvent.VK_Z) {
			message+=((char)('A'+code-KeyEvent.VK_A));
		}
		if (code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9) {
			message+=((char)('0'+code-KeyEvent.VK_0));
		}
		if (code==KeyEvent.VK_SPACE) {
			message+=' ';
		}
		if (code==KeyEvent.VK_ENTER) {
			enter();
		}
		if (code==KeyEvent.VK_BACK_SPACE) {
			if (message.length()>=1) {
				message=message.substring(0,message.length()-1);
			}
		}
	}
	
	public void enter() {
		String[] args=message.split(" ");
		buffer.add(message);
		message="";
		if (args.length==0) {
			return;
		}
		if (args.length==1) {
			if (args[0].equals("")) {
				return;
			}
			if (args[0].equals("EXIT")) {
				D.deactivatePylon();
				return;
			}
			if (args[0].equals("CLOSE")) {
				D.deactivatePylon();
				return;
			}
			if (args[0].equals("DEACTIVATE")) {
				D.deactivatePylon();
				return;
			}
			if (args[0].equals("STOP")) {
				D.deactivatePylon();
				return;
			}
			if (args[0].equals("DIE")) {
				D.you.killed=true;
				return;
			}
			if (args[0].equals("LIGHTBULB")) {
				((Pylon6)(this.pylon)).lit=true;
				buffer.add("THE LATENT ENERGY WITHIN THE PYLON REACTS  TO YOUR PRESENCE");
				return;
			}
			if (args[0].equals("HELP")) {
				buffer.add("THIS IS A PYLON");
				buffer.add("TO EXIT, TYPE EXIT");
				buffer.add("TO GET HELP, TYPE HELP");
				buffer.add("IF YOU LOOK CLOSELY YOU CAN SEE THE HELP DIALOGUE IS QUITE SHIP SHAPE");
				buffer.add("TO OFFER SHRAPNEL COLLECTED FROM ENEMIES TYPE OFFER X COLOR");
				buffer.add("FOR EXAMPLE TO OFFER 4 RED SHRAPNEL TYPE OFFER 4 RED");
				buffer.add("OFFERING SHRAPNEL REMOVES YOUR INVULNERABILITY");
				buffer.add("YOUR LUMINENCE SLOWLY DRAINS OVER TIME");
				buffer.add("IF YOU RUN OUT OF LIGHT YOU WILL DIE");
				buffer.add("IF YOU GET DISSOLVED YOU WILL DIE");
				buffer.add("GOOD LUCK");
				return;
			}
		}
		if (args.length==2) {
			if (args[0].equals("GO")) {
				if (args[1].equals("NORTH")) {
					buffer.add("I CANT PRESS W FOR YOU");
					return;
				}
				if (args[1].equals("EAST")) {
					buffer.add("IF YOU GO EAST YOU WILL HIT A WALL");
					buffer.add("I DONT WANT YOU TO HIT A WALL");
					return;
				}
				if (args[1].equals("WEST")) {
					buffer.add("IF YOU GO WEST YOU WILL HIT A WALL");
					buffer.add("I DONT WANT YOU TO HIT A WALL");
					return;
				}
				if (args[1].equals("SOUTH")) {
					buffer.add("IF YOU GO SOUTH YOU WILL DIE");
					buffer.add("I DONT WANT YOU TO DIE");
					return;
				}
			}
		}
		if (args.length==3) {
			if (args[0].equals("OFFER")) {
				int num=-1;
				try {num=Integer.parseInt(args[1]);}
				catch (Exception e) {
					if (args[1].equals("A") || args[1].equals("ONE")) {
						num=1;
					}
					if (args[1].equals("TWO")) {
						num=2;
					}
				}
				if (args[2].equals("RED") || args[2].equals("REDS")) {
					if (this.D.you.redXP>=num) {
						this.D.you.luminence+=num*10000;
						this.D.you.maxLuminence+=num*10000;
						this.D.you.redEnergy+=num;
						this.D.you.redXP-=num;
						buffer.add(num+" RED SHRAPNEL CONVERTED TO ENERGY");
						return;
					}
					else buffer.add("NOT ENOUGH REDS");
					return;
				}
				if (args[2].equals("GREEN") || args[2].equals("GREENS")) {
					if (this.D.you.greenXP>=num) {
						this.D.you.luminence+=num*10000;
						this.D.you.maxLuminence+=num*10000;
						this.D.you.greenEnergy+=num;
						this.D.you.greenXP-=num;
						buffer.add(num+" GREEN SHRAPNEL CONVERTED TO ENERGY");
						return;
					}
					else buffer.add("NOT ENOUGH GREENS");
					return;
				}
				if (args[2].equals("BLUE")) {
					if (this.D.you.blueXP>=num) {
						this.D.you.luminence+=num*10000;
						this.D.you.maxLuminence+=num*10000;
						this.D.you.blueEnergy+=num;
						this.D.you.blueXP-=num;
						buffer.add(num+" BLUE SHRAPNEL CONVERTED TO ENERGY");
						return;
					}
					else buffer.add("NOT ENOUGH BLUES");
					return;
				}
			}
		}
		buffer.add("YOUR COMMAND IS DERSTOOD");
		message="";
	}

}