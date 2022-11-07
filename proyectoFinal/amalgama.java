import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class amalgama here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class amalgama extends Enemigo
{   
    int vida =100;
    int mover;
    public amalgama(int mover, int velocidad){
        if(velocidad<5){
            this.mover=velocidad*mover;
        }
        else{
            this.mover=5*mover;
        }
    }

    public void act() 
    {
        movimiento(mover);
    } 

    public void muerte(){
    }
}
