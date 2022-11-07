import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puntuacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puntos extends Valores
{
    int puntos=0;
    String[] imagenes={"0.png","1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png"};
    public void act() 
    {

        setImage(imagenes[puntos]);

    }  

    public int getpuntos(){
        return puntos;
    }

    public void sumapuntos(int nuevospuntos){
        puntos= nuevospuntos;
    }
}
