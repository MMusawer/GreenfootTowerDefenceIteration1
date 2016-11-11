import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Food is the end objective for the enemy ants. You are very famished and must protect your food in order to have a hope of fighting the enemy with your towers.
 * If too many ants reach your food, the enemy colony is notified and you will lose your food (and your hope!).
 * 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Food extends Actor
{
    int foodHealth = 30;

    int size = 60; //dimension of icon

    ArrayList <Enemy> enemiesReached;

    public Food() { //basic constructor for food
        GreenfootImage img = getImage();
        img.scale(size,size);
        setImage(img);

    }

    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        Game temp = (Game)getWorld();                       
        takeDamageFood();
    }    

    public void takeDamageFood(){
        World temp;
        temp = getWorld();
        enemiesReached = new ArrayList <Enemy>(getIntersectingObjects(Enemy.class));

        if (enemiesReached.size() > 0) { //if there are intersecting enemies in the arraylist, then:
            Enemy e = enemiesReached.get(0);
            foodHealth -= e.damage;
            Greenfoot.playSound("impact.wav");
            enemiesReached.remove(e);
            if (temp != null) { //if the enemy has not already been removed:
                getWorld().removeObject(e);
            }
            System.out.println(foodHealth);
            //hile 

        }
        if (foodHealth <= 0) {
            getWorld().removeObject(this);
            //Game.money = -1000; //placeholder way to end the game
            System.out.println("YOU LOSE. RESET NOW.");
            Greenfoot.stop();
        }
    }
}
