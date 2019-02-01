import processing.core.PApplet;
import java.util.*;

public class Thing1 extends CreatureWorldThing {


    private int myColor;


    public Thing1 (int _id, int _x, int _y, int _direction) { //constructor must have same name as class
        super(_id, _x, _y, _direction); //use super to use parent class
        myColor = app.color(195, 255, 175);

    }


    //METHODS
    public void display() {
        PApplet app = CreatureWorldApp.getApp();
        app.rectMode(app.CENTER);
        app.fill(myColor);
        app.noStroke();
        app.rect(getX(), getY(), 100, 40);

    }

    public void behave() {
        int oldX = getX();
        int direction = getDirection();
        int newX = oldX + direction;

        setX(getX() + 1);
        setX(newX);

        if (newX+50 > app.width || newX-50 < 0) {
            setDirection(-direction);
        }

    }

    public void interact(ArrayList<CreatureWorldThing> things) {
        for (int i = 0; i < things.size(); i++) {

            if (things.get(i).getID() != getID()) {
                if(app.dist(things.get(i).getX(), things.get(i).getY(), getX(), getY()) < 50) {
                    setY((int) app.random(app.height));
                }
            }


        }
    }
}