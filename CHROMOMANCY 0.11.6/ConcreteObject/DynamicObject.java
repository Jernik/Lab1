package ConcreteObject;

import java.util.ArrayList;

/**
* This is the superclass for everything that moves.
*/
public abstract class DynamicObject {

    /**
    * The JFrame that contains everything.
    */
    public DisplayObjects.Display D;
    /**
    * Locational coordinate
    */
    public float xLoc,yLoc;
    /**
    * Velocity vector value
    */
    public float xVel,yVel;
    /**
    * Acceleration vector value
    */
    public float xAccel,yAccel;
    /**
    * Color value
    */
    public int red,green,blue;
    /**
    * Arraylist of Projectiles that come from this object
    */
    public ArrayList<Projectile> projectiles=new ArrayList<Projectile>();
    /**
    * The Name of this object for dialogue purposes
    */
    public String name="";
    /**
    * The complete dialogue tree
    */
    public Talking.Talk talk;
    /**
    * The current dialogue tree
    */
    public Talking.Talk saying;
    /**
    * When true, this object no longer affects the world
    */
    public boolean killed=false;
    
    /**
    * Psudoconstructor to set Displacement
    * @param x The X displacement
    * @param y The Y displacement
    */
    public void Displacement(float x,float y) {
        this.xLoc=x;
        this.yLoc=y;
    }
    /**
    * Psudoconstructor to set Displacement
    * @param x The X displacement
    */
    public void Displacement(float x,NULL.Null y) {
        this.xLoc=x;
    }
    /**
    * Psudoconstructor to set Displacement
    * @param y The Y displacement
    */
    public void Displacement(NULL.Null x,float y) {
        this.yLoc=y;
    }
    /**
    * Psudoconstructor to set Velocity
    * @param u The X velocity
    * @param v The Y velocity
    */
    public void Velocity(float u,float v) {
        this.xVel=u;
        this.yVel=v;
    }
    /**
    * Psudoconstructor to set Velocity
    * @param u The X velocity
    */
    public void Velocity(float u,NULL.Null v) {
        this.xVel=u;
    }
    /**
    * Psudoconstructor to set Velocity
    * @param v The Y velocity
    */
    public void Velocity(NULL.Null u,float v) {
        this.yVel=v;
    }
    /**
    * Psudoconstructor to set Acceleration
    * @param r The X acceleration
    * @param u The Y acceleration
    */
    public void Acceleration(float r,float u) {
        this.xAccel=r;
        this.yAccel=u;
    }
    /**
    * Psudoconstructor to set Acceleration
    * @param r The X acceleration
    */
    public void Acceleration(float r,NULL.Null u) {
        this.xAccel=r;
    }
    /**
    * Psudoconstructor to set Acceleration
    * @param u The Y acceleration
    */
    public void Acceleration(NULL.Null r,float u) {
        this.yAccel=u;
    }
    /**
	* Psudoconstructor to set Name
	* @param n The Name of the object
	*/
    public void Name(String n) {
        this.name=n;
    }
    /**
	* Psudoconstructor to set color
	* @param r Red value
	* @param g Green value
	* @param b Blue value
	*/
    public void Color(int r,int g,int b) {
        this.red=r;
        this.green=g;
        this.blue=b;
    }
    /**
	* Psudoconstructor to set color
	* @param r Red value
	* @param g Green value
	*/
    public void Color(int r,int g,NULL.Null b) {
        this.red=r;
        this.green=g;
    }
    /**
	* Psudoconstructor to set color
	* @param r Red value
	* @param b Blue value
	*/
    public void Color(int r,NULL.Null g,int b) {
        this.red=r;
        this.blue=b;
    }
    /**
	* Psudoconstructor to set color
	* @param r Red value
	*/
    public void Color(int r,NULL.Null g,NULL.Null b) {
        this.red=r;
    }
    /**
	* Psudoconstructor to set color
	* @param g Green value
	* @param b Blue value
	*/
    public void Color(NULL.Null r,int g,int b) {
        this.green=g;
        this.blue=b;
    }
    /**
	* Psudoconstructor to set color
	* @param g Green value
	*/
    public void Color(NULL.Null r,int g,NULL.Null b) {
        this.green=g;
    }
    /**
	* Psudoconstructor to set color
	* @param b Blue value
	*/
    public void Color(NULL.Null r,NULL.Null g,int b) {
        this.blue=b;
    }
    /**
	* This method moves the system through time, using Euler's method to
	* calculate new values for vectors.
	* @param time The amount of time that passes in the system
	*/
    public void loop(float time) {
        xLoc+=xVel*time;
        yLoc+=yVel*time;
        xVel+=xAccel*time;
        yVel+=yAccel*time;
        bounce();
    }
    /**
	* This method takes the DataBuffer and draws this object to it
	* @param buffer The DataBuffer to draw to
	*/
    public void draw(java.awt.image.DataBuffer buffer) {}
    /**
	* This method calculates for wall impact and deflects the object if a
	* collision is present.
	*/
    public void bounce() {}
    /**
	* This method adds the source impact of this object to the fluid field.
	* @param field The Fluid Field which contains density and velocity values
	*/
    public void emit(DisplayObjects.FluidField field) {}
    /**
	* This method calculates the difference between two colors.  Colors are
	* stored in an int, where bits 0-8 store blue, 9-16 store green, and
	* 17-24 store red.
	* @param colorA The first color
	* @param colorB The second color
	*/
    public int colorDifference(int colorA,int colorB) {
        int redDifference=Math.abs(colorA/256/256%256-colorB/256/256%256);
        int greenDifference=Math.abs(colorA/256%256-colorB/256%256);
        int blueDifference=Math.abs(colorA%256-colorB%256);
        return redDifference+greenDifference+blueDifference;
    }
    
   

}