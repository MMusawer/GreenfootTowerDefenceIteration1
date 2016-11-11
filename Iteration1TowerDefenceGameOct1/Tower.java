import greenfoot.*;

/**
 * Basic Tower Superclass
 * 
 * @author (your name) 
 * @version 1 (Sept. 16 2016)
 */
public class Tower extends Actor
{
    /**
     * Tower Info:
     * Location (int, int)
     * Level / Upgrade (int)
     * Range (double)
     * Damage - (bullet -- bullet sublass)(double)
     * Rate of Fire (double)
     * Cost (int)
     * 
     * Tower Actions:
     * Attack / fire - (int angle)
     * Upgrade -
     *         void upgrade(); //upgrade by one level
     *         void changeStats(); //check what level upgrade, change stats
     * spawns (when mouseClicked, spawn)
     * getsDestroyed
     * aim
     *     int aim(){
     *     int aim     
     *          
     * Act - do whatever the Tower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //variables
    SimpleTimer fireTimer;
    int x = 0, y = 0; //location
    int level; //upgrade level
    double range; //range of attack
    double damage; //damage (might change to int)
    int bulletSpeed;
    double rateOfFire;
    int cost = 0;
  
    
    //constructors:
    public Tower(){
        //
        level = 1;
        range = 200; //was 200
        rateOfFire = 800; //changed from 1000
        bulletSpeed = 10;
        damage = 20;
        fireTimer = new SimpleTimer();
        fireTimer.mark();
        
    }
   
    public void act() 
    {
       //this updates the location of the tower
        x = getX();
        y = getX();     
        //check if bullet can be fired
        if (fireTimer.millisElapsed() >= rateOfFire){
            aim();
            fire(x, y);
            System.out.println("Fire");
        }
        //aim
    
      // Add your action code here.
    }    
    
    //methods
    
    private void aim() {
        //return 0;
        
    }
    
    private void fire(int angle){
        //
    
    }  
        
    private void fire(int x, int y){
            getWorld().addObject(new Bullet(45, (int)damage, (int)range, (int)bulletSpeed, this), x, y);
            fireTimer.mark(); //resets timer     
    }
    
    
}

