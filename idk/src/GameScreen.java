import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameScreen {
    public String screenName;

    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel,introTextPanel, vealeButtonPanel,
            quadButtonPanel, millisButtonPanel, rockButtonPanel, strosackerButtonPanel, gStartButtonPanel,
            menuButtonPanel, returnPanel, savePanel, menuPanel, goSouthPanel, goNorthPanel;
    JLabel titleNameLabel, imageLabel;
    JButton startButton, loadButton, vealeButton, quadButton, millisButton, rockButton, strosackerButton,
            gStartButton, menuButton, returnButton, saveButton, goSouthButton, goNorthButton;

    JTextArea introTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font introFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font mapFont = new Font("Times New Roman", Font.PLAIN, 10);
    Font mapFont2 = new Font("Times New Roman", Font.PLAIN, 13);

    ImageIcon image;

    ScreenHandler sHandler = new ScreenHandler();

    Game g;

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image home screen - intro, save, and load
        screenName = "Title Screen";

        gameScreen = new JFrame();
        gameScreen.setSize(800,600);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        quadButtonPanel = new JPanel();
        quadButtonPanel.setBounds(100, 100, 180, 50);
        quadButton = new JButton("Return to Quad");
        quadButton.setBackground(Color.darkGray);
        quadButton.setForeground(Color.white);
        quadButton.setFont(normalFont);
        quadButtonPanel.setVisible(false);

        quadButton.addActionListener(sHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        loadButtonPanel.add(loadButton);
        quadButtonPanel.add(quadButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(loadButtonPanel);
        con.add(quadButtonPanel);

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

        g = new Game();

        //need to be able to start even if there is a saved file - give warning though
        //also give warning when trying to save over a saved file
        //if we close screen and reload, is the load file still saved?
        //image for each building
        //Will take a specfic image from a connected folder for the image
        //will also standardize the format for the buildings
    }

    public void createIntroScreen(){
        titleNamePanel.setVisible(false);
        loadButtonPanel.setVisible(false);
        startButtonPanel.setVisible(false);

        gStartButtonPanel = new JPanel();
        gStartButtonPanel.setBounds(300, 425 ,150, 50);
        gStartButton = new JButton("Start");
        gStartButton.setBackground(Color.darkGray);
        gStartButton.setForeground(Color.white);
        gStartButton.setFont(normalFont);

        gStartButton.addActionListener(sHandler);
        gStartButtonPanel.add(gStartButton);
        gStartButtonPanel.setVisible(true);

        screenName = "Intro Screen";

        String textIntro ="You are a student at Case Western Reserve University. Your goal is to graduate from the " +
                "university. There will be both required and optional tasks, but the required tasks will be within " +
                "your task list at the start of each year. Every \"year\" will last 7 in-game days. \n\n" +
                "When on one of the three maps, you may move around the screen using the arrow-keys and you can enter" +
                " a nearby building by pressing 'enter'\n\n" +
                "When in a building, you can cycle between interactable objects using the 'up' and 'down' arrow keys." +
                " Pressing 'enter' will start an interaction with the object.\n\n" +
                "On any screen, pressing 'm' will bring up the in-game menu, which will allow you to save the game, " +
                "look at your attributes, look at your task list, and exit the game. \n\n" +
                "Press 'Start' to begin the game. Have fun playing!";

        introTextPanel = new JPanel();
        introTextPanel.setBounds(25,50,725,375);
        con.add(introTextPanel);
        con.add(gStartButtonPanel);

        //find a way to center text
        introTextArea = new JTextArea(textIntro);
        introTextArea.setBounds(25,25,725,375);
        introTextArea.setFont(introFont);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);

        introTextPanel.add(introTextArea);
    }

    public void createQuadScreen(){
        introTextPanel.setVisible(false);
        imagePanel.setVisible(false);
        quadButtonPanel.setVisible(false);
        gStartButtonPanel.setVisible(false);

        image = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);

        imageLabel.setIcon(image);

        //Go to North Side
        goNorthPanel = new JPanel();
        goNorthPanel.setBounds(20, 430,50, 35);
        goNorthButton = new JButton("Northside");
        goNorthButton.setBackground(Color.black);
        goNorthButton.setForeground(Color.white);
        goNorthButton.setFont(mapFont2);
        goNorthButton.addActionListener(sHandler);

        //Go to South side
        goSouthPanel = new JPanel();
        goSouthPanel.setBounds(360, 15,50, 35);
        goSouthButton = new JButton("Southside");
        goSouthButton.setBackground(Color.black);
        goSouthButton.setForeground(Color.white);
        goSouthButton.setFont(mapFont2);
        goSouthButton.addActionListener(sHandler);

        //Menu Button
        menuButtonPanel = new JPanel();
        menuButtonPanel.setBounds(100, 50,100, 50);
        menuButton = new JButton("Menu");
        menuButton.setBackground(Color.white);
        menuButton.setForeground(Color.darkGray);
        menuButton.setFont(normalFont);
        menuButton.addActionListener(sHandler);

        //Veale Button
        vealeButtonPanel = new JPanel();
        vealeButtonPanel.setBounds(622, 100,30, 25);
        vealeButton = new JButton("Veale");
        vealeButton.setBackground(Color.white);
        vealeButton.setForeground(Color.black);
        vealeButton.setFont(mapFont);
        vealeButton.addActionListener(sHandler);

        //Millis-Schmidt Button
        millisButtonPanel = new JPanel();
        millisButtonPanel.setBounds(282, 230,30, 25);
        millisButton = new JButton("Millis");
        millisButton.setBackground(Color.white);
        millisButton.setForeground(Color.black);
        millisButton.setFont(mapFont);
        millisButton.addActionListener(sHandler);

        //ROCKEFELLER BUTTON
        rockButtonPanel = new JPanel();
        rockButtonPanel.setBounds(285, 315,50, 25);
        rockButton = new JButton("Rockefeller");
        rockButton.setBackground(Color.white);
        rockButton.setForeground(Color.BLACK);
        rockButton.setFont(mapFont);
        rockButton.addActionListener(sHandler);

        //STROSACKER BUTTON
        strosackerButtonPanel = new JPanel();
        strosackerButtonPanel.setBounds(325, 285,50, 25);
        strosackerButton = new JButton("Strosacker");
        strosackerButton.setBackground(Color.white);
        strosackerButton.setForeground(Color.BLACK);
        strosackerButton.setFont(mapFont);
        strosackerButton.addActionListener(sHandler);

        menuButtonPanel.add(menuButton);
        vealeButtonPanel.add(vealeButton);
        millisButtonPanel.add(millisButton);
        rockButtonPanel.add(rockButton);
        strosackerButtonPanel.add(strosackerButton);
        goSouthPanel.add(goSouthButton);
        goNorthPanel.add(goNorthButton);

        con.add(menuButtonPanel);
        con.add(vealeButtonPanel);
        con.add(millisButtonPanel);
        con.add(rockButtonPanel);
        con.add(strosackerButtonPanel);
        con.add(goNorthPanel);
        con.add(goSouthPanel);
        con.add(imagePanel);

        imagePanel.setVisible(true);
        vealeButtonPanel.setVisible(true);
        millisButtonPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
        rockButtonPanel.setVisible(true);
        strosackerButtonPanel.setVisible(true);
        goSouthPanel.setVisible(true);
        goNorthPanel.setVisible(true);

        //player object/image is implemented and can be moved around
        //if at location to change maps, do so
        //if building thing
    }

    public void createNorthScreen(){
        image = new ImageIcon("idk/resources/CWRUnorthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 400);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
        imagePanel.setVisible(true);
    }

    public void createSouthScreen(){
        image = new ImageIcon("idk/resources/CWRUsouthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 650, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
        imagePanel.setVisible(true);
    }

    public void createVealeScreen(){
        image = new ImageIcon("idk/resources/Veale.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        quadButtonPanel.setVisible(true);
    }

    public void createMillisScreen(){
        image = new ImageIcon("idk/resources/Millis.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        quadButtonPanel.setVisible(true);

    }

    public void createRockefellerScreen(){
        image = new ImageIcon("idk/resources/Rockefeller.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        quadButtonPanel.setVisible(true);
    }

    public void createStrosackerScreen(){
        image = new ImageIcon("idk/resources/strosacker.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        quadButtonPanel.setVisible(true);
    }

    public void createMenuScreen(){
        imagePanel.setVisible(false);
        quadButtonPanel.setVisible(false);;
        menuButtonPanel.setVisible(false);

        menuPanel = new JPanel();
        menuPanel.setBounds(120,150,550,100);
        menuPanel.setBackground(Color.DARK_GRAY);
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setFont(titleFont);
        menuLabel.setForeground(Color.white);

        savePanel = new JPanel();
        savePanel.setBounds(300, 300 ,150, 50);
        saveButton = new JButton("Save");
        saveButton.setBackground(Color.darkGray);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);

        saveButton.addActionListener(sHandler);

        returnPanel = new JPanel();
        returnPanel.setBounds(300, 350 ,150, 50);
        returnButton = new JButton("Return");
        returnButton.setBackground(Color.darkGray);
        returnButton.setForeground(Color.white);
        returnButton.setFont(normalFont);

        returnButton.addActionListener(sHandler);

        menuPanel.add(menuLabel);
        savePanel.add(saveButton);
        returnPanel.add(returnButton);

        con.add(menuPanel);
        con.add(savePanel);
        con.add(returnPanel);
    }

    public void hideQuadButtons(){
        imagePanel.setVisible(false);
        vealeButtonPanel.setVisible(false);
        millisButtonPanel.setVisible(false);
        rockButtonPanel.setVisible(false);
        strosackerButtonPanel.setVisible(false);
        goSouthPanel.setVisible(false);
        goNorthPanel.setVisible(false);
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
            //Can be even more concise
            if(event.getSource() == startButton){
                createIntroScreen();
            }
            if(event.getSource() == gStartButton){
                createQuadScreen();
            }
            if (event.getSource() == vealeButton) {
                hideQuadButtons();
                createVealeScreen();
            }
            if (event.getSource() == quadButton) {
                hideQuadButtons();
                createQuadScreen();
            }
            if (event.getSource() == millisButton) {
                hideQuadButtons();
                createMillisScreen();
            }
            if (event.getSource() == menuButton) {
                hideQuadButtons();
                createMenuScreen();
            }
            if (event.getSource() == rockButton) {
                hideQuadButtons();
                createRockefellerScreen();
            }
            if (event.getSource() == strosackerButton) {
                hideQuadButtons();
                createStrosackerScreen();
            }
            if (event.getSource() == goNorthButton) {
                hideQuadButtons();
                createNorthScreen();
            }
            if (event.getSource() == goSouthButton) {
                hideQuadButtons();
                createSouthScreen();
            }
            if(event.getSource() == returnButton){
                menuPanel.setVisible(false);
                savePanel.setVisible(false);
                returnPanel.setVisible(false);
                createQuadScreen();
            }
            if(event.getSource() == saveButton){
                
            }
        }
    }
}
