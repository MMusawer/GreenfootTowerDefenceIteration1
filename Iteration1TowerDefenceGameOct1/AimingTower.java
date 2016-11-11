import greenfoot.*;
import java.util.*;

/**
 * 
 * Write a description of class AimingTower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AimingTower extends Tower
{
    Enemy target; //local reference 
    int firingAngle;
    GreenfootSound fire = new GreenfootSound("fire.wav"); //creating fire sound for when an AimingTower shoots
    boolean canSpawn;

    /**
     * Act - do whatever the AimingTower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        //super.act();
        //update position
        x = getX();
        y = getY();

        Game temp = (Game)getWorld(); 
        //if (temp == null) {
          //  return;
        ///}
        //addAimingTower();
        aim();
        if (target != null && fireTimer.millisElapsed() >= rateOfFire){ 
            fire(firingAngle);
            //fire.setVolume(50);
            target = null; //after firing once, reset the target\
            Greenfoot.playSound("fire.wav"); //plays soound
            //fire.play(); //other method to play sound, however plays every other shot
        }

        if (isTouching(Waypoint.class)) {
            getWorld().removeObject(this);
        }

        //if (isTouching(AimingTower.class) || isTouching(Waypoint.class)) {
        //    getWorld().removeObject(this);
        //}
        //fire with angle   

        // Add your action code here.
    }    

    //if target is null
    //get a target reference
    //TurnTowards target.x, target.y
    //return this.getRotation()
    protected void fire(int angle){
        getWorld().addObject(new Bullet(angle, (int)damage, (int)range, bulletSpeed, this), x, y);      
        fireTimer.mark(); //resets timer    

    }

    public boolean canSpawn() {
        if (isTouching(AimingTower.class) || isTouching(Waypoint.class)) {
            return false;
        } else {
            return true; }
        //getWorld().removeObject(this);

    }

    protected void aim(){
        //if target is null    
        if (target == null) {
            int targetDist = 85; //this is the distance that is being searched
            while(target == null && targetDist <= range) {
                //try to get an enemy in range
                //if 
                ArrayList <Enemy> enemies = new ArrayList<Enemy>(getNeighbours(targetDist, true, Enemy.class));
                if (enemies.size() >= 1) {
                    target = new ArrayList<Enemy>(getNeighbours(targetDist, true, Enemy.class)).get(0);
                }
                //increase search distance
                targetDist += 15;
            }
            //         if (target == null) {
            //             break;
            //         }
        }
        //      if (target.getWorld() == null) { 
        //         return;
        //      }
        if (target != null){ //if there is a target located
            if (target.getWorld() != null ) { //if the target's world still exists (i.e it is not removed)
                turnTowards(target.getX(), target.getY()); //turn towards target's location)
                firingAngle = this.getRotation();

            }
        }
    }

    //     public boolean ableToSpawn() {
    //         MouseInfo mouse;
    //         mouse = Greenfoot.getMouseInfo();
    //         int newX = mouse.getX();
    //         int newY = mouse.getY();
    //         //return ((mouse.getX) !(isTouching(Waypoint.class)) || !(isTouching(AimingTower.class)));
    //         if(mouse != null && getObjectsAt(mouse.getX(), mouse.getY(), AimingTower.class)){
    //            return true; 
    //             
    //         }
    //     }

    //     public void addAimingTower() { //method for adding a tower based on mouseInfo
    //         MouseInfo mouse;
    //         mouse = Greenfoot.getMouseInfo();
    //         // String key = Greenfoot.getKey();
    //         //int newX = mouse.getX();
    //         //int newY = mouse.getY();
    //         if (Greenfoot.isKeyDown("a") && Greenfoot.mouseClicked(null)){
    //             int newX = mouse.getX();
    //             int newY = mouse.getY();
    //             //  if (ableToSpawn()){
    //             getWorld().addObject(new AimingTower(), newX, newY);
    //             //}
    //             //    
    //             //         
    //             //     }
    //             // }
    // 
    //         }
    // 
    //     } 

    //     } 
}
