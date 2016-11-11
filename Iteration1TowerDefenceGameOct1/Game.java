import greenfoot.*;
import java.util.*;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends World
{

    //creating objects (not in game yet)
    ArrayList <Waypoint> path;
    Tower BasicTower;
    Enemy BasicEnemy;
    MouseInfo mouse;

    //important variables 
    int start = 0; //int for determining when enemy spawning begins. When the first tower is placed, start is equal to 1 and the enemies are added
    public static int money = 30; //starting value for the money the player has. Money is spent on towers
    double limitEnemy = 1;

    SimpleTimer spawnDelay1;

    /**
     * Constructor for objects of class Game.
     * 
     */
    public Game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1, true); 
        path = new ArrayList <Waypoint>();
        makePath();
        //mouse = Greenfoot.getMouseInfo();
        //         BasicTower = new Tower();
        //         addObject(BasicTower, 50, 50);
        mouse = Greenfoot.getMouseInfo();

        // mouse.getMouseInfo();
        //addObject(new AimingTower(), 100, 100);
        //BasicEnemy = new Enemy(path);
        addObject(new Food(), 675, 40); //adding the food / endgame object

        //addObject(new Heavy(), path.get(0).x, path.get(0).y);
        //addObject(new Enemy(path), path.get(0).x - 5, path.get(0).y);
        spawnDelay1 = new SimpleTimer();

        setPaintOrder(Enemy.class, Tower.class, Bullet.class, Waypoint.class); //setting order of placing the image of objects, first is "above" layer of next class named
        //         for (int i = 1; i < 5; i++) {
        //         addObject(BasicEnemy, i * 50, i * 150);
        //     }

        //adding waypoints

        //public void makePath() {

        //TEXT
        //the coordinaates are at the centre of the actor    
        //image.drawRect(75, 25, 15, 5);
        //getBackground().drawString(money, 50, 25);

        // addObject(Waypoint, 10,10);
        for (Waypoint w: path) {
            addObject (w, w.x, w.y);

        }

        //}
    }

    public void makePath(){
        path.add(new Waypoint(25, 200));
        path.add(new Waypoint(75, 200)); //add 50 to move right
        path.add(new Waypoint(125, 200));
        path.add(new Waypoint(175, 200));
        path.add(new Waypoint(225, 200));
        path.add(new Waypoint(225, 250));
        path.add(new Waypoint(225, 300));
        path.add(new Waypoint(275, 300));
        path.add(new Waypoint(325, 300));
        path.add(new Waypoint(375, 300));
        path.add(new Waypoint(375, 250));
        path.add(new Waypoint(375, 200));
        path.add(new Waypoint(375, 150));
        path.add(new Waypoint(375, 100));
        //path.add(new Waypoint(275, 10));
        path.add(new Waypoint(425, 100));
        path.add(new Waypoint(475, 100));
        path.add(new Waypoint(525, 100));
        path.add(new Waypoint(525, 150));
        path.add(new Waypoint(525, 200));
        path.add(new Waypoint(525, 250));
        path.add(new Waypoint(525, 300));
        path.add(new Waypoint(525, 350));
        path.add(new Waypoint(575, 350));
        path.add(new Waypoint(625, 350));
        path.add(new Waypoint(675, 350));
        path.add(new Waypoint(675, 300));
        path.add(new Waypoint(675, 250));
        path.add(new Waypoint(675, 200));
        path.add(new Waypoint(675, 150));
        path.add(new Waypoint(675, 100));
    }

    public void addEnemy() { //method for adding a tower based on mouseInfo
        MouseInfo mouse;
        mouse = Greenfoot.getMouseInfo();
        // String key = Greenfoot.getKey();
        //int newX = mouse.getX();
        //int newY = mouse.getY();
        if (Greenfoot.isKeyDown("e") && Greenfoot.mouseClicked(null)){
            int newX = mouse.getX();
            int newY = mouse.getY();
            //  if (ableToSpawn()){
            addObject(new Enemy(path), newX, newY);
            //}

        }
    } 

    public void addAimingTower() { //method for adding a tower based on mouseInfo
        MouseInfo mouse;
        mouse = Greenfoot.getMouseInfo();
        // String key = Greenfoot.getKey();
        //int newX = mouse.getX();
        //int newY = mouse.getY();
        if (money >= 10) {
            if (Greenfoot.isKeyDown("a") && Greenfoot.mouseClicked(null)){
                int newX = mouse.getX();
                int newY = mouse.getY();
                //  if (ableToSpawn()){

                int numAiming = getObjects(AimingTower.class).size(); //find number of towers
                addObject(new AimingTower(), newX, newY);
                // if (isTouching(AimingTower.class) || isTouching(Waypoint.class)) {
                // getWorld().removeObject(this);
                // }

                // if (getAimingTower().canSpawn())
                //int numAiming2 = getObjects(AimingTower.class).size(); //find number of towers again
                //if (numAiming2 > numAiming){
                start++;
                money = money - 10;
                System.out.println("AimingTower built -10, Money: " + money);
                //}
                //}
                //}
                //    
                //         
                //     }
                // }
            }
        }

    } 

    public void act(){
        if (start > 0) { //if at least one tower has been placed, begin spawning enemies
            enemySpawn();
        }
        addEnemy();

        addAimingTower();
    }

    //methods

    public void enemySpawn(){ //method for spawning enemy objects if there are less of them than the limit stated
        int numEnemy = getObjects(Enemy.class).size(); //find number of enemies

        limitIncrease();
        //double l = limitEnemy * 3;

        if (numEnemy < limitEnemy) { //if there are less enemies than the enemy limit, then spawn another
            if (spawnDelay1.millisElapsed() > 2000) {
                addObject(new Enemy(path), path.get(0).x -5, path.get(0).y);
                spawnDelay1.mark();
            }
        }
    }

    public void limitIncrease(){
        double l = limitEnemy * 4;

        int numTower = getObjects(AimingTower.class).size();

        if (numTower > 2) {
            if (money >= l) {
                limitEnemy += 1;
                System.out.println("Limit of enemy: " + limitEnemy);
            }
            //else {
            //  return; }

        }
        //public void addEnemy

        //     private void spawn() {
        //         for (int i = 0; i < 5; i++) {
        //         addObject(BasicEnemy, i * 50, 150);
        //     }        
        //     }

        /*private static void spawn(){
        if  (Greenfoot.mouseClicked(this)){
        addObject(BasicTower, getX, getY);
        }
        } */
    }
}
