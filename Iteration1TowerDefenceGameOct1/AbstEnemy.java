import greenfoot.*;
import java.util.*;

/**
 * Abstract Enemy Class
 * @author Rowbottom
 * @version 1.0
 */
public abstract class AbstEnemy extends Actor
{
      //enemy has
      Game world;//world reference
      protected int x, y, angle;//location
      protected ArrayList <Bullet> bullets;
      //health
      protected int health;
      //speed
      protected int speed;
      //damage
      protected int damage;
      //waypoints

    public void act(){
        world = (Game)getWorld();
        
    }
      
    //concrete method
    protected  void move(){
        move(speed);
    }
    
    //adding subclass
    
    
    //abstract methods
    protected abstract boolean checkHit();
    protected abstract void takeDamage();
    
}