import java.util.*;

public class CreatureWorldThing {

    protected final CreatureWorldApp app = CreatureWorldApp.getApp(); //only subclasses have access
    private int id;
    private int x;
    private int y;
    private int direction;

    public CreatureWorldThing(int _id, int _x, int _y, int _direction) { //public bc must be called from other code
        id = _id;
        x = _x;
        y = _y;
        direction = _direction;

    }


    //GETTERS AND SETTERS

    public int getX() {
        return x;
    }

    public void setX(int _x) {
        x = _x;
    }

    public int getY() {
        return y;
    }

    public void setY(int _y) {
        y = _y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int _direction) {
        direction = _direction;
    }

    public int getID() { //we don't want setID bc every object has unique ID
        return id;
    }



    public void display() {


    }

    public void behave() {


    }

    public void interact(ArrayList<CreatureWorldThing> things) {

    }
}
