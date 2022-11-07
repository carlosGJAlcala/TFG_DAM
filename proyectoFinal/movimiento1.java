import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class movimiento1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class movimiento1 extends Actor
{
      
   boolean suelo;
    public void act() 
    {
   
    } 
       public void gravedad(int gravedad)
    {
        if(gravedad==-1){
            setLocation(getX()-1, getY());
        }
        if(gravedad==2){
            setLocation(getX()+4, getY()); 
        }
        if(gravedad==-2){
            setLocation(getX()-4, getY());
        }
    }
     
}
