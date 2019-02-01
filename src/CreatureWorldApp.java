import processing.core.PApplet;
import ddf.minim.AudioPlayer;
import ddf.minim.*;
import java.util.*;


public class CreatureWorldApp extends PApplet {

    private static CreatureWorldApp app;
    private int count = 0;
    private ArrayList<CreatureWorldThing> things;


    public CreatureWorldApp() {
        super();
        app = this;
    }


    public static void main(String[] args) {
        PApplet.main("CreatureWorldApp");
    }

    private Minim minim;
    private AudioPlayer sound;

    public void settings() {
        size(600, 600);
        minim = new Minim(this);
        sound = minim.loadFile("Data/sweetball.mp3");
        sound.play();

    }

    public void mouseClicked() {
        things.add(new Thing3(10, 350, 200));
    }


    public int getCount() {
        return count;
    }


    public void incrementCount() {
        count++;
    }

    public void decrementCount() {
        count = count-2;
    }

    public void setup() {

        things = new ArrayList<CreatureWorldThing>();
        //GRASS OBSTACLES

        // FIX THIS
        things.add(new Thing1(0, width/2, height/2, 1));
        things.add(new Thing1(1, width/3, height/4, -3));
        things.add(new Thing1(2, 100, 500, 1));
        things.add(new Thing1(3, width/4, 375, -4));
        things.add(new Thing1(4, width/5, 500, 1));
        things.add(new Thing1(5,510, 560, -1));
        things.add(new Thing1(6,width/7, 230, 2));
        things.add(new Thing1(7,470, 320, -5));



        //CHICK
        //things[8] = new Thing2(8);
        things.add(new Thing2 (8));

        //EGGS
        //things[9] = new Thing3(9, 200, 500);
        things.add(new Thing3(9, 200, 500));

    }


    public void draw() {
        background(255);


        if (count >= 0) {
            for (int i = 0; i < things.size(); i++) {
                things.get(i).display();
                things.get(i).behave();
                things.get(i).interact(things);

            }
            fill(255, 186, 212);
            textSize(13);
            text("collect the eggs, and click to add more.", 340, 70);
            text("hit the blocks and you lose 2 eggs!", 370, 90);

        }

        else {
            fill(255, 186, 212);
            textSize(34);
            text("you lose!", 270, 300);
            text("press r to play again", 230, 350);

        }

    }



    public void keyPressed() {
        if (key == 'r') {
            reset();
        }

    }

    private void reset() {
        if (count < 0) {
            count = 0;
        }

        for (int i = 0; i < things.size(); i++) {
            things.get(i).display();
            things.get(i).behave();
            things.get(i).interact(things);

        }

        for(int j = things.size() - 1; j > 9; j--) {
            app.resetEggs(things.get(j));
        }

    }

    public void resetEggs(CreatureWorldThing thing) {
        things.remove(thing);

    }

    public static CreatureWorldApp getApp(){
        return app;
    }

}
