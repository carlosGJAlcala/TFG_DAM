import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends movimiento1
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int vida =100;
    int dir =1;
    public Space mimumdo;
   GreenfootImage muerte = new GreenfootImage("exploxion.png") ;
    public void movimiento (int mover){
        Actor heroe=(Actor)getOneIntersectingObject(Heroe.class);
        Heroe miheroe=(Heroe)heroe;
        if(getX()==0){
            getWorld().removeObject(this);
        }
        else {
            if(vida==0||vida<0){
                mimumdo.insertarnum(1);
                setImage(muerte);
                getWorld().removeObject(this);

            }else{
                if(heroe!=null){
                    miheroe.dano(1);
                    getWorld().removeObject(this);
                }
                else{
                    if(isAtEdge()){
                        dir= dir *-1;
          
                    }

                    setLocation(getX(), getY()+mover*dir);
                    gravedad(-2);

                }

            }
        }
    }

    public void addedToWorld(World world) {
        mimumdo = (Space) world;        
    }

    public void setLocation(int x, int y)
    {
        int oldX = getX();
        int oldY = getY();
        super.setLocation(x, y);
        if(!getIntersectingObjects(cubo.class).isEmpty())
        {
            super.setLocation(oldX, oldY);

        }
    }    

    public void  dano(int resta){

        this.vida= vida-resta;
    }

}
