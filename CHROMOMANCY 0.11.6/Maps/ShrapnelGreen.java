/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maps;

/**
 *
 * @author Administrator
 */
public class ShrapnelGreen extends ConcreteObject.Shrapnel{
    int greenXP=1;
    /**
     * Null constructor
     */
    public ShrapnelGreen(){}
    
     public int getColor(){
    this.red=0;
    this.blue=0;
    this.green=(int)(Math.random()*150)+105;
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
