package ConcreteObject;

import java.awt.Rectangle;

/**
 *This is the superclass for every piece of shrapnel
 */
public class Shrapnel extends ConcreteObject.Projectile{
    /**
	* Time this object stays on the field
	*/
	int life=(int)(Math.random()*20000);
        
        /**
         * These are the XP/shard value for each shrapnel
         */
        public int blueXP;
        
        public int redXP;
        
        public int greenXP;
        
	/**
	* Constructor.  Must call psudoconstructors to initialize.
	*/
	public Shrapnel() {}
	/**
	* {inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		int color = getColor();
		for (int j=0;j<4;j++) {
			for (int i=0;i<4;i++) {
				int x=(int)(i+this.xLoc-2f);
				int y=(int)(j+this.yLoc-2f);
				if (!(x<0 || x>799 || y<0 || y>799)) {
					buffer.setElem(800*y+x,color);
				}
			}
		}
		for (int i=0;i<this.projectiles.size();i++) {
			this.projectiles.get(i).draw(buffer);
		}
	}
	/**
	* {inheritdoc}
	*/
	public void loop(float time) {
		playerMagnet();
        super.loop(time);
		this.life--;
		if (this.life<=0) {
			this.owner.projectiles.remove(this);
		}
	}
//added this method to be able to reuse the draw code. the color was the only thing different between them
        public int getColor(){
            int color=(int)(Math.random()*256*256*256);
            return color;
        }
        /**
         * makes 2 rectangles from the player data and the shrapnel data and then 
         * uses the intersect method. Brendan is a dummy and hardcoded it earlier, so I 
         * hardcoded it as well
         * @param entity
         * @return 
         */
         public boolean intersect(ConcreteObject.Entity entity){
			if (this.owner==entity) {
                            System.out.println(entity.name);
			//System.out.println("owner is entity(shrap)");
                        
                            return false;
			}
             //System.out.print("Using Shrapnel detection method");
             int entityWidth= (int)10f;//yeah, not sure what I should be doing with these values
             int entityHeight = (int) 10f;
             int thisHeight = (int) 4f;
             int thisWidth = (int) 4f;
			 float entityLeft=entity.xLoc-5,entityRight=entity.xLoc+5;
			 float entityUp=entity.yLoc-5,entityDown=entity.yLoc+5;
			 float projectileLeft=this.xLoc-2,projectileRight=this.xLoc+2;
			 float projectileUp=this.yLoc-2,projectileDown=this.yLoc+2;
			 boolean xIntersect=(projectileLeft>entityLeft && projectileLeft<entityRight) || (projectileRight>entityLeft && projectileRight<entityRight);
			 boolean yIntersect=(projectileUp>entityUp && projectileUp<entityDown) || (projectileUp>entityUp && projectileUp<entityDown);
			 boolean intersect=xIntersect && yIntersect && (this.owner!=entity);
             //Rectangle entityRect = new Rectangle((int)entity.xLoc-5,(int)entity.yLoc-5, entityHeight, entityWidth);
             //Rectangle projectileRect= new Rectangle((int)this.xLoc-2, (int)this.yLoc-2,thisHeight, thisWidth);
             //boolean intersect=entityRect.intersects(projectileRect);
             return intersect;
        }
        
        public boolean intersect(ConcreteObject.Projectile projectile){
       // System.out.println("Using shrap/proj method");
        boolean intersect = false;
        return intersect;
        }
    
        public void kill(){
			this.owner.projectiles.remove(this);
        }
        public void kill(ConcreteObject.Entity you){
        this.D.you.blueXP+=blueXP;
        this.D. you.greenXP+=greenXP;
        this.D.you.redXP+=redXP;
        this.owner.projectiles.remove(this);
        }
        
        /**
         * This method is used to move the shrapnel closer to the player, 
         * making it easier to pick up
         * 
         * I don't actually know what I'm doing here, so this partially works
         */
    public void playerMagnet(){
        float xDiff=D.you.xLoc-this.xLoc;
        float yDiff=D.you.yLoc-this.yLoc;
		float totalDistSquared=xDiff*xDiff+yDiff*yDiff;
        if((totalDistSquared!=0) && (totalDistSquared<2500)){
			if (xDiff>0) {
				this.xAccel+=(float)1f*xDiff/(totalDistSquared*(xDiff+yDiff));
			} else this.xAccel-=(float)1f*xDiff/(totalDistSquared*(xDiff+yDiff));
			if (yDiff>0) {
				this.yAccel+=(float)1f*yDiff/(totalDistSquared*(xDiff+yDiff));
			} else this.yAccel-=(float)1f*yDiff/(totalDistSquared*(xDiff+yDiff));
		}
    }
    
}
