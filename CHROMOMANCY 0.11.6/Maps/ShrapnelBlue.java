package Maps;

/**
 *
 * Default Blue Shrapnel/Shard
 */
public class ShrapnelBlue extends ConcreteObject.Shrapnel{
    int blueXP=1;
    /**
     * Null Constructor
     */
    public ShrapnelBlue(){}
    
    public int getColor(){
    this.red=0;
    this.blue=(int)(Math.random()*150)+105;
    this.green=0;
    int color=this.red*256*256+this.green*256+this.blue;
    return color;
    }
    public void kill(){
    this.owner.projectiles.remove(this);
    }
    public void kill(ConcreteObject.Entity entity){
    this.D.you.blueXP+=this.blueXP;
        this.D. you.greenXP+=this.greenXP;
        this.D.you.redXP+=this.redXP;
       
        this.owner.projectiles.remove(this);
    }
}
