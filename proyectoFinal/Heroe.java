import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends movimiento1
{
    
    private Space mimumdo;
    int gravedad=1;
    int vida = 3;
    int carga =0;
    bala mibala;
    Vida  vida2;
    public void act() 
    {
        vida2=mimumdo.muestravida();
        mibala=new bala(20);
        controles();
    } 

    public void controles()
    {
        if(vida<0|| vida == 0) {
            getWorld().removeObject(this);
            mimumdo.inimundo(false);
        }else{
            if(Greenfoot.isKeyDown("D")) {
                move(4);
            }
            if(Greenfoot.isKeyDown("A")) {
                move(-4);
            }
            if(Greenfoot.isKeyDown("W")) {
                setLocation(getX(), getY()-2);
            }   

            if(Greenfoot.isKeyDown("S")) {
                setLocation(getX(), getY()+2);
            }
            if(Greenfoot.isKeyDown("F")){
                if(carga<5)
                    carga++;
                gravedad(gravedad);
                if(carga==5){
                    carga=0;
                    Greenfoot.playSound("disparo.mp3");

                    getWorld().addObject(mibala, getX(), getY());

                } 
            }
            else{
                gravedad=-1;
                gravedad(gravedad);
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
            suelo=true;
        }
    }

    public void  dano(int resta){

        this.vida= vida-resta;
        vida2.restarvida();

    }
}
