import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botonjugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botonjugar extends Actor
{
    private Space mimumdo;
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            mimumdo.inimundo(true);
            getWorld().removeObject(this);

        }  
    }

    public void addedToWorld(World world) {
        mimumdo = (Space) world;        
    }
}
