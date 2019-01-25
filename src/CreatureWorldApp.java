import processing.core.PApplet;
import ddf.minim.AudioPlayer;
import ddf.minim.*;


public class CreatureWorldApp extends PApplet {

    private static CreatureWorldApp app;
    private int count = 0;
    private CreatureWorldThing[] things;

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


        things = new CreatureWorldThing[10];
        //GRASS OBSTACLES

        // FIX THIS
        things[0] = new Thing1(0, width/2, height/2, 1);
        things[1] = new Thing1(1, width/3, height/4, -3);
        things[2] = new Thing1(2, 100, 500, 1);
        things[3] = new Thing1(3, width/4, 375, -4);
        things[4] = new Thing1(4, width/5, 500, 1);
        things[5] = new Thing1(5,510, 560, -1);
        things[6] = new Thing1(6,width/7, 230, 2);
        things[7] = new Thing1(7,470, 320, -5);


        //CHICK
        things[8] = new Thing2(8);

        //EGGS
        things[9] = new Thing3(9, 200, 500);

    }


    public void draw() {
        background(255);


        if (count >= 0) {
            for (int i = 0; i < things.length; i++) {
                things[i].display();
                things[i].behave();
                things[i].interact(things);
            }
            fill(255, 186, 212);
            textSize(15);
            text("collect the eggs. hit the blocks and you lose 2 eggs!", 210, 70);

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

        for (int i = 0; i < things.length; i++) {
            things[i].display();
            things[i].behave();
            things[i].interact(things);

        }

    }

    public static CreatureWorldApp getApp(){
        return app;
    }

}
