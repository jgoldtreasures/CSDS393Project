import java.awt.*;
import javax.swing.*;

public class GameScreen {
    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel;
    JLabel titleNameLabel;
    JButton startButton, loadButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    private JButton button1;
    private JPanel panel1;

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image homescreen - intro, save, and load
        //Right now I'm just doing visual stuff
        //actual connections will come later
        gameScreen = new JFrame();
        gameScreen.setSize(800,600);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gameScreen.getContentPane().setBackground(Color.BLACK);
        gameScreen.setLayout(null);
        gameScreen.setVisible(true);
        con = gameScreen.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(120,100,550,100);
        titleNamePanel.setBackground(Color.DARK_GRAY);
        titleNameLabel = new JLabel("CWRU RPG");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);
        titleNamePanel.add(titleNameLabel);
        con.add(titleNamePanel);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 300 ,150, 50);
        startButtonPanel.setBackground(Color.lightGray);
        startButton = new JButton("Start");
        startButton.setFont(normalFont);
        startButtonPanel.add(startButton);
        con.add(startButtonPanel);
/*
        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(300, 375 ,150, 50);
        loadButton = new JButton("Load");
        loadButton.setBackground(Color.darkGray);
        loadButton.setForeground(Color.darkGray);
        loadButtonPanel.add(loadButton);
        con.add(loadButtonPanel);
*/
        //popup menu window

        //image for map

        //image for each building
        //Will take a specfic image from a connected folder for the image
        //will also standardize the format for the buildings
    }
}
