public class Game{
    private Player p;
    private Map m;

    public Player getPlayer(){
        return p;
    }

    public void startGame(){
        p = new Player(100,100);
        m = new Map();
        Level Freshman = new Level();
        Freshman.addTask("Choose Roommate", "Go to the Freshman Dorms and choose one of the available roommates", 2, new int[]{1,0,0,0,0,0});
        Freshman.addTask("Take Campus Tour", "Visit every building on campus", 10, new int[]{0, 1, 0, 0, 0, 0});
        Level Sophomore = new Level();
        Level Junior = new Level();
        Level Senior = new Level();



    }

}

