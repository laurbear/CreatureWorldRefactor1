import java.util.*;

public class Thing3 extends CreatureWorldThing { //egg

    private int myColor;


    public Thing3 (int _id, int _x, int _y) {
        super(_id, _x, _y, 1);
        myColor = app.color(230, 178, 255);
    }


    public void display() {
        app.rectMode(app.CENTER);
        app.fill(myColor);
        app.noStroke();
        app.ellipse(getX(), getY(), 30, 35);

    }

    public void behave() {


    }

    public void interact(ArrayList<CreatureWorldThing> things) {
        //make egg fade when interact

        app.textSize(24);
        app.fill(255, 186, 212);
        app.text("Egg count: " + app.getCount(), 400, 50);

        for (int i = 0; i < things.size(); i++) {
            if (things.get(i).getID() == 8){
                if(app.dist(things.get(i).getX(), things.get(i).getY(), getX(), getY()) < 25){
                    setX((int) app.random(app.width));
                    setY((int) app.random(app.height));
                    app.incrementCount();
                }
            }
        }

    }
}
