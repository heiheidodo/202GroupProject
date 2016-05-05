import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goro extends Figure implements IFighter, IGangster
{
   int current_motion_index = 0;
    int moveSpeed = 3;
    int moveVariable = 0;
    int moveStepLength = 3;
    private boolean opening = true;
    public GreenfootImage[] moveSet, openingSet, punchSet, Blood;
    private BruceLee bruce;
    
    public Goro()
    {
         openingSet = new GreenfootImage[15];
         for (int i = 0; i < openingSet.length; i++)
        {
            int m = i + 1;
            
            GreenfootImage img = new GreenfootImage("Gorosprite_f" + m + ".gif");
          //  System.out.println("Gorosprite x is: " + img.getWidth() + "Gorosprite y is: " + img.getHeight());
            img.scale(img.getWidth() - 100, img.getHeight() - 143);
            openingSet[i] = img;
           
        }
        
        moveSet = new GreenfootImage[6];
        for (int i = 0; i < moveSet.length; i++)
        {
                 
            GreenfootImage img = new GreenfootImage("goroRunLeft_" + i +".gif");
           // System.out.println("GoroRun x is: " + img.getWidth() + "GoroRun y is: " + img.getHeight());
            //img.scale(img.getWidth(),img.getHeight());
            moveSet[i] = img;
           
        }
        
        punchSet = new GreenfootImage[10];
        for (int i = 0; i < punchSet.length; i++)
        {
            
            GreenfootImage img = new GreenfootImage("goroPunchToLeft_" + i +".gif");
            img.scale(img.getWidth() - 100,img.getHeight() - 143);
            punchSet[i] = img;
           
        }
        
        this.currentMotionSet = openingSet;
        this.setCurrentPose(Figure.POSE_STAND);
  /*      for(int i = 0; i < 7; i++)
        {  
            Blood[i] = new GreenfootImage("rightblood" + i +".png");
        }
     
        for(int i = 0; i < 6; i++)
        {
            Left[i] = new GreenfootImage("goroRunLeft_" + i +".gif");
            Right[i] = new GreenfootImage("Gororun_" + i +".gif");
            DRight[i] = new GreenfootImage("Gororighthit_" + i +".gif");
            DLeft[i] = new GreenfootImage("Gororighthit_" + i +".gif");
        }
        
        for(int i = 0; i < 10; i++){
            PRight[i] = new GreenfootImage("goroPunchToRight_" + i +".gif");
            PLeft[i] = new GreenfootImage("goroPunchToLeft_" + i +".gif"); 
        }*/
    
    }
      
    /**
     * Act - do whatever the Goro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    /*    move();
        bruceLee();
        death(die);
        */
       goroShowup();
    }
    
    private void goroShowup(){
       if (opening)
        {
            goroInit();
        }
        else
        {
            lookForMainCharacter();
        }
    }
    
    public void goroInit()
    {
        //Greenfoot.delay(5);
        for(int i=0; i<15; i++){
            
            if(current_motion_index >= currentMotionSet.length) {
                    current_motion_index = 0;
            }
                    setImage(currentMotionSet[current_motion_index]); 
            if(current_motion_index == currentMotionSet.length - 1){
                    current_motion_index = 0;
            }else{
                    current_motion_index++;
            //        Greenfoot.delay(5);
            }
            if(current_motion_index>=14){
                opening = false;  
                break;
            }
        }
    } 
    
    
    public void runToMainCharacter(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = moveSet;
        if(current_motion_index >= currentMotionSet.length)
            current_motion_index = 0;
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1){
            current_motion_index = 0;
        }else{
            current_motion_index++;
            setLocation(this.getX()-moveStepLength,this.getY());
        //    Greenfoot.delay(5);
        }
    }
    public void lookForMainCharacter(){
    /*    if(moveVariable < moveSpeed){
            moveVariable++;
            return;
        }else{
            moveVariable = 0;
        } */
        setLocation(this.getX(),340);
        if(bruce == null){
           bruce= this.getWorld().getObjects(BruceLee.class).get(0);
        }
        if(this.getX()-50 > bruce.getX()){
           runToMainCharacter(); 
        }else{
           punch();
        }

    }
    
    public void onAttacked(int damage){
    
    }

    
    public int punch(){
        if(moveVariable < moveSpeed){
            moveVariable++;
            return 0;
        }else{
            moveVariable = 0;
        }
        //step to next motion
        this.currentMotionSet = punchSet;
        if(current_motion_index >= currentMotionSet.length)
            current_motion_index = 0;
        setImage(currentMotionSet[current_motion_index]);
        if(current_motion_index == currentMotionSet.length - 1){
            current_motion_index = 0;
        }else{
            current_motion_index++;
            setLocation(this.getX(),this.getY());
        }
        return 0;
    }
    
    
    
    
    
    /**
    * This method hit, It checks if goro is attacked.
    */   
    public void hit()
    {

    /*    damage++;
        death(0);
        */
    }
    
    
     /**
    * This method death, It checks to see if the damage to goro is
    *                    above 6 hits, and calls to GoroExploding.
    */
    public void die()
    { 
       
    }
    
    public int kick(){
        return 0;
    }
    public int defend(){
        return 0;
    }

}
