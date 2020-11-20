import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GameScreen {
    public String screenName, taskName, reward;

    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel,introTextPanel, vealeButtonPanel,
            quadButtonPanel, millisButtonPanel, rockButtonPanel, strosackerButtonPanel, awSmithButtonPanel, binghamButtonPanel,
            carltonButtonPanel, crawfordButtonPanel, eldredButtonPanel, elephantButtonPanel, northButtonPanel, southButtonPanel, gStartButtonPanel,
            menuButtonPanel, returnPanel, savePanel, menuPanel, attrButtonPanel, attrPanel, healthPanel, hygienePanel, intelligencePanel,
            strengthPanel, socialStandingPanel, glennanButtonPanel, khsButtonPanel, kslButtonPanel, nordButtonPanel, olinButtonPanel, pblButtonPanel,
            searsButtonPanel, thwingButtonPanel, tinkButtonPanel, whiteButtonPanel, wickendenButtonPanel, yostButtonPanel, tomlinsonButtonPanel, exerciseButtonPanel,
            compPanel1, compPanel2, compPanel3, compPanel4, startExButtonPanel, lectureButtonPanel;
    JLabel titleNameLabel, imageLabel, intelligencelabel, healthlabel, socialStandinglabel, strengthlabel, hygienelabel, compLabel3, compLabel4;
    JButton startButton, loadButton, vealeButton, quadButton, millisButton, strosackerButton, rockButton, northButton, southButton, gStartButton,
            menuButton, returnButton, saveButton, attrButton, awSmithButton, binghamButton, carltonButton, crawfordButton, eldredButton, elephantButton,
            glennanButton, kslButton, khsButton, nordButton, olinButton, pblButton, searsButton, thwingButton, tinkButton, tomlinsonButton, whiteButton,
            wickendenButton, yostButton, exerciseButton, startExButton, lectureButton;
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
        createNorthScreen();
        createSouthScreen();
        createCompletionScreen();
        hideBuildingButtons();


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
        millisButtonPanel.setBounds(272, 230,50, 25);
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

        strosackerButtonPanel = new JPanel();
        strosackerButtonPanel.setBounds(327, 280,70, 25);
        strosackerButton = new JButton("Strosacker");
        strosackerButton.setBackground(Color.darkGray);
        strosackerButton.setForeground(Color.white);
        strosackerButton.setFont(mapFont);

        strosackerButton.addActionListener(sHandler);
        strosackerButtonPanel.add(strosackerButton);
        con.add(strosackerButtonPanel);


        awSmithButtonPanel = new JPanel();
        awSmithButtonPanel.setBounds(367, 230,70, 25);
        awSmithButton = new JButton("A W Smith");
        awSmithButton.setBackground(Color.darkGray);
        awSmithButton.setForeground(Color.white);
        awSmithButton.setFont(mapFont);

        awSmithButton.addActionListener(sHandler);
        awSmithButtonPanel.add(awSmithButton);
        con.add(awSmithButtonPanel);


        binghamButtonPanel = new JPanel();
        binghamButtonPanel.setBounds(452, 220,70, 25);
        binghamButton = new JButton("Bingham");
        binghamButton.setBackground(Color.darkGray);
        binghamButton.setForeground(Color.white);
        binghamButton.setFont(mapFont);

        binghamButton.addActionListener(sHandler);
        binghamButtonPanel.add(binghamButton);
        con.add(binghamButtonPanel);


        crawfordButtonPanel = new JPanel();
        crawfordButtonPanel.setBounds(130, 505,70, 25);
        crawfordButton = new JButton("Crawford");
        crawfordButton.setBackground(Color.darkGray);
        crawfordButton.setForeground(Color.white);
        crawfordButton.setFont(mapFont);

        crawfordButton.addActionListener(sHandler);
        crawfordButtonPanel.add(crawfordButton);
        con.add(crawfordButtonPanel);


        eldredButtonPanel = new JPanel();
        eldredButtonPanel.setBounds(219, 315,65, 25);
        eldredButton = new JButton("Eldred");
        eldredButton.setBackground(Color.darkGray);
        eldredButton.setForeground(Color.white);
        eldredButton.setFont(mapFont);

        eldredButton.addActionListener(sHandler);
        eldredButtonPanel.add(eldredButton);
        con.add(eldredButtonPanel);


        glennanButtonPanel = new JPanel();
        glennanButtonPanel.setBounds(572, 260,70, 25);
        glennanButton = new JButton("Glennan");
        glennanButton.setBackground(Color.darkGray);
        glennanButton.setForeground(Color.white);
        glennanButton.setFont(mapFont);

        glennanButton.addActionListener(sHandler);
        glennanButtonPanel.add(glennanButton);
        con.add(glennanButtonPanel);


        khsButtonPanel = new JPanel();
        khsButtonPanel.setBounds(319, 210,50, 25);
        khsButton = new JButton("KHS");
        khsButton.setBackground(Color.darkGray);
        khsButton.setForeground(Color.white);
        khsButton.setFont(mapFont);

        khsButton.addActionListener(sHandler);
        khsButtonPanel.add(khsButton);
        con.add(khsButtonPanel);


        nordButtonPanel = new JPanel();
        nordButtonPanel.setBounds(422, 347,50, 25);
        nordButton = new JButton("Nord");
        nordButton.setBackground(Color.darkGray);
        nordButton.setForeground(Color.white);
        nordButton.setFont(mapFont);

        nordButton.addActionListener(sHandler);
        nordButtonPanel.add(nordButton);
        con.add(nordButtonPanel);


        olinButtonPanel = new JPanel();
        olinButtonPanel.setBounds(502, 313,50, 25);
        olinButton = new JButton("Olin");
        olinButton.setBackground(Color.darkGray);
        olinButton.setForeground(Color.white);
        olinButton.setFont(mapFont);

        olinButton.addActionListener(sHandler);
        olinButtonPanel.add(olinButton);
        con.add(olinButtonPanel);


        searsButtonPanel = new JPanel();
        searsButtonPanel.setBounds(442, 320,50, 25);
        searsButton = new JButton("Sears");
        searsButton.setBackground(Color.darkGray);
        searsButton.setForeground(Color.white);
        searsButton.setFont(mapFont);

        searsButton.addActionListener(sHandler);
        searsButtonPanel.add(searsButton);
        con.add(searsButtonPanel);


        tomlinsonButtonPanel = new JPanel();
        tomlinsonButtonPanel.setBounds(242, 485,70, 25);
        tomlinsonButton = new JButton("Tomlinson");
        tomlinsonButton.setBackground(Color.darkGray);
        tomlinsonButton.setForeground(Color.white);
        tomlinsonButton.setFont(mapFont);

        tomlinsonButton.addActionListener(sHandler);
        tomlinsonButtonPanel.add(tomlinsonButton);
        con.add(tomlinsonButtonPanel);


        whiteButtonPanel = new JPanel();
        whiteButtonPanel.setBounds(517, 287,50, 25);
        whiteButton = new JButton("White");
        whiteButton.setBackground(Color.darkGray);
        whiteButton.setForeground(Color.white);
        whiteButton.setFont(mapFont);

        whiteButton.addActionListener(sHandler);
        whiteButtonPanel.add(whiteButton);
        con.add(whiteButtonPanel);


        wickendenButtonPanel = new JPanel();
        wickendenButtonPanel.setBounds(342, 385,70, 25);
        wickendenButton = new JButton("Wickenden");
        wickendenButton.setBackground(Color.darkGray);
        wickendenButton.setForeground(Color.white);
        wickendenButton.setFont(mapFont);

        wickendenButton.addActionListener(sHandler);
        wickendenButtonPanel.add(wickendenButton);
        con.add(wickendenButtonPanel);


        yostButtonPanel = new JPanel();
        yostButtonPanel.setBounds(287, 440,50, 25);
        yostButton = new JButton("Yost");
        yostButton.setBackground(Color.darkGray);
        yostButton.setForeground(Color.white);
        yostButton.setFont(mapFont);

        yostButton.addActionListener(sHandler);
        yostButtonPanel.add(yostButton);
        con.add(yostButtonPanel);


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

        menuButtonPanel.setVisible(false);

        //player object/image is implemented and can be moved around
        //if at location to change maps, do so
        //if building thing
    }

    public void createNorthScreen(){
        thwingButtonPanel = new JPanel();
        thwingButtonPanel.setBounds(327, 280,70, 25);
        thwingButton = new JButton("Thwing");
        thwingButton.setBackground(Color.darkGray);
        thwingButton.setForeground(Color.white);
        thwingButton.setFont(mapFont);

        thwingButton.addActionListener(sHandler);
        thwingButtonPanel.add(thwingButton);
        con.add(thwingButtonPanel);


        tinkButtonPanel = new JPanel();
        tinkButtonPanel.setBounds(327, 280,70, 25);
        tinkButton = new JButton("TVU");
        tinkButton.setBackground(Color.darkGray);
        tinkButton.setForeground(Color.white);
        tinkButton.setFont(mapFont);

        tinkButton.addActionListener(sHandler);
        tinkButtonPanel.add(tinkButton);
        con.add(tinkButtonPanel);

        pblButtonPanel = new JPanel();
        pblButtonPanel.setBounds(327, 280,70, 25);
        pblButton = new JButton("PBL");
        pblButton.setBackground(Color.darkGray);
        pblButton.setForeground(Color.white);
        pblButton.setFont(mapFont);

        pblButton.addActionListener(sHandler);
        pblButtonPanel.add(pblButton);
        con.add(pblButtonPanel);


        kslButtonPanel = new JPanel();
        kslButtonPanel.setBounds(327, 280,70, 25);
        kslButton = new JButton("KSL");
        kslButton.setBackground(Color.darkGray);
        kslButton.setForeground(Color.white);
        kslButton.setFont(mapFont);

        kslButton.addActionListener(sHandler);
        kslButtonPanel.add(kslButton);
        con.add(kslButtonPanel);


        imagePanel.setVisible(false);

    }

    public void createSouthScreen(){
        carltonButtonPanel = new JPanel();
        carltonButtonPanel.setBounds(327, 280,70, 25);
        carltonButton = new JButton("Carlton");
        carltonButton.setBackground(Color.darkGray);
        carltonButton.setForeground(Color.white);
        carltonButton.setFont(mapFont);

        carltonButton.addActionListener(sHandler);
        carltonButtonPanel.add(carltonButton);
        con.add(carltonButtonPanel);


        elephantButtonPanel = new JPanel();
        elephantButtonPanel.setBounds(327, 280,70, 25);
        elephantButton = new JButton("Elephant Stairs");
        elephantButton.setBackground(Color.darkGray);
        elephantButton.setForeground(Color.white);
        elephantButton.setFont(mapFont);

        elephantButton.addActionListener(sHandler);
        elephantButtonPanel.add(elephantButton);
        con.add(elephantButtonPanel);

        hideBuildingButtons();
        imagePanel.setVisible(false);
    }

    public void createVealeScreen(){
        hideBuildingButtons();

        exerciseButtonPanel = new JPanel();
        exerciseButtonPanel.setBounds(100, 150,180, 50);
        exerciseButton = new JButton("Exercise at Veale");
        exerciseButton.setBackground(Color.white);
        exerciseButton.setForeground(Color.darkGray);
        exerciseButton.setFont(normalFont);

        exerciseButton.addActionListener(sHandler);
        exerciseButtonPanel.add(exerciseButton);
        con.add(exerciseButtonPanel);

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

        lectureButtonPanel = new JPanel();
        lectureButtonPanel.setBounds(100, 150,180, 50);
        lectureButton = new JButton("Attend Lecture");
        lectureButton.setBackground(Color.white);
        lectureButton.setForeground(Color.darkGray);
        lectureButton.setFont(normalFont);

        lectureButton.addActionListener(sHandler);
        lectureButtonPanel.add(lectureButton);
        con.add(lectureButtonPanel);

        image = new ImageIcon("idk/resources/Rockefeller.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        lectureButtonPanel.setVisible(false);
    }

    public void createAWSmithScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/AWSmith.jpeg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createBinghamScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Bingham.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createCarltonScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Carlton.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createCrawfordScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Crawford.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createEldredScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/eldred.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createElephantScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/elephant.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createGlennanScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/glennan.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createKHSScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/KHS.jpeg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createKSLScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/ksl.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createNordScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Nord.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createOlinScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Olin.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createPBLScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/PBL.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createSearsScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Sears.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createThwingScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/thwing.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createTinkScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/tink.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createTomlinsonScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/tomlinson.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createWhiteScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/white.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createWickendenScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Wickenden.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createYostScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/yost.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createStrosackerScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/Strosacker.jpg");
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
        healthlabel = new JLabel("Health: 1");
        healthlabel.setBackground(Color.white);
        healthlabel.setForeground(Color.darkGray);
        healthlabel.setFont(normalFont);

        hygienePanel = new JPanel();
        hygienePanel.setBounds(300, 350 ,150, 50);
        hygienelabel = new JLabel("Hygiene: 1");
        hygienelabel.setBackground(Color.white);
        hygienelabel.setForeground(Color.darkGray);
        hygienelabel.setFont(normalFont);

        intelligencePanel = new JPanel();
        intelligencePanel.setBounds(300, 300 ,150, 50);
        intelligencelabel = new JLabel("Intelligence: 1");
        intelligencelabel.setBackground(Color.white);
        intelligencelabel.setForeground(Color.darkGray);
        intelligencelabel.setFont(normalFont);

        strengthPanel = new JPanel();
        strengthPanel.setBounds(300, 250 ,150, 50);
        strengthlabel = new JLabel("Strength: 1");
        strengthlabel.setBackground(Color.white);
        strengthlabel.setForeground(Color.darkGray);
        strengthlabel.setFont(normalFont);

        socialStandingPanel = new JPanel();
        socialStandingPanel.setBounds(275, 200 ,200, 50);
        socialStandinglabel = new JLabel("Social Standing: 1");
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
        compPanel1.setVisible(false);
        compPanel2.setVisible(false);
        compPanel3.setVisible(false);
        compPanel4.setVisible(false);

        image = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);

        imageLabel.setIcon(image);

        imagePanel.setVisible(true);
        vealeButtonPanel.setVisible(true);
        millisButtonPanel.setVisible(true);
        rockButtonPanel.setVisible(true);
        strosackerButtonPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
        northButtonPanel.setVisible(true);
        southButtonPanel.setVisible(true);
        awSmithButtonPanel.setVisible(true);
        binghamButtonPanel.setVisible(true);
        carltonButtonPanel.setVisible(true);
        crawfordButtonPanel.setVisible(true);
        eldredButtonPanel.setVisible(true);
        elephantButtonPanel.setVisible(true);
        glennanButtonPanel.setVisible(true);
        khsButtonPanel.setVisible(true);
        kslButtonPanel.setVisible(true);
        nordButtonPanel.setVisible(true);
        olinButtonPanel.setVisible(true);
        pblButtonPanel.setVisible(true);
        searsButtonPanel.setVisible(true);
        thwingButtonPanel.setVisible(true);
        tinkButtonPanel.setVisible(true);
        tomlinsonButtonPanel.setVisible(true);
        whiteButtonPanel.setVisible(true);
        wickendenButtonPanel.setVisible(true);
        yostButtonPanel.setVisible(true);
    }

    public void displayNorthScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/CWRUnorthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);


        tinkButtonPanel.setVisible(true);
        thwingButtonPanel.setVisible(true);
        kslButtonPanel.setVisible(true);
        pblButtonPanel.setVisible(true);
        imagePanel.setVisible(true);
    }

    public void displaySouthScreen(){
        hideBuildingButtons();
        quadButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/CWRUsouthDots.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        carltonButtonPanel.setVisible(true);
        elephantButtonPanel.setVisible(true);
        imagePanel.setVisible(true);
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
        compPanel1.setVisible(false);
        compPanel2.setVisible(false);
        compPanel3.setVisible(false);
        compPanel4.setVisible(false);
        //lectureButtonPanel.setVisible(false);
        //exerciseButtonPanel.setVisible(false);

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

    public void createExerciseScreen(){
        exerciseButtonPanel.setVisible(false);

        image = new ImageIcon("idk/resources/gym.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        startExButtonPanel = new JPanel();
        startExButtonPanel.setBounds(300, 300 ,150, 50);
        startExButton = new JButton("Start");
        startExButton.setBackground(Color.darkGray);
        startExButton.setForeground(Color.white);
        startExButton.setFont(normalFont);

        startExButton.addActionListener(sHandler);
        startExButtonPanel.add(startExButton);
        con.add(startExButtonPanel);

        strengthlabel.setText("Strength: 2");
        reward = "Strength increased by 1";
        taskName = "Exercise at Veale";
    }

    public void createLectureScreen(){
        lectureButtonPanel.setVisible(false);

        image = new ImageIcon("idk/lecture/lecture.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        startExButtonPanel = new JPanel();
        startExButtonPanel.setBounds(300, 300 ,150, 50);
        startExButton = new JButton("Start");
        startExButton.setBackground(Color.darkGray);
        startExButton.setForeground(Color.white);
        startExButton.setFont(normalFont);

        startExButton.addActionListener(sHandler);
        startExButtonPanel.add(startExButton);
        con.add(startExButtonPanel);

        intelligencelabel.setText("Intelligence: 2");
        reward = "Intelligence increased by 1";
        taskName = "Attend Lecture";
    }

    public void createCompletionScreen(){
        compPanel1 = new JPanel();
        compPanel1.setBounds(250,150,350,50);
        compPanel1.setBackground(Color.DARK_GRAY);
        JLabel compLabel1 = new JLabel("Congratulations!");
        compLabel1.setFont(medFont);
        compLabel1.setForeground(Color.white);

        compPanel1.add(compLabel1);
        con.add(compPanel1);

        compPanel2 = new JPanel();
        compPanel2.setBounds(235,201,375,50);
        compPanel2.setBackground(Color.DARK_GRAY);
        JLabel compLabel2 = new JLabel("You Have Completed:");
        compLabel2.setFont(medFont);
        compLabel2.setForeground(Color.white);

        compPanel2.add(compLabel2);
        con.add(compPanel2);

        compPanel3 = new JPanel();
        compPanel3.setBounds(250, 275,350, 50);
        compPanel3.setBackground(Color.DARK_GRAY);
        compLabel3 = new JLabel(" ");
        compLabel3.setForeground(Color.white);
        compLabel3.setFont(medFont);

        compPanel3.add(compLabel3);
        con.add(compPanel3);

        compPanel4 = new JPanel();
        compPanel4.setBounds(240, 400 ,400, 50);
        compPanel4.setBackground(Color.DARK_GRAY);
        compLabel4 = new JLabel(" ");
        compLabel4.setForeground(Color.white);
        compLabel4.setFont(medFont);

        compPanel4.add(compLabel4);
        con.add(compPanel4);

        compPanel1.setVisible(false);
        compPanel2.setVisible(false);
        compPanel3.setVisible(false);
        compPanel4.setVisible(false);
    }

    public void displayCompletionScreen() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        compLabel3.setText(taskName);
        compLabel4.setText(reward);

        imagePanel.setVisible(false);
        startExButtonPanel.setVisible(false);
        compPanel1.setVisible(true);
        compPanel2.setVisible(true);
        compPanel3.setVisible(true);
        compPanel4.setVisible(true);
    }

    public void hideBuildingButtons(){
        vealeButtonPanel.setVisible(false);
        millisButtonPanel.setVisible(false);
        rockButtonPanel.setVisible(false);
        southButtonPanel.setVisible(false);
        northButtonPanel.setVisible(false);
        strosackerButtonPanel.setVisible(false);
        awSmithButtonPanel.setVisible(false);
        binghamButtonPanel.setVisible(false);
        carltonButtonPanel.setVisible(false);
        crawfordButtonPanel.setVisible(false);
        eldredButtonPanel.setVisible(false);
        elephantButtonPanel.setVisible(false);
        glennanButtonPanel.setVisible(false);
        khsButtonPanel.setVisible(false);
        kslButtonPanel.setVisible(false);
        nordButtonPanel.setVisible(false);
        olinButtonPanel.setVisible(false);
        pblButtonPanel.setVisible(false);
        searsButtonPanel.setVisible(false);
        thwingButtonPanel.setVisible(false);
        tinkButtonPanel.setVisible(false);
        tomlinsonButtonPanel.setVisible(false);
        whiteButtonPanel.setVisible(false);
        wickendenButtonPanel.setVisible(false);
        yostButtonPanel.setVisible(false);
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
            if(event.getSource() == strosackerButton){
                createStrosackerScreen();
            }
            if(event.getSource() == awSmithButton){
                createAWSmithScreen();
            }
            if(event.getSource() == binghamButton){
                createBinghamScreen();
            }
            if(event.getSource() == carltonButton){
                createCarltonScreen();
            }
            if(event.getSource() == crawfordButton){
                createCrawfordScreen();
            }
            if(event.getSource() == eldredButton){
                createEldredScreen();
            }
            if(event.getSource() == elephantButton){
                createElephantScreen();
            }
            if(event.getSource() == glennanButton){
                createGlennanScreen();
            }
            if(event.getSource() == khsButton){
                createKHSScreen();
            }
            if(event.getSource() == kslButton){
                createKSLScreen();
            }
            if(event.getSource() == nordButton){
                createNordScreen();
            }
            if(event.getSource() == olinButton){
                createOlinScreen();
            }
            if(event.getSource() == pblButton){
                createPBLScreen();
            }
            if(event.getSource() == searsButton){
                createSearsScreen();
            }
            if(event.getSource() == thwingButton){
                createThwingScreen();
            }
            if(event.getSource() == tinkButton){
                createTinkScreen();
            }
            if(event.getSource() == tomlinsonButton){
                createTomlinsonScreen();
            }
            if(event.getSource() == whiteButton){
                createWhiteScreen();
            }
            if(event.getSource() == wickendenButton){
                createWickendenScreen();
            }
            if(event.getSource() == yostButton){
                createYostScreen();
            }
            if(event.getSource() == northButton){
                displayNorthScreen();
            }
            if(event.getSource() == southButton){
                displaySouthScreen();
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
            if(event.getSource() == exerciseButton){
                createExerciseScreen();
            }
            if(event.getSource() == lectureButton){
                createLectureScreen();
            }
            if(event.getSource() == startExButton){
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
