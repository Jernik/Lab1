package DisplayObjects;

/*
 * Inventory will display experience points, number of shrapnel, etc.
 * Press 'I' to close it again
 * Closing inventorysets framefreeze to false, restarts the drawing loop and game continues
 * 
 * The info in this class will be updated every step of the main frame by calling init() again
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;


public class InventoryScreen extends JInternalFrame {//JInternalFrame, not JFrame
   /**
    * The JFrame that contains everything.
    */
    public DisplayObjects.Display D;
    /**
     * The data that is displayed on the screen
     */
    int redXP= 0;
    int blueXP=0;
    int greenXP=0;
    String levelName=null;
    int luminence=0;
    int maxLuminence=0;
        

    public InventoryScreen(DisplayObjects.Display D) {
        this.D=D;
        setSize(600, 600);
        init();
        this.setLocation(100, 100);
    }
    /**
     * The method that sets up the inventory screen
     */
    public void init(){
        blueXP=D.you.blueXP;
        redXP=D.you.redXP;
        greenXP=D.you.greenXP;
        levelName=D.map.levelName;
        luminence=D.you.luminence;
        maxLuminence=100;//D.you.maxLuminence;
        
    }
    /**
     * method used for debugging purposes
     */
    public void print(){
   // System.out.println("blueXP: " + blueXP);
   // System.out.println("redXP: " + redXP);
    //System.out.println("greenXP: " + greenXP);
    //System.out.println("MapName: " + levelName);
    System.out.println(D.inventoryOpen);
    System.out.println(D.frameFreeze);
    System.out.println(D.drawingThread.isAlive());
    }
    public void paint(Graphics g){
		if(D.inventoryOpen==true){
			//builds rectangle 
			g.setColor(Color.black);
			g.fillRect(100,100,600,600);
			g.setColor(Color.red);
			g.drawRect(100, 100, 600, 600);
			
			g.setColor(java.awt.Color.WHITE);
			g.setFont(new Font("Ariel",Font.PLAIN,40));
			g.drawString("Level: "+levelName, 135, 135);
			g.setFont(new Font("Ariel",Font.PLAIN,20));
			g.drawString("Red Shrapnel: "+redXP,150,175);
			g.drawString("Blue Shrapnel: "+blueXP,150,225);
			g.drawString("Green Shrapnel: "+greenXP,150,275);
			g.drawString("Luminence : "+luminence,150,350);
		
		}
    }
}
