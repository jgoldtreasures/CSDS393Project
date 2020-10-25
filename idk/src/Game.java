import javax.print.attribute.standard.JobHoldUntil;
import java.awt.*;
import java.awt.event.*;

public class Game{
    private Player p;
    private Map m;
    private Level Freshman;
    private Level Sophomore;
    private Level Junior;
    private Level Senior;

    public Game(){
        //Building b needs to be changed
        Building[] b = {};
        p = new Player(100,100, new int[] {0,0,0}, new int[] {0,0,0,0,0});
        m = new Map(b);

        Freshman = new Level();
        Freshman.addTask("Choose Roommate", "Go to the Freshman Dorms and choose one of the available roommates", 2, new int[]{1,0,0,0,0});
        Freshman.addTask("Take Campus Tour", "Visit every building on campus", 10, new int[]{0, 1, 0, 0, 0});

        Sophomore = new Level();
        Sophomore.addTask("Declare Major", "Go to Nord Hall and fill out a declare major form", 2, new int[]{1,0,0,1,1,0});
        Sophomore.addTask("Join Club", "Go to Tinkham Veale University Center and join one of the available clubs", 2, new int[]{0,0,1,0,1});

        Junior = new Level();
        Junior.addTask("Pass test", "Go to the Bingham building, take the necessary test, and pass it", 3, new int[]{0,0,1,1,0,0});
        Junior.addTask("Study", "Go to the Kelvin Smith Library and study one of the books", 2, new int[]{0,0,0,1,1});

        Senior = new Level();
        Senior.addTask("Take Gym", "Go to the Veale Gym and take one of the available gym classes", 2, new int[]{0,0,1,1,0,0});
        Senior.addTask("Complete Capstone", "Go to you major's specific buildings and complete your major's specific objectives to graduate!", 6, new int[]{2,2,2,2,2});
    }
    public Level getFreshman(){return Freshman;}

    public Level getSophomore(){return Sophomore;}

    public Level getJunior(){return Junior;}

    public Level getSenior(){ return Senior; }

    public boolean gameFinished() {
        if (Senior.isFinished()) {
            return true;
        }
        return false;
    }

}