import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bala extends movimiento1
{
    int dir=1;
    // boolean disparo
    public bala(int dir){
        this.dir=dir;

    }

    public void act() 
    {      
        Actor actor = getOneIntersectingObject(cubo.class);
        Actor actor1=getOneIntersectingObject(Enemigo.class);
        Enemigo mienemigo=(Enemigo)actor1;

        if(isAtEdge()){
            getWorld().removeObject(this);

        }else{ 

            if(mienemigo!=null){
                mienemigo.dano(20);
                getWorld().removeObject(this);
            }else{
                if(actor!=null){
                    getWorld().removeObject(this);
                }
                else{
                    moviendo(); 
                }
            }
        }

    }

    public void moviendo(){
       // gravedad(-1);
        move(dir);

    }

}
