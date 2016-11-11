import greenfoot.*;

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //willthisSAVE??s
    int x, y;
    int angle; ////data from tower via constructor
    int range; //data from tower via constructor
    int speed; ////data from tower via constructor
    int damage; //data from tower via constructor
    int distTravelled;
    Tower tower;
    //turn(angle);
    
    public Bullet(){
        
        
    }
    
    
    public Bullet(int a, int d, int r, int s, Tower t){
        angle = a;
        damage = d;
        range = r;
        speed = s;
        distTravelled = 0;
        turn(angle);
        tower = t;
    }
        
    public void act() 
    {
        // Add your action code here.
        move(speed);
        distTravelled += speed; //adds distance travelled to counter for each fram
        if (distTravelled >= range){
            getWorld().removeObject(this); //this removes the bullet from world            
        }
        //check if it's gone far enough (/ reached its range)
        
    }    
}
