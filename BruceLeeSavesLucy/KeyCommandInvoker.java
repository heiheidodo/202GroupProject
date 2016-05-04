import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyCommandInvoker here.
 * 
 * @author (Ming Tang) 
 * @version (a version number or a date)
 */
public class KeyCommandInvoker extends Actor
{
    private IKeyCommand leftCommand,rightCommand,upCommand,downCommand,aCommand,sCommand;
    /**
     * Act - do whatever the KeyCommandInvoker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        keyPressCheck();
    }    
    private void keyPressCheck(){
        if(Greenfoot.isKeyDown("right")){
            rightCommand.execute();
        }else if(Greenfoot.isKeyDown("left")){
            leftCommand.execute();
        }else if(Greenfoot.isKeyDown("up")){
            upCommand.execute();
        }else if(Greenfoot.isKeyDown("down")){
            downCommand.execute();
        }else if(Greenfoot.isKeyDown("a")){
            aCommand.execute();
        }else if(Greenfoot.isKeyDown("s")){
            sCommand.execute();
        }
    }
}