package ConcreteObject;
/**
* This is the superclass for every transient DynamicObject.
* They are usually in the form of bullets and shrapnel, but can take other
* Forms as well, such as items and text.
*/
public class Projectile extends DynamicObject {

	/**
	* The object that created this Projectile.
	*/
	public DynamicObject owner;
        
        public int blueXP, greenXP, redXP;
	/**
	* {@inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		if (!killed) {
			int color=getColor();
			for (int j=0;j<4;j++) {
				for (int i=0;i<4;i++) {
					int x=(int)(i+this.xLoc-2f);
					int y=(int)(j+this.yLoc-2f);
					if (!(x<0 || x>799 || y<0 || y>799)) {
						buffer.setElem(800*y+x,color);
					}
				}
			}
		}
		for (Projectile p:this.projectiles) {
			p.draw(buffer);
		}
	}
	/**
	* {@inheritdoc}
	*/
	public void bounce() {
		if (xLoc<20) xVel=Math.abs(xVel);
		if (xLoc>780) xVel=-Math.abs(xVel);
		if (yLoc<20) yVel=Math.abs(yVel);
		if (yLoc>780) yVel=-Math.abs(yVel);
	}
	/**
	* {@inheritdoc}
	*/
	public void loop(float time) {
		int stepLen=D.field.stepLen;
		xAccel+=((D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen))]+D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen)+1)])*(stepLen-(xLoc-stepLen*(int)(xLoc/stepLen)))+(D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen))]+D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen)+1)])*(xLoc-stepLen*(int)(xLoc/stepLen)))/6000;
		yAccel+=((D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen))]+D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen))])*(stepLen-(yLoc-stepLen*(int)(yLoc/stepLen)))+(D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen)+1)]+D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen)+1)])*(xLoc-stepLen*(int)(xLoc/stepLen)))/6000;
		xLoc+=xVel*time;
		yLoc+=yVel*time;
		xVel+=xAccel*time;
		yVel+=yAccel*time;
		bounce();
		xVel*=0.99;
		yVel*=0.99;
		xAccel*=0.99;
		yAccel*=0.99;
		for (int i=0;i<this.projectiles.size();i++) {
			projectiles.get(i).loop(time);
		}
	}
        public int getColor(){
        int color=(int)(Math.random()*256*256*256);
        return color;}
        
        
        /**
         * it checks if there is an intersection between the 
         * projectile and an entity
         * It uses hardcoded values, which if we ever have an entity that is not 10 units or a projectile 
         * that is not 4 units, we're screwed (or just need to rewrite this)
         */
        public boolean intersect(ConcreteObject.Entity entity){
        
            if (this.owner==entity) {
                    //System.out.println("owner is entity (proj)");
				return false;
			}
             //System.out.print("Using Projectile detection method");
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
            if(intersect && this.owner!=entity) {
               // System.out.println("INTERSECT");
				//System.out.println(this.xLoc + ","+ this.yLoc);
			}
             return intersect;
        }
        
        public boolean intersect(ConcreteObject.Projectile projectile){
        //System.out.println("proj/proj");
            boolean intersect = false;
        return intersect;
        }
        /**
         * This method just removes the projectile from the field
         */
        public void kill(){
            this.owner.projectiles.remove(this);
        }
        /**
         * plasmaBomb intersection
         * @param entity 
         */
        public void kill(ConcreteObject.Entity entity){
		this.owner.projectiles.remove(this);	
        }
        /**
         * shrapnel intersection
         * @param you 
         */
        //public void kill(ConcreteObject.You you){
            
            
       //}
        

}