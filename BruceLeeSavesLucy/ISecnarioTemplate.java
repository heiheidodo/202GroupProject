/**
 * Write a description of class ISecnarioTemplate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ISecnarioTemplate  
{
    public void onCreate(); 
    public void onStart(); 
    public void onAct(); 
    public void onPause();
    public void onEnd();
    public boolean isOver();
}