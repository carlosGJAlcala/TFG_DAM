import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemigo
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      movimiento();
    }
    int mover=5;
      public void movimiento(){
        Actor heroe=(Actor)getOneIntersectingObject(Heroe.class);
        Heroe miheroe=(Heroe)heroe;
        if(getX()==0||vida==0||vida<0){
          
            getWorld().removeObject(this);
            
        }else{
            if(heroe!=null){
                miheroe.dano(1);
                getWorld().removeObject(this);
            }
            else{
                if(isAtEdge()){
                    mover=mover*-1;
                    setLocation(getX(), getY());
                }

                setLocation(getX(), getY()+mover);
        

            }

        }
    }
}
