import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{   
    int ronda=1;
    boolean empezar=false;
    boolean mundo1=false;
    int carga=0;
    int modulo=5;
    int puntos =0;

    Random  numal = new Random ();
    Heroe miheroe;
    GreenfootSound music = new GreenfootSound("music.mp3");
    Vida vidaheroe = new Vida();
    GreenfootImage background ;
    Puntos unidades= new Puntos();
    Puntos decenas= new Puntos();
    Puntos centenas = new Puntos();
    Puntos millares= new Puntos();
    botonjugar jugar= new botonjugar();

    public void mundo0(){
    }

    public Space()
    {    
        super(1000, 563, 1); 

        addObject(jugar, getWidth()/2-20 ,getHeight()/2 +100);
    }

    public  void inimundo(boolean valor) {
        mundo1=valor;
        if(valor){
            empezar=true;
            miheroe= new Heroe();
            vidaheroe.restablecer();
            addObject(unidades, getWidth()-40,50);
            addObject(decenas, getWidth()-80,50);
            addObject(centenas, getWidth()-120,50);
            addObject(millares, getWidth()-160,50);
            addObject(vidaheroe, 150,50);
            addObject(miheroe, 50,100);
            //insertar fondo aleatorio cada vez que se pulsa el botón
            int i = numal.nextInt(3);
            background= new GreenfootImage("escenario"+i+".png");
            setBackground(background);

        }
        else{
            empezar=false;
            music.stop();
            ronda=1;
            puntos =0;
            insertarnum(0);
            removeObject(unidades);
            removeObject(decenas);
            removeObject(centenas);
            removeObject(millares);  
            removeObject(vidaheroe); 
            removeObjects(getObjects(cubo.class));
            removeObjects(getObjects(Enemigo.class));
            removeObjects(getObjects(bala.class));
            addObject(jugar, getWidth()/2-20 ,getHeight()/2 +100);
            background= new GreenfootImage("fondocarga.jpg");
            setBackground(background);

        }
    }

    public boolean estadoMundo(){
        return mundo1;
    }

    public void ronda(int puntronda){
        ronda=ronda+puntronda;
    }

    public Vida muestravida()
    {
        return vidaheroe;
    }

    public void insertarnum( int sumpuntos){
        puntos = puntos+sumpuntos;

        int punmillares=puntos/1000;
        millares.sumapuntos(punmillares);

        int puncentenas=(puntos-(punmillares*1000))/100;
        centenas.sumapuntos(puncentenas);

        int pundecenas=(puntos- (punmillares*1000 + puncentenas*100))/10;
        decenas.sumapuntos(pundecenas);

        int pununidades=puntos-(punmillares*1000 + puncentenas*100 + pundecenas*10 );
        unidades.sumapuntos(pununidades);
    }

    public void act(){
        if(mundo1){
            buclemundo1();
        }
    }

    public void started(){

    }

    public void stopped()
    {
        empezar = false;
        music.stop();
    }

    public void buclemundo1(){
        /*
        background= new GreenfootImage("escenario0.png");
        setBackground(background);

        if(ronda==3&&ronda<6){
        background = new GreenfootImage("escenario1.png");
        setBackground(background);

        }
        if(ronda>=6){
        background= new GreenfootImage("escenario2.png");
        setBackground(background);

        }*/
        if(empezar){
            music.playLoop(); 
        }else
            music.stop();
        if(getObjects(amalgama.class).isEmpty()){
            ponerenemigos(ronda);
        }
        if(getObjects(cubo.class).isEmpty()){
            ponerbloques(ronda);
        }

    }

    public void ponerbloques( int numero){
        for(int i=0;i<3;i++){

            addObject(new cubo(),getWidth()-Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(getHeight()));
        }
    }

    public void ponerenemigos( int numero){

        if (numero <10){

            for(int i =0 ;i<numero ;i++){
                if(i%2==0){

                    modulo=-1;
                    addObject(new amalgama(modulo,ronda),getWidth()-Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(getHeight()));

                }
                else{
                    modulo=1;
                    addObject(new amalgama(modulo,ronda),getWidth()-Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(getHeight()));
                }

            }
            ronda(1);
        }
        else{
            for(int i =0 ;i<10 ;i++){
                if(i%2==0){

                    modulo=-1;
                    addObject(new amalgama(modulo,ronda),getWidth()-Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(getHeight()));

                }
                else{
                    modulo=1;
                    addObject(new amalgama(modulo,ronda),getWidth()-Greenfoot.getRandomNumber(100), Greenfoot.getRandomNumber(getHeight()));
                }

            }
            ronda(1);
        }
    }
}

