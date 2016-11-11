import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends AbstEnemy
{
    // enemy info

    //sounds
    GreenfootSound impact = new GreenfootSound("impact.wav");
    //location
    int x, y; 
    int angle;
    //
    //waypoint tracking
    ArrayList <Waypoint> path;
    Waypoint current;
    int step = 0;
    //int current = 0;

    ArrayList<Bullet> bullets;

    // hitpoints
    int health;

    // speed
    int speed;

    // damage?
    int damage;

    int size = 15;
    // waypoints (index of array

    public Enemy() {
        GreenfootImage img = getImage();
        img.scale(size,size);
        setImage(img);
        health = 100;
        angle = 0;
        speed = 5;
        damage = 10;
        //int h = getEnemy.health();

    }

    public Enemy(ArrayList <Waypoint> p) {
        GreenfootImage img = getImage();
        img.scale(size,size);
        setImage(img);
        path = p;
        health = 100;
        angle = 0;
        speed = 2;
        damage = 10;
        step = 0;
        current = path.get(step);
        //int h = getEnemy.health();

    }

    public int getHealth() {
        //
        return this.health;  
    } 

    //     public void addEnemy() { //method for adding a tower based on mouseInfo
    //         MouseInfo mouse;
    //         mouse = Greenfoot.getMouseInfo();
    //         // String key = Greenfoot.getKey();
    //         //int newX = mouse.getX();
    //         //int newY = mouse.getY();
    //         if (Greenfoot.isKeyDown("e") && Greenfoot.mouseClicked(null)){
    //             int newX = mouse.getX();
    //             int newY = mouse.getY();
    //             //  if (ableToSpawn()){
    //             getWorld().addObject(new Enemy(path), newX, newY);
    //             //}
    // 
    //         }
    //     } 

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //addEnemy();
        Game temp = (Game)getWorld();                       
        //addEnemy();
        takeDamage();

        //    if (checkHit()){
        //        takeDamage();
        if (health <= 0 && temp != null) {
            //getAimingTower().target = null;
            temp.removeObject(this);
            //             return;

        }      
        move();
        //check if no life
        //if yes remove      
        //}

    }

    public void nextWaypoint(){

        if (step < path.size()){
            current = path.get(step);
            turnTowards(current.x, current.y);
            //} 
            //else {
            //getWorld().removeObject(this);
        }

    }

    public void move(){
        //         if (health <= 0) {
        //             //getAimingTower().target = null;
        //             getWorld().removeObject(this);
        //             return;
        // 
        //         }
        //         if (isAtEdge()){
        //             turn(90);   
        //         }
        move(speed);  
        if (getWorld() == null){
            return;
        }
        if ((Math.abs(getX() - current.x) <= speed) && (Math.abs(getY() - current.y) <= speed)) {
            step++;
            nextWaypoint();            

        }

    }

    public boolean checkHit(){
        return isTouching(Bullet.class);
    }

    public void takeDamage(){
        World temp;
        temp = getWorld();
        bullets = new ArrayList <Bullet>(getIntersectingObjects(Bullet.class));

        if (checkHit()){
            //health -= damage;

        }
        //System.out.println(bullets);
        if (bullets.size() > 0) { //if there are intersecting bullets in the arraylist, then:
            Bullet b = bullets.get(0);
            health -= b.damage;
            Greenfoot.playSound("impact.wav");
            bullets.remove(b);
            if (temp != null) {
                getWorld().removeObject(b);
            }
            System.out.println(health);
            //hile 

        }
        if (health <= 0) {
            getWorld().removeObject(this);
            Game.money += 5; //give 5 money to player for destroying enemy
            System.out.println("Enemy destroyed +5, Money: " + Game.money);
        }

    }

    //enemySpawns
    //moves
    //enemyRemove

}
