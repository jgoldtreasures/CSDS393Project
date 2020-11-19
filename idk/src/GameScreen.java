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
            quadButtonPanel, millisButtonPanel, rockButtonPanel, northButtonPanel, southButtonPanel, gStartButtonPanel, menuButtonPanel, returnPanel, savePanel,
            menuPanel, attrButtonPanel, attrPanel, healthPanel, hygienePanel, intelligencePanel, strengthPanel, socialStandingPanel;
    JLabel titleNameLabel, imageLabel;
    JButton startButton, loadButton, vealeButton, quadButton, millisButton, rockButton, northButton, southButton, gStartButton, menuButton, returnButton, saveButton, attrButton;
    JTextArea introTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font introFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font medFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font mapFont = new Font("Times New Roman", Font.PLAIN, 12);

    ImageIcon image;

    ScreenHandler sHandler = new ScreenHandler();

    Game g;

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image home screen - intro, save, and load

        createTitleScreen();
        createIntroScreen();
        createQuadScreen();
        createMenuScreen();

        g = new Game();

        createAttributesScreen();

        //need to be able to start even if there is a saved file - give warning though
        //also give warning when trying to save over a saved file
        //if we close screen and reload, is the load file still saved?
        //image for each building
        //Will take a specfic image from a connected folder for the image
        //will also standardize the format for the buildings
    }

    public void createTitleScreen(){
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
    }

    public void createIntroScreen(){

        gStartButtonPanel = new JPanel();
        gStartButtonPanel.setBounds(300, 425 ,150, 50);
        gStartButton = new JButton("Start");
        gStartButton.setBackground(Color.darkGray);
        gStartButton.setForeground(Color.white);
        gStartButton.setFont(normalFont);

        gStartButton.addActionListener(sHandler);
        gStartButtonPanel.add(gStartButton);


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

        //find a way to center text
        introTextArea = new JTextArea(textIntro);
        introTextArea.setBounds(25,25,725,375);
        introTextArea.setFont(introFont);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);

        introTextPanel.add(introTextArea);

        introTextPanel.setVisible(false);
        gStartButtonPanel.setVisible(false);

        con.add(introTextPanel);
        con.add(gStartButtonPanel);
    }

    public void createQuadScreen(){
        menuButtonPanel = new JPanel();
        menuButtonPanel.setBounds(100, 50,100, 50);
        menuButton = new JButton("Menu");
        menuButton.setBackground(Color.white);
        menuButton.setForeground(Color.darkGray);
        menuButton.setFont(normalFont);

        menuButton.addActionListener(sHandler);
        menuButtonPanel.add(menuButton);
        con.add(menuButtonPanel);


        vealeButtonPanel = new JPanel();
        vealeButtonPanel.setBounds(622, 100,50, 25);
        vealeButton = new JButton("Veale");
        vealeButton.setBackground(Color.darkGray);
        vealeButton.setForeground(Color.white);
        vealeButton.setFont(mapFont);

        vealeButton.addActionListener(sHandler);
        vealeButtonPanel.add(vealeButton);
        con.add(vealeButtonPanel);


        millisButtonPanel = new JPanel();
        millisButtonPanel.setBounds(282, 230,50, 25);
        millisButton = new JButton("Millis");
        millisButton.setBackground(Color.darkGray);
        millisButton.setForeground(Color.white);
        millisButton.setFont(mapFont);

        millisButton.addActionListener(sHandler);
        millisButtonPanel.add(millisButton);
        con.add(millisButtonPanel);


        rockButtonPanel = new JPanel();
        rockButtonPanel.setBounds(287, 320,70, 25);
        rockButton = new JButton("Rockefeller");
        rockButton.setBackground(Color.darkGray);
        rockButton.setForeground(Color.white);
        rockButton.setFont(mapFont);

        rockButton.addActionListener(sHandler);
        rockButtonPanel.add(rockButton);
        con.add(rockButtonPanel);


        northButtonPanel = new JPanel();
        northButtonPanel.setBounds(25, 500,70, 25);
        northButton = new JButton("Northside");
        northButton.setBackground(Color.darkGray);
        northButton.setForeground(Color.white);
        northButton.setFont(mapFont);

        northButton.addActionListener(sHandler);
        northButtonPanel.add(northButton);
        con.add(northButtonPanel);


        southButtonPanel = new JPanel();
        southButtonPanel.setBounds(700, 25,70, 25);
        southButton = new JButton("Southside");
        southButton.setBackground(Color.darkGray);
        southButton.setForeground(Color.white);
        southButton.setFont(mapFont);

        southButton.addActionListener(sHandler);
        southButtonPanel.add(southButton);
        con.add(southButtonPanel);


        quadButtonPanel = new JPanel();
        quadButtonPanel.setBounds(100, 100, 180, 50);
        quadButton = new JButton("Return to Quad");
        quadButton.setBackground(Color.white);
        quadButton.setForeground(Color.darkGray);
        quadButton.setFont(normalFont);
        quadButtonPanel.setVisible(false);

        quadButton.addActionListener(sHandler);
        quadButtonPanel.add(quadButton);
        con.add(quadButtonPanel);

        con.add(imagePanel);
        imagePanel.setVisible(false);
        hideBuildingButtons();
        menuButtonPanel.setVisible(false);

        //player object/image is implemented and can be moved around
        //if at location to change maps, do so
        //if building thing
    }

    public void createNorthScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/CWRUnorthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createSouthScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/CWRUsouthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createVealeScreen(){
        hideBuildingButtons();

        image = new ImageIcon("idk/resources/Veale.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        quadButtonPanel.setVisible(true);
    }

    public void createMillisScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Millis.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

    }

    public void createRockefellerScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Rockefeller.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createMenuScreen(){
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

        attrButtonPanel = new JPanel();
        attrButtonPanel.setBounds(250, 350,250, 50);
        attrButton = new JButton("Attributes");
        attrButton.setBackground(Color.darkGray);
        attrButton.setForeground(Color.white);
        attrButton.setFont(normalFont);

        attrButton.addActionListener(sHandler);

        returnPanel = new JPanel();
        returnPanel.setBounds(300, 400 ,150, 50);
        returnButton = new JButton("Return");
        returnButton.setBackground(Color.darkGray);
        returnButton.setForeground(Color.white);
        returnButton.setFont(normalFont);

        returnButton.addActionListener(sHandler);

        menuPanel.add(menuLabel);
        savePanel.add(saveButton);
        returnPanel.add(returnButton);
        attrButtonPanel.add(attrButton);

        con.add(menuPanel);
        con.add(savePanel);
        con.add(returnPanel);
        con.add(attrButtonPanel);

        menuPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrButtonPanel.setVisible(false);

    }

    public void createAttributesScreen(){
        //menuButtonPanel.setVisible(true);
        attrPanel = new JPanel();
        attrPanel.setBounds(250,100,300,50);
        attrPanel.setBackground(Color.DARK_GRAY);
        JLabel attrLabel = new JLabel("Player Attributes");
        attrLabel.setFont(medFont);
        attrLabel.setForeground(Color.white);

        healthPanel = new JPanel();
        healthPanel.setBounds(300, 400 ,150, 50);
        //String health = "Health: " + String.valueOf(g.getPlayer().getAttributeVal("Health"));
        JLabel healthlabel = new JLabel("Health: 1");
        healthlabel.setBackground(Color.white);
        healthlabel.setForeground(Color.darkGray);
        healthlabel.setFont(normalFont);

        hygienePanel = new JPanel();
        hygienePanel.setBounds(300, 350 ,150, 50);
        JLabel hygienelabel = new JLabel("Hygiene: 1");
        hygienelabel.setBackground(Color.white);
        hygienelabel.setForeground(Color.darkGray);
        hygienelabel.setFont(normalFont);

        intelligencePanel = new JPanel();
        intelligencePanel.setBounds(300, 300 ,150, 50);
        JLabel intelligencelabel = new JLabel("Intelligence: 1");
        intelligencelabel.setBackground(Color.white);
        intelligencelabel.setForeground(Color.darkGray);
        intelligencelabel.setFont(normalFont);

        strengthPanel = new JPanel();
        strengthPanel.setBounds(300, 250 ,150, 50);
        JLabel strengthlabel = new JLabel("Strength: 1");
        strengthlabel.setBackground(Color.white);
        strengthlabel.setForeground(Color.darkGray);
        strengthlabel.setFont(normalFont);

        socialStandingPanel = new JPanel();
        socialStandingPanel.setBounds(275, 200 ,200, 50);
        JLabel socialStandinglabel = new JLabel("Social Standing: 1");
        socialStandinglabel.setBackground(Color.white);
        socialStandinglabel.setForeground(Color.darkGray);
        socialStandinglabel.setFont(normalFont);

        attrPanel.add(attrLabel);
        healthPanel.add(healthlabel);
        hygienePanel.add(hygienelabel);
        intelligencePanel.add(intelligencelabel);
        strengthPanel.add(strengthlabel);
        socialStandingPanel.add(socialStandinglabel);

        con.add(attrPanel);
        con.add(healthPanel);
        con.add(hygienePanel);
        con.add(intelligencePanel);
        con.add(strengthPanel);
        con.add(socialStandingPanel);

        attrPanel.setVisible(false);
        healthPanel.setVisible(false);
        hygienePanel.setVisible(false);
        intelligencePanel.setVisible(false);
        strengthPanel.setVisible(false);
        socialStandingPanel.setVisible(false);
    }

    public void displayIntroScreen(){
        titleNamePanel.setVisible(false);
        loadButtonPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        introTextPanel.setVisible(true);
        gStartButtonPanel.setVisible(true);
    }

    public void displayQuadScreen(){
        introTextPanel.setVisible(false);
        imagePanel.setVisible(false);
        quadButtonPanel.setVisible(false);
        gStartButtonPanel.setVisible(false);
        menuPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrButtonPanel.setVisible(false);

        image = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);

        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        vealeButtonPanel.setVisible(true);
        millisButtonPanel.setVisible(true);
        rockButtonPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
        northButtonPanel.setVisible(true);
        southButtonPanel.setVisible(true);
    }

    public void displayMenuScreen(){
        imagePanel.setVisible(false);
        quadButtonPanel.setVisible(false);
        hideBuildingButtons();
        menuButtonPanel.setVisible(false);
        attrPanel.setVisible(false);
        healthPanel.setVisible(false);
        hygienePanel.setVisible(false);
        intelligencePanel.setVisible(false);
        strengthPanel.setVisible(false);
        socialStandingPanel.setVisible(false);

        menuPanel.setVisible(true);
        savePanel.setVisible(true);
        returnPanel.setVisible(true);
        attrButtonPanel.setVisible(true);
    }

    public void displayAttrScreen(){
        menuPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrPanel.setVisible(true);
        healthPanel.setVisible(true);
        hygienePanel.setVisible(true);
        intelligencePanel.setVisible(true);
        strengthPanel.setVisible(true);
        socialStandingPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
    }

    public void hideBuildingButtons(){
        vealeButtonPanel.setVisible(false);
        millisButtonPanel.setVisible(false);
        rockButtonPanel.setVisible(false);
        southButtonPanel.setVisible(false);
        northButtonPanel.setVisible(false);
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
            if(event.getSource() == startButton){
                displayIntroScreen();
            }
            if(event.getSource() == gStartButton){
                displayQuadScreen();
            }
            if(event.getSource() == vealeButton){
                createVealeScreen();
            }
            if(event.getSource() == quadButton){
                displayQuadScreen();
            }
            if(event.getSource() == millisButton){
                createMillisScreen();
            }
            if(event.getSource() == rockButton){
                createRockefellerScreen();
            }
            if(event.getSource() == northButton){
                createNorthScreen();
            }
            if(event.getSource() == southButton){
                createSouthScreen();
            }
            if(event.getSource() == menuButton) {
                displayMenuScreen();
            }
            if(event.getSource() == returnButton){
                displayQuadScreen();
            }
            if(event.getSource() == saveButton){

            }
            if(event.getSource() == attrButton){
                displayAttrScreen();
            }
        }
    }
}
