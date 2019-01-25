
public class Thing2 extends CreatureWorldThing { //chick

    private int myColor;


    public Thing2 (int _id) {
        super(_id, CreatureWorldApp.getApp().mouseX, CreatureWorldApp.getApp().mouseY, 1);
        myColor = app.color(255, 251, 158);
    }

    public void setMyColor(int r, int g, int b) {
        myColor = app.color(r, g, b);
    }



    public void display() {
        int mouseX = app.mouseX;
        int mouseY = app.mouseY;
        app.rectMode(app.CENTER);
        app.fill(myColor);
        app.noStroke();
        app.ellipse(mouseX, app.mouseY, 80, 80);
        app.ellipse(mouseX, mouseY-45, 60, 60);
        app.fill(0);
        app.ellipse(mouseX-15, mouseY-50, 10, 10);
        app.ellipse(mouseX+15, mouseY-50, 10, 10);
        app.fill(255, 166, 22);
        app.triangle(mouseX, mouseY-50, mouseX-5, mouseY-40, mouseX+5, mouseY-40);

    }

    public void behave() {
        setX(app.mouseX);
        setY(app.mouseY);


    }

    public void interact(CreatureWorldThing[] things) {

        for (int i = 0; i < 7; i++) {

            if (things[i].getID() != getID()) {
                if(app.dist(things[i].getX(), things[i].getY(), getX(), getY()) < 50) {
                    app.decrementCount();

                }

            }

        }


    }


}