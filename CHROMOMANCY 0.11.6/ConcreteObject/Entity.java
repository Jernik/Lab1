package ConcreteObject;

/**
* This is the super class for everything that is not a projectile.
* Among these are NPCs and enemies.
*/
import java.awt.Rectangle;
public class Entity extends DynamicObject {

	/**
	* Whether or not this entity is firing plasma
	*/
	public boolean firing=false;
        public int blueXP,greenXP,redXP;
        public String name=null;
        public int teamTag=0;
        public int resistance;//the lower this number, the closer the plasma has to be to dissolve an entity
        
        /**
         * how far this entity can see
         */
        public int sight=0;

	/**
	* Null constructor. For initialization, psudoconstructors must be used.
	*/
	public Entity() {}
	/**
	* {@inheritdoc}
	*/
	public void draw(java.awt.image.DataBuffer buffer) {
		int color=this.red*256*256+this.green*256+this.blue;
		if (!killed) {
			for (int j=0;j<10;j++) {
				for (int i=0;i<10;i++) {
					int x=(int)(i+this.xLoc-5f);
					int y=(int)(j+this.yLoc-5f);
					if (!(x<0 || x>799 || y<0 || y>799)) {
						buffer.setElem(800*y+x,color);
					}
				}
			}
		}
		for (int i=0;i<this.projectiles.size();i++) {
			this.projectiles.get(i).draw(buffer);
		}
		if (this.saying!=null) {
			String s=this.saying.talk.toUpperCase();
			int x=(int)this.xLoc-s.length()*3;
			int y=(int)this.yLoc-16;
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
		xLoc+=xVel*time;
		yLoc+=yVel*time;
		xVel+=xAccel*time;
		yVel+=yAccel*time;
		xAccel+=((D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen))]+D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen)+1)])*(stepLen-(xLoc-stepLen*(int)(xLoc/stepLen)))+(D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen))]+D.field.xVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen)+1)])*(xLoc-stepLen*(int)(xLoc/stepLen)))/6000;
		yAccel+=((D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen))]+D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen))])*(stepLen-(yLoc-stepLen*(int)(yLoc/stepLen)))+(D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen),(int)(yLoc/stepLen)+1)]+D.field.yVel[DisplayObjects.FluidSolver.IX((int)(xLoc/stepLen)+1,(int)(yLoc/stepLen)+1)])*(xLoc-stepLen*(int)(xLoc/stepLen)))/6000;
		bounce();
		xVel*=0.99;
		yVel*=0.99;
		for (int i=0;i<this.projectiles.size();i++) {
			projectiles.get(i).loop(time);
		}
	}
	/**
	* {@inheritdoc}
	*/
	public void emit(DisplayObjects.FluidField field) {}
        
        /**
         * filler method
         * a way to check if two entities are colliding
         */
        public boolean intersect(ConcreteObject.Entity entity2){
         System.out.println("Really? this is being called?");
            boolean intersect=false;
        return intersect;
        }
        /**
         * also a filler, this checks if an entity and a projectile are colliding 
         * 
         * @param proj
         * @return 
         */
        //TODO yeah, both of these too
        public boolean intersect(ConcreteObject.Projectile proj){
            System.out.println("Really? this is being called?");
            boolean intersect=false;
            return intersect;
        }
        
        public void fireBullet(int xVel, int yVel){
            ConcreteObject.EnemyBullet b = new ConcreteObject.EnemyBullet();
            b.Displacement((float)xLoc,(float)yLoc);
            b.Color(this.red,this.green,this.blue);
            b.xVel=xVel;
            b.yVel=yVel;
            b.owner=this;
            b.D=this.D;
            this.projectiles.add(b);
        }

}