import greenfoot.*;

/**
 * Write a description of class Waypoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waypoint extends Actor
{
    /**
     * Act - do whatever the Waypoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    //image change
    
   // if (Waypoint.getWorld()==null){
       
            
        
    //}
    
    int x, y;
    //x = 100;
    int size = 50;
    
    public Waypoint(int wx, int wy) {   
        this.x = wx;
        this.y = wy;
        GreenfootImage img = getImage();
        img.scale(size, size);
        setImage(img);
        //getImage(this).transparency = 5;
        
    }
    
    
    
    public void act() 
    {
        // Add your action code here.
        x = this.getX();
        y = this.getY();
        
    }    
}
