import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor1 extends BaseFloor
{

    /**
     * Constructor for objects of class Floor1.
     * 
     */
    public Floor1(IFighter mainCharacter)
    {
        super(mainCharacter);
        System.out.println("constructe..");
        this.scenarioName = "The First Floor";
        // add Bruce Lee to this scenario
        objectsLocationMap.put((Actor)mainCharacter,new int[]{this.activeAreaXLeft+20,
        this.activeAreaYBottom-((Actor)mainCharacter).getImage().getHeight()});
        
        // add Bruce Joe to this scenario
        IFighter g1 = gangsterFactory.generate("Joe");
        gangsters.add(g1);
        objectsLocationMap.put((Actor)g1,new int[]{this.activeAreaXRight -50,
        this.activeAreaYBottom-((Actor)g1).getImage().getHeight()});
        //add boss
        IFighter g2 = gangsterFactory.generate("boss");
        gangsters.add(g2);
        objectsLocationMap.put((Actor)g2,new int[]{this.activeAreaXRight -70,
        this.activeAreaYBottom-((Actor)g1).getImage().getHeight()});
        System.out.println("constructed.");
    }
    
}