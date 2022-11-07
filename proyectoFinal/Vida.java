import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Valores
{
    int vida=3;
    public void act() 
    {   
        if(vida==0||vida<0){
            getWorld().removeObject(this);
        }
        else{
            if(vida==3){
                setImage("corazon3.png");
            }
            if(vida==2){
                setImage("corazon2.png");
            }
            if(vida==1){
                setImage("corazon1.png");
            }
        }
    } 

    public void restarvida(){
        vida=vida-1;
    }

    public void restablecer(){
        vida=3;
    }
}
