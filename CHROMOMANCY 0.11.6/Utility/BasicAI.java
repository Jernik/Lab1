package Utility;

/**
 * This class is the basic AI class. it holds a collection of information about
 * the entity it is attached to, methods to update this data, and methods to
 * update its owner based on this data More specific AI's can extend this class
 * to override specific methods or to provide more information for a specific
 * entity
 *
 * @author Luke M
 */
public class BasicAI {

    /**
     * the entity that this AI is attached to
     */
    public ConcreteObject.Entity owner = null;
    /**
     * does the AI check for being in danger?
     */
    public boolean checkDanger, hostile;
    /**
     * whether or not the entity is in danger
     */
    public boolean inDanger = false;
    /**
     * whether or not the player is in range of this entity's sight
     */
    public boolean targetInRange = true;
    /**
     * the location of the nearest safe place
     */
    public float xLocSafe, yLocSafe;
    /**
     * firing cooldown
     */
    public int cooldown = 0;

    /**
     * Null constructor
     */
    public BasicAI() {
    }

    public void init() {
        //System.out.println("Initializing BasicAI");
    }

    /**
     * calls all AI methods
     */
    public void update() {
        if (checkDanger) {
            isInDanger();
        }
        if (inDanger) {
            findSafePlace();
        }
        //checkPlayerLoc();
        updateOwner();
        if (cooldown > 0) {
            cooldown--;
        }
    }

    /**
     * this method will check the surrounding plasma to see if there is a
     * concentration of similar colored plasma that will lead to dissolvement
     */
    public void isInDanger() {
    }

    /**
     * not entirely sure how this method will work, but it will find a place
     * that will not dissolve the entity. probably will be very close-range
     */
    public void findSafePlace() {
    }

    /**
     * this method will just use the distance formula to check the distance
     * between the player and the entity against the entity's sight value
     */
    public void checkTargetLoc(ConcreteObject.Entity target) {
        float distance = (float) Math.sqrt(
                Math.pow(this.owner.xLoc - target.xLoc, 2)
                + Math.pow(this.owner.yLoc - target.yLoc, 2));
        targetInRange = (distance <= this.owner.sight);
    }

    /**
     * updates the owner based on AI stuff, this will be a macro method
     */
    public void updateOwner() {
        doShootyStuff();
        if (inDanger && checkDanger) {
            moveToSafety();
        }
        if (!inDanger) {
            normalMovement();
        }

    }
    /**
     * does shooty stuff
     */
    public void doShootyStuff(){
         for (int i = 0; i < this.owner.D.map.entities.size(); i++) {
            checkTargetLoc(this.owner.D.map.entities.get(i));
            if (targetInRange && cooldown == 0 && checkHostile(this.owner,this.owner.D.map.entities.get(i))) {
                shootAtTarget(this.owner.D.map.entities.get(i));
            }
        }
        checkTargetLoc(this.owner.D.you);
        if (targetInRange && cooldown == 0 && hostile) {
                shootAtTarget(this.owner.D.you);
            }
    }
    /**
     * this method checks whether two entities are hostile to each other
     */
    public boolean checkHostile(ConcreteObject.Entity entity1, ConcreteObject.Entity entity2){
        return this.owner.D.hostility[entity1.teamTag][entity2.teamTag];
    
    }

    /**
     * this method will predict where the player will be if they continue on
     * their current vector and then calculate the xVelocity and yVelocity that
     * will hit that location in the time it calculates, it then will fire the
     * bullet. This may change to be a constant speed bullet and it calculates
     * what direction to fire it
     */
    public void shootAtTarget(ConcreteObject.Entity target) {
       float[] position = predictPosition(target);
        int[] vectors = calculateVectors(position);
        this.owner.fireBullet(vectors[0], vectors[1]);
        
        cooldown = 2000;
    }

    /**
     * this method will move(pathfind?) towards the nearest safe spot To find
     * this, it will probably need recursion to check every step of the path. 
     * I hate recursion.
     */
    public void moveToSafety() {
    }

    /**
     * this method calculates where the player will be in... 50
     * cycles(arbitrary) then returns an array of floats that is the player's
     * predicted location. BETTER TARGET METHOD USED NOW.
     *
     * @return {xLoc,yLoc}
     */
    public float[] predictPosition(ConcreteObject.Entity target) {
        float[] position = {0, 0};
        if (target.xVel != 0 || target.yVel != 0) {
            position[0] = target.xLoc + (target.xVel * 50);
            position[1] = target.yLoc + (target.yVel * 50);
        } else {
            position[0] = target.xLoc;
            position[1] = target.yLoc;
        }
        return position;
    }

    /**
     * this method calculates the vectors needed to hit the location found in
     * predictPosition() after 500 cycles(or exactly that) return {xVel,yVel}
     * BETTER TARGET METHOD USED NOW
     */
    public int[] calculateVectors(float[] position) {
        int[] vectors = {0, 0};
        vectors[0] = ((int) (position[0] - this.owner.xLoc) / 50);
        vectors[1] = (int) (position[1] - this.owner.yLoc) / 50;

        return vectors;
    }

    /**
     * this is what the entity does normally, ie. when it is not in danger
     */
    public void normalMovement() {
    }
}
