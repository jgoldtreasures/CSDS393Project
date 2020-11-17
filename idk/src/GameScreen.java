import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameScreen {
    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel;
    JLabel titleNameLabel, imageLabel;
    JButton startButton, loadButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);

    ImageIcon image;

    ScreenHandler sHandler = new ScreenHandler();

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image homescreen - intro, save, and load
        gameScreen = new JFrame();
        gameScreen.setSize(800,600);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //gameScreen.getContentPane().setBackground(Color.BLACK);
        gameScreen.setLayout(null);
        con = gameScreen.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(120,150,550,100);
        titleNamePanel.setBackground(Color.DARK_GRAY);
        titleNameLabel = new JLabel("CWRU RPG");
        titleNameLabel.setFont(titleFont);
        titleNameLabel.setForeground(Color.white);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 300 ,150, 50);
        startButton = new JButton("Start");
        startButton.setBackground(Color.darkGray);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);

        startButton.addActionListener(sHandler);

        loadButtonPanel = new JPanel();
        loadButtonPanel.setBounds(300, 350 ,150, 50);
        loadButton = new JButton("Load");
        loadButton.setBackground(Color.darkGray);
        loadButton.setForeground(Color.white);
        loadButton.setFont(normalFont);

        loadButton.addActionListener(sHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        loadButtonPanel.add(loadButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(loadButtonPanel);

        gameScreen.setVisible(true);

        //popup menu window

        //image for maps
        imagePanel = new JPanel();
        imagePanel.setBounds(-10,-10,800,600);
        imageLabel = new JLabel();


        image = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);

        imageLabel.setIcon(image);
        imagePanel.add(imageLabel);

        //image for each building
        //Will take a specfic image from a connected folder for the image
        //will also standardize the format for the buildings
    }

    public void createQuadScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        loadButtonPanel.setVisible(false);

        con.add(imagePanel);
        imagePanel.setVisible(true);

        //player object/image is implemented and can be moved around
        //if at location to change maps, do so
        //if building thing
    }

    public void createNorthScreen(){
        image = new ImageIcon("idk/resources/CWRUnorthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createSouthScreen(){
        image = new ImageIcon("idk/resources/CWRUsouthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createBuildingScreen(){

    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImage;
    }

    public class ScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Need to add a manner which differentiates between start/load
            createQuadScreen();
        }
    }
}
