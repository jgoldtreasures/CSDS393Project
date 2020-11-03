import javax.print.attribute.standard.JobHoldUntil;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

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
        Sophomore = new Level();
        Junior = new Level();
        Senior = new Level();

        load();

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

    public void save(){
        try {
            File create = new File("save.txt");
            if (create.createNewFile()) {
                FileWriter writer = new FileWriter("save.txt");
                boolean temp = Freshman.isFinished();
                if(temp){
                    writer.write("true");
                }
                else{
                    writer.write("false");
                }
                temp = Sophomore.isFinished();;
                if(temp){
                    writer.write("true");
                }
                else{
                    writer.write("false");
                }
                temp = Junior.isFinished();
                if(temp){
                    writer.write("true");
                }
                else{
                    writer.write("false");
                }
                temp = Senior.isFinished();
                if(temp){
                    writer.write("true");
                }
                else{
                    writer.write("false");
                }
            }
        }
        catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load(){
        Scanner reader = new Scanner("save.txt");

        if(reader.hasNext() && reader.nextLine().equals("false")){
            Freshman.addTask("Choose Roommate", "Go to the Freshman Dorms and choose one of the available roommates", 2, new int[]{1,0,0,0,0});
            Freshman.addTask("Take Campus Tour", "Visit every building on campus", 10, new int[]{0, 1, 0, 0, 0});
        }
        else{
            Freshman.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("false")){
            Sophomore.addTask("Declare Major", "Go to Nord Hall and fill out a declare major form", 2, new int[]{1,0,0,1,1,0});
            Sophomore.addTask("Join Club", "Go to Tinkham Veale University Center and join one of the available clubs", 2, new int[]{0,0,1,0,1});

        }
        else{
            Sophomore.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("false")){
            Junior.addTask("Pass test", "Go to the Bingham building, take the necessary test, and pass it", 3, new int[]{0,0,1,1,0,0});
            Junior.addTask("Study", "Go to the Kelvin Smith Library and study one of the books", 2, new int[]{0,0,0,1,1});
        }
        else{
            Junior.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("false")){
            Senior.addTask("Take Gym", "Go to the Veale Gym and take one of the available gym classes", 2, new int[]{0,0,1,1,0,0});
            Senior.addTask("Complete Capstone", "Go to you major's specific buildings and complete your major's specific objectives to graduate!", 6, new int[]{2,2,2,2,2});

        }
        else{
            Senior.setFinish();
        }
    }
}