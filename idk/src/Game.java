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
        m = new Map(b);

        Freshman = new Level("Freshman");
        Freshman.addTask("Choose Roommate", "Go to the Freshman Dorms and choose one of the available roommates", 2, new int[]{1,0,0,0,0});
        Freshman.addTask("Take Campus Tour", "Visit every building on campus", 10, new int[]{0, 1, 0, 0, 0});

        Sophomore = new Level("Sophomore");
        Sophomore.addTask("Declare Major", "Go to Nord Hall and fill out a declare major form", 2, new int[]{1,0,0,1,1,0});
        Sophomore.addTask("Join Club", "Go to Tinkham Veale University Center and join one of the available clubs", 2, new int[]{0,0,1,0,1});

        Junior = new Level("Junior");
        Junior.addTask("Pass test", "Go to the Bingham building, take the necessary test, and pass it", 3, new int[]{0,0,1,1,0,0});
        Junior.addTask("Study", "Go to the Kelvin Smith Library and study one of the books", 2, new int[]{0,0,0,1,1});

        Senior = new Level("Senior");
        Senior.addTask("Take Gym", "Go to the Veale Gym and take one of the available gym classes", 2, new int[]{0,0,1,1,0,0});
        Senior.addTask("Complete Capstone", "Go to you major's specific buildings and complete your major's specific objectives to graduate!", 6, new int[]{2,2,2,2,2});

        load();

        }
    public Level getFreshman(){return Freshman;}

    public Level getSophomore(){return Sophomore;}

    public Level getJunior(){return Junior;}

    public Level getSenior(){ return Senior; }

    public boolean gameFinished() {
        if (Senior.isFinished()) {
            System.out.println("Congratulaitons! You Win!");
            return true;
        }
        return false;
    }

    //You also need to save and load the player's attributes and (maybe) completed tasks
    public void save(){
        try {
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
            writer.write(p.getAttributes()[0]);
            writer.write(p.getAttributes()[1]);
            writer.write(p.getAttributes()[2]);
            writer.write(p.getAttributes()[3]);
            writer.write(p.getAttributes()[4]);
        }
        catch(IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void load(){
        Scanner reader = new Scanner("save.txt");

        if(reader.hasNext() && reader.nextLine().equals("true")){
            Freshman.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("true")){
            Sophomore.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("true")){
            Junior.setFinish();
        }

        if(reader.hasNext() && reader.nextLine().equals("true")){
            Senior.setFinish();
        }

        int Health = 0;
        int Hygiene = 0;
        int Intelligence = 0;
        int Strength = 0;
        int SocialStanding = 0;

        if(reader.hasNext()) {
            Health = (int) reader.nextLine().charAt(0) - 48;
        }
        if(reader.hasNext()) {
            Hygiene = (int) reader.nextLine().charAt(1) - 48;
        }
        if(reader.hasNext()) {
            Intelligence = (int) reader.nextLine().charAt(2) - 48;
        }
        if(reader.hasNext()) {
            Strength = (int) reader.nextLine().charAt(3) - 48;
        }
        if(reader.hasNext()) {
            SocialStanding = (int) reader.nextLine().charAt(4) - 48;
        }
        p = new Player(100,100, new int[] {0,0,0}, new int[] {Health, Hygiene, Intelligence, Strength, SocialStanding});

    }
}