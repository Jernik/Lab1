package ConcreteObject;

/**
 *
 * @author Luke M
 */
public class SmallBullet extends EnemyBullet{
    
    public void draw(java.awt.image.DataBuffer buffer) {
		if (!killed) {
			int color=getColor();
			for (int j=0;j<4;j++) {
				for (int i=0;i<4;i++) {
					int x=(int)(i+this.xLoc-1f);
					int y=(int)(j+this.yLoc-1f);
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
    
}
