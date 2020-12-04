import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class GameScreen {
    public String screenName, taskName, reward, buildingName, buildingImage,
            previousScreenName, previousScreenImage;

    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel,introTextPanel, vealeButtonPanel,
            quadButtonPanel, millisButtonPanel, rockButtonPanel, strosackerButtonPanel, awSmithButtonPanel, binghamButtonPanel,
            carltonButtonPanel, crawfordButtonPanel, eldredButtonPanel, elephantButtonPanel, northButtonPanel, southButtonPanel, gStartButtonPanel,
            menuButtonPanel, returnPanel, savePanel, menuPanel, attrButtonPanel, attrPanel, healthPanel, hygienePanel, intelligencePanel,
            strengthPanel, socialStandingPanel, glennanButtonPanel, khsButtonPanel, kslButtonPanel, nordButtonPanel, olinButtonPanel, pblButtonPanel,
            searsButtonPanel, thwingButtonPanel, tinkButtonPanel, whiteButtonPanel, wickendenButtonPanel, yostButtonPanel, tomlinsonButtonPanel, exerciseButtonPanel,
            compPanel1, compPanel2, compPanel3, compPanel4, startExButtonPanel, lectureButtonPanel,
            moveToQuadButtonPanel, denButtonPanel, freshDormsButtonPanel,
            sophDormsButtonPanel, leutnerButtonPanel, taskPanel, taskButtonPanel, buildingTextPanel, actionButtonPanel, task1Panel, task2Panel, timePanel, limagePanel,
            cimagePanel, rimagePanel, ltextPanel, ctextPanel, rtextPanel, ltextButtonPanel, ctextButtonPanel, rtextButtonPanel;
    JLabel titleNameLabel, imageLabel, intelligencelabel, healthlabel, socialStandinglabel, strengthlabel, hygienelabel, compLabel2, compLabel3, compLabel4, task1Label,
            task2Label, timeLabel, limageLabel, cimageLabel, rimageLabel, ltextLabel, ctextLabel, rtextLabel;
    JButton startButton, loadButton, vealeButton, quadButton, millisButton, strosackerButton, rockButton, northButton, southButton, gStartButton,
            menuButton, returnButton, saveButton, attrButton, awSmithButton, binghamButton, carltonButton, crawfordButton, eldredButton, elephantButton,
            glennanButton, kslButton, khsButton, nordButton, olinButton, pblButton, searsButton, thwingButton, tinkButton, tomlinsonButton, whiteButton,
            wickendenButton, yostButton, exerciseButton, startExButton, lectureButton, moveToQuadButton, denButton, taskButton,
            freshDormsButton, sophDormsButton, upperDormsButton, leutnerButton, actionButton, ltextButton, ctextButton, rtextButton;
    JTextArea introTextArea, buildingTextArea;
    JTextPane buildingTextPane;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font introFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font medFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font mapFont = new Font("Times New Roman", Font.PLAIN, 12);
    Day d;

    ImageIcon image, limage, cimage, rimage;
    ScreenDescriptions roomTextDesc = new ScreenDescriptions(buildingName);

    //sHandler is for changing the window screen from one map/building to another
    ScreenHandler sHandler = new ScreenHandler();

    Game g;
    Player p1;

    List<String> buildingNames = Arrays.asList("Bingham", "Carlton", "Crawford","Dennys","Eldred", "Elephant", "Freshman Dorms", "Glennan", "KHS", "KSL",
            "Leutner", "Millis", "Nord", "Olin", "PBL", "Rockefeller", "Sears", "Smith",
            "Sophomore Dorms", "Strosacker", "Thwing", "Tink", "Tomlinson", "Veale",
            "White", "Wickenden","Yost");
    List<String> mapNames = Arrays.asList("Quad", "Northside", "Southside");

    List<String> taskNames = Arrays.asList("Exercise", "Lecture", "Roommate");

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image home screen - intro, save, and load

        d = new Day("Monday");

        createTitleScreen();
        createIntroScreen();
        buttonInitializer();
        createCompletionScreen();
        hideBuildingButtons();


        g = new Game();
        p1 = g.getPlayer();

        //need to be able to start even if there is a saved file - give warning though
        //also give warning when trying to save over a saved file
        //if we close screen and reload, is the load file still saved?
        //image for each building
        //Will take a specfic image from a connected folder for the image
        //will also standardize the format for the buildings
    }
    //Creates and displays the game homescreen
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

    //Creates the Introduction Page, and initializes the room description box
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

        //Creates introduction text box
        introTextArea = new JTextArea(textIntro);
        introTextArea.setBounds(25,25,725,375);
        introTextArea.setFont(introFont);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);

        introTextPanel.add(introTextArea);

        timePanel = new JPanel();
        timePanel.setBounds(600,25,150,35);
        timeLabel = new JLabel("Time: " + String.valueOf(d.getHour()));
        timeLabel.setBackground(Color.white);
        timeLabel.setForeground(Color.darkGray);
        timeLabel.setFont(normalFont);

        timePanel.add(timeLabel);

        //Creates building description box
        buildingTextPanel = new JPanel();
        buildingName = "";
        buildingTextPanel.setBounds(25,440,725,100);

        String roomTextDesc = new ScreenDescriptions(buildingName).returnDesc();

        buildingTextArea = new JTextArea(roomTextDesc);
        buildingTextArea.setBounds(25,440,725,100);
        buildingTextArea.setFont(introFont);
        buildingTextArea.setLineWrap(true);
        buildingTextArea.setWrapStyleWord(true);

        buildingTextPanel.add(buildingTextArea);

        introTextPanel.setVisible(false);
        gStartButtonPanel.setVisible(false);
        buildingTextPanel.setVisible(false);
        timePanel.setVisible(false);

        con.add(buildingTextPanel);
        con.add(introTextPanel);
        con.add(gStartButtonPanel);
        con.add(timePanel);
    }

    //Following 4 methods initialize Buttons, the 1st method calls the following three methods
    //They were separated by location/purpose to make code more readable
    //this method initalizes the quad buttons and the menu buttons
    public void buttonInitializer(){
        //Menu Button
        menuButtonPanel = new JPanel();
        menuButtonPanel.setBounds(100, 50,100, 50);
        menuButton = new JButton("Menu");
        menuButton.setBackground(Color.white);
        menuButton.setForeground(Color.darkGray);
        menuButton.setFont(normalFont);

        menuButton.addActionListener(sHandler);
        menuButtonPanel.add(menuButton);
        con.add(menuButtonPanel);

        //Veale Button
        vealeButtonPanel = new JPanel();
        vealeButtonPanel.setVisible(false);
        vealeButtonPanel.setBounds(615, 100,50, 25);
        vealeButton = new JButton("Veale");
        vealeButton.setBackground(Color.darkGray);
        vealeButton.setForeground(Color.white);
        vealeButton.setFont(mapFont);

        vealeButton.addActionListener(sHandler);
        vealeButtonPanel.add(vealeButton);
        con.add(vealeButtonPanel);

        //Millis Button
        millisButtonPanel = new JPanel();
        millisButtonPanel.setVisible(false);
        millisButtonPanel.setBounds(272, 230,50, 25);
        millisButton = new JButton("Millis");
        millisButton.setBackground(Color.darkGray);
        millisButton.setForeground(Color.white);
        millisButton.setFont(mapFont);

        millisButton.addActionListener(sHandler);
        millisButtonPanel.add(millisButton);
        con.add(millisButtonPanel);

        //Rockefeller Button
        rockButtonPanel = new JPanel();
        rockButtonPanel.setVisible(false);
        rockButtonPanel.setBounds(287, 320,70, 25);
        rockButton = new JButton("Rockefeller");
        rockButton.setBackground(Color.darkGray);
        rockButton.setForeground(Color.white);
        rockButton.setFont(mapFont);

        rockButton.addActionListener(sHandler);
        rockButtonPanel.add(rockButton);
        con.add(rockButtonPanel);

        //Strosacker Button
        strosackerButtonPanel = new JPanel();
        strosackerButtonPanel.setVisible(false);
        strosackerButtonPanel.setBounds(327, 280,70, 25);
        strosackerButton = new JButton("Strosacker");
        strosackerButton.setBackground(Color.darkGray);
        strosackerButton.setForeground(Color.white);
        strosackerButton.setFont(mapFont);

        strosackerButton.addActionListener(sHandler);
        strosackerButtonPanel.add(strosackerButton);
        con.add(strosackerButtonPanel);

        //AW Smith Button
        awSmithButtonPanel = new JPanel();
        awSmithButtonPanel.setVisible(false);
        awSmithButtonPanel.setBounds(367, 230,70, 25);
        awSmithButton = new JButton("AW Smith");
        awSmithButton.setBackground(Color.darkGray);
        awSmithButton.setForeground(Color.white);
        awSmithButton.setFont(mapFont);

        awSmithButton.addActionListener(sHandler);
        awSmithButtonPanel.add(awSmithButton);
        con.add(awSmithButtonPanel);

        //Bingham Button
        binghamButtonPanel = new JPanel();
        binghamButtonPanel.setVisible(false);
        binghamButtonPanel.setBounds(452, 220,70, 25);
        binghamButton = new JButton("Bingham");
        binghamButton.setBackground(Color.darkGray);
        binghamButton.setForeground(Color.white);
        binghamButton.setFont(mapFont);

        binghamButton.addActionListener(sHandler);
        binghamButtonPanel.add(binghamButton);
        con.add(binghamButtonPanel);

        //Crawford Button
        crawfordButtonPanel = new JPanel();
        crawfordButtonPanel.setVisible(false);
        crawfordButtonPanel.setBounds(130, 505,70, 25);
        crawfordButton = new JButton("Crawford");
        crawfordButton.setBackground(Color.darkGray);
        crawfordButton.setForeground(Color.white);
        crawfordButton.setFont(mapFont);

        crawfordButton.addActionListener(sHandler);
        crawfordButtonPanel.add(crawfordButton);
        con.add(crawfordButtonPanel);

        //Eldred Button
        eldredButtonPanel = new JPanel();
        eldredButtonPanel.setVisible(false);
        eldredButtonPanel.setBounds(219, 315,65, 25);
        eldredButton = new JButton("Eldred");
        eldredButton.setBackground(Color.darkGray);
        eldredButton.setForeground(Color.white);
        eldredButton.setFont(mapFont);

        eldredButton.addActionListener(sHandler);
        eldredButtonPanel.add(eldredButton);
        con.add(eldredButtonPanel);

        //Glennan Button
        glennanButtonPanel = new JPanel();
        glennanButtonPanel.setVisible(false);
        glennanButtonPanel.setBounds(572, 260,70, 25);
        glennanButton = new JButton("Glennan");
        glennanButton.setBackground(Color.darkGray);
        glennanButton.setForeground(Color.white);
        glennanButton.setFont(mapFont);

        glennanButton.addActionListener(sHandler);
        glennanButtonPanel.add(glennanButton);
        con.add(glennanButtonPanel);

        //Virus Button
        khsButtonPanel = new JPanel();
        khsButtonPanel.setVisible(false);
        khsButtonPanel.setBounds(319, 210,50, 25);
        khsButton = new JButton("KHS");
        khsButton.setBackground(Color.darkGray);
        khsButton.setForeground(Color.white);
        khsButton.setFont(mapFont);

        khsButton.addActionListener(sHandler);
        khsButtonPanel.add(khsButton);
        con.add(khsButtonPanel);

        //Nord Button
        nordButtonPanel = new JPanel();
        nordButtonPanel.setVisible(false);
        nordButtonPanel.setBounds(422, 347,50, 25);
        nordButton = new JButton("Nord");
        nordButton.setBackground(Color.darkGray);
        nordButton.setForeground(Color.white);
        nordButton.setFont(mapFont);

        nordButton.addActionListener(sHandler);
        nordButtonPanel.add(nordButton);
        con.add(nordButtonPanel);

        //Olin Button
        olinButtonPanel = new JPanel();
        olinButtonPanel.setVisible(false);
        olinButtonPanel.setBounds(502, 313,50, 25);
        olinButton = new JButton("Olin");
        olinButton.setBackground(Color.darkGray);
        olinButton.setForeground(Color.white);
        olinButton.setFont(mapFont);

        olinButton.addActionListener(sHandler);
        olinButtonPanel.add(olinButton);
        con.add(olinButtonPanel);

        //Sears Button
        searsButtonPanel = new JPanel();
        searsButtonPanel.setVisible(false);
        searsButtonPanel.setBounds(442, 320,50, 25);
        searsButton = new JButton("Sears");
        searsButton.setBackground(Color.darkGray);
        searsButton.setForeground(Color.white);
        searsButton.setFont(mapFont);

        searsButton.addActionListener(sHandler);
        searsButtonPanel.add(searsButton);
        con.add(searsButtonPanel);

        //Tomlinson Button
        tomlinsonButtonPanel = new JPanel();
        tomlinsonButtonPanel.setVisible(false);
        tomlinsonButtonPanel.setBounds(242, 485,70, 25);
        tomlinsonButton = new JButton("Tomlinson");
        tomlinsonButton.setBackground(Color.darkGray);
        tomlinsonButton.setForeground(Color.white);
        tomlinsonButton.setFont(mapFont);

        tomlinsonButton.addActionListener(sHandler);
        tomlinsonButtonPanel.add(tomlinsonButton);
        con.add(tomlinsonButtonPanel);

        //White Button
        whiteButtonPanel = new JPanel();
        whiteButtonPanel.setVisible(false);
        whiteButtonPanel.setBounds(517, 287,50, 25);
        whiteButton = new JButton("White");
        whiteButton.setBackground(Color.darkGray);
        whiteButton.setForeground(Color.white);
        whiteButton.setFont(mapFont);

        whiteButton.addActionListener(sHandler);
        whiteButtonPanel.add(whiteButton);
        con.add(whiteButtonPanel);

        //Wickenden Button
        wickendenButtonPanel = new JPanel();
        wickendenButtonPanel.setVisible(false);
        wickendenButtonPanel.setBounds(342, 385,70, 25);
        wickendenButton = new JButton("Wickenden");
        wickendenButton.setBackground(Color.darkGray);
        wickendenButton.setForeground(Color.white);
        wickendenButton.setFont(mapFont);

        wickendenButton.addActionListener(sHandler);
        wickendenButtonPanel.add(wickendenButton);
        con.add(wickendenButtonPanel);

        //Yost Button
        yostButtonPanel = new JPanel();
        yostButtonPanel.setVisible(false);
        yostButtonPanel.setBounds(287, 440,50, 25);
        yostButton = new JButton("Yost");
        yostButton.setBackground(Color.darkGray);
        yostButton.setForeground(Color.white);
        yostButton.setFont(mapFont);

        yostButton.addActionListener(sHandler);
        yostButtonPanel.add(yostButton);
        con.add(yostButtonPanel);

        //Return to quad (from a building)
        quadButtonPanel = new JPanel();
        quadButtonPanel.setVisible(false);
        quadButtonPanel.setBounds(100, 100, 180, 50);
        quadButton = new JButton("Return to Quad");
        quadButton.setBackground(Color.white);
        quadButton.setForeground(Color.darkGray);
        quadButton.setFont(normalFont);
        quadButtonPanel.setVisible(false);

        quadButton.addActionListener(sHandler);
        quadButtonPanel.add(quadButton);
        con.add(quadButtonPanel);

        //North or South to quad
        moveToQuadButtonPanel = new JPanel();
        moveToQuadButtonPanel.setVisible(false);
        moveToQuadButtonPanel.setBounds(650,355,55,25);
        moveToQuadButton = new JButton("Quad");
        moveToQuadButton.setBackground(Color.darkGray);
        moveToQuadButton.setForeground(Color.white);
        moveToQuadButton.setFont(mapFont);

        moveToQuadButton.addActionListener(sHandler);
        moveToQuadButtonPanel.add(moveToQuadButton);
        con.add(moveToQuadButtonPanel);

        initializeTaskButtons();
        northButtonsInit();
        southButtonsInit();
        initializeMenuButtons();

        con.add(imagePanel);
        imagePanel.setVisible(false);

        menuButtonPanel.setVisible(false);
    }
    //initalizes buttons on northside
    public void northButtonsInit(){
        //Go to northside button
        northButtonPanel = new JPanel();
        northButtonPanel.setVisible(false);
        northButtonPanel.setBounds(25, 425,70, 25);
        northButton = new JButton("Northside");
        northButton.setBackground(Color.darkGray);
        northButton.setForeground(Color.white);
        northButton.setFont(mapFont);

        northButton.addActionListener(sHandler);
        northButtonPanel.add(northButton);
        con.add(northButtonPanel);

        //Denny's
        denButtonPanel = new JPanel();
        denButtonPanel.setVisible(false);
        denButtonPanel.setBounds(220, 140,50, 25);
        denButton = new JButton("Den");
        denButton.setBackground(Color.darkGray);
        denButton.setForeground(Color.white);
        denButton.setFont(mapFont);

        denButton.addActionListener(sHandler);
        denButtonPanel.add(denButton);
        con.add(denButtonPanel);

        //Freshman Dorms
        freshDormsButtonPanel = new JPanel();
        freshDormsButtonPanel.setVisible(false);
        freshDormsButtonPanel.setBounds(120, 110,120, 25);
        freshDormsButton = new JButton("Freshman Dorms");
        freshDormsButton.setBackground(Color.darkGray);
        freshDormsButton.setForeground(Color.white);
        freshDormsButton.setFont(mapFont);

        freshDormsButton.addActionListener(sHandler);
        freshDormsButtonPanel.add(freshDormsButton);
        con.add(freshDormsButtonPanel);

        //Leutner
        leutnerButtonPanel = new JPanel();
        leutnerButtonPanel.setVisible(false);
        leutnerButtonPanel.setBounds(80, 130,65, 25);
        leutnerButton = new JButton("Leutner");
        leutnerButton.setBackground(Color.darkGray);
        leutnerButton.setForeground(Color.white);
        leutnerButton.setFont(mapFont);

        leutnerButton.addActionListener(sHandler);
        leutnerButtonPanel.add(leutnerButton);
        con.add(leutnerButtonPanel);

        //PBL
        pblButtonPanel = new JPanel();
        pblButtonPanel.setVisible(false);
        pblButtonPanel.setBounds(395, 290,55, 25);
        pblButton = new JButton("PBL");
        pblButton.setBackground(Color.darkGray);
        pblButton.setForeground(Color.white);
        pblButton.setFont(mapFont);

        pblButton.addActionListener(sHandler);
        pblButtonPanel.add(pblButton);
        con.add(pblButtonPanel);

        //Thwing
        thwingButtonPanel = new JPanel();
        thwingButtonPanel.setVisible(false);
        thwingButtonPanel.setBounds(605, 315,60, 25);
        thwingButton = new JButton("Thwing");
        thwingButton.setBackground(Color.darkGray);
        thwingButton.setForeground(Color.white);
        thwingButton.setFont(mapFont);

        thwingButton.addActionListener(sHandler);
        thwingButtonPanel.add(thwingButton);
        con.add(thwingButtonPanel);

        //Tink
        tinkButtonPanel = new JPanel();
        tinkButtonPanel.setVisible(false);
        tinkButtonPanel.setBounds(540, 355,55, 25);
        tinkButton = new JButton("TVU");
        tinkButton.setBackground(Color.darkGray);
        tinkButton.setForeground(Color.white);
        tinkButton.setFont(mapFont);

        tinkButton.addActionListener(sHandler);
        tinkButtonPanel.add(tinkButton);
        con.add(tinkButtonPanel);

        //KSL
        kslButtonPanel = new JPanel();
        kslButtonPanel.setVisible(false);
        kslButtonPanel.setBounds(615, 430,55, 25);
        kslButton = new JButton("KSL");
        kslButton.setBackground(Color.darkGray);
        kslButton.setForeground(Color.white);
        kslButton.setFont(mapFont);

        kslButton.addActionListener(sHandler);
        kslButtonPanel.add(kslButton);
        con.add(kslButtonPanel);
    }
    //initalizes buttons on southside
    public void southButtonsInit(){
        //Go to southside button
        southButtonPanel = new JPanel();
        southButtonPanel.setVisible(false);
        southButtonPanel.setBounds(375, 25,70, 25);
        southButton = new JButton("Southside");
        southButton.setBackground(Color.darkGray);
        southButton.setForeground(Color.white);
        southButton.setFont(mapFont);

        southButton.addActionListener(sHandler);
        southButtonPanel.add(southButton);
        con.add(southButtonPanel);

        //Carlton Commons
        carltonButtonPanel = new JPanel();
        carltonButtonPanel.setVisible(false);
        carltonButtonPanel.setBounds(575, 405,60, 25);
        carltonButton = new JButton("Carlton");
        carltonButton.setBackground(Color.darkGray);
        carltonButton.setForeground(Color.white);
        carltonButton.setFont(mapFont);

        carltonButton.addActionListener(sHandler);
        carltonButtonPanel.add(carltonButton);
        con.add(carltonButtonPanel);

        //Elephant Stairs
        elephantButtonPanel = new JPanel();
        elephantButtonPanel.setVisible(false);
        elephantButtonPanel.setBounds(455, 435,70, 25);
        elephantButton = new JButton("Elephant Stairs");
        elephantButton.setBackground(Color.darkGray);
        elephantButton.setForeground(Color.white);
        elephantButton.setFont(mapFont);

        elephantButton.addActionListener(sHandler);
        elephantButtonPanel.add(elephantButton);
        con.add(elephantButtonPanel);

        //Sophomore Button
        sophDormsButtonPanel = new JPanel();
        sophDormsButtonPanel.setVisible(false);
        sophDormsButtonPanel.setBounds(500, 250,120, 25);
        sophDormsButton = new JButton("Sophomore Dorms");
        sophDormsButton.setBackground(Color.darkGray);
        sophDormsButton.setForeground(Color.white);
        sophDormsButton.setFont(mapFont);

        sophDormsButton.addActionListener(sHandler);
        sophDormsButtonPanel.add(sophDormsButton);
        con.add(sophDormsButtonPanel);
    }
    //initalizes buttons relating to tasks
    public void initializeTaskButtons(){
        actionButtonPanel = new JPanel();
        actionButtonPanel.setVisible(false);
        actionButtonPanel.setBounds(100, 150,180, 50);
        actionButton = new JButton("");
        actionButton.setBackground(Color.white);
        actionButton.setForeground(Color.darkGray);
        actionButton.setFont(normalFont);

        actionButton.addActionListener(sHandler);
        actionButtonPanel.add(actionButton);
        con.add(actionButtonPanel);

        //Exercise Task Room Change
        exerciseButtonPanel = new JPanel();
        exerciseButtonPanel.setVisible(false);
        exerciseButtonPanel.setBounds(100, 150,180, 50);
        exerciseButton = new JButton("Exercise at Veale");
        exerciseButton.setBackground(Color.white);
        exerciseButton.setForeground(Color.darkGray);
        exerciseButton.setFont(normalFont);

        exerciseButton.addActionListener(sHandler);
        exerciseButtonPanel.add(exerciseButton);
        con.add(exerciseButtonPanel);

        //Start Exercise Task
        startExButtonPanel = new JPanel();
        startExButtonPanel.setVisible(false);
        startExButtonPanel.setBounds(300, 300 ,150, 50);
        startExButton = new JButton("Start");
        startExButton.setBackground(Color.darkGray);
        startExButton.setForeground(Color.white);
        startExButton.setFont(normalFont);

        startExButton.addActionListener(sHandler);
        startExButtonPanel.add(startExButton);
        con.add(startExButtonPanel);

        //Change to lecture room
        lectureButtonPanel = new JPanel();
        lectureButtonPanel.setVisible(false);
        lectureButtonPanel.setBounds(100, 150,180, 50);
        lectureButton = new JButton("Attend Lecture");
        lectureButton.setBackground(Color.white);
        lectureButton.setForeground(Color.darkGray);
        lectureButton.setFont(normalFont);

        lectureButton.addActionListener(sHandler);
        lectureButtonPanel.add(lectureButton);
        con.add(lectureButtonPanel);
    }

    public void initializeMenuButtons(){
        createAttributesScreen();
        createTaskScreen();
        createMenuScreen();
    }

    //Following method creates the general building screen
    public void displayBuildingScreen(){
        hideEverything();
        quadButtonPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
        String roomTextDesc = new ScreenDescriptions(buildingName).returnDesc();

        buildingTextArea.setText(roomTextDesc);
        buildingTextPanel.setVisible(true);
        actionButtonPanel.setVisible(true);

        image = new ImageIcon(buildingImage);
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        imagePanel.setVisible(true);

        previousScreenName = buildingName;
        previousScreenImage = buildingImage;
    }

    //creates task screen
    public void createTaskScreen(){
        taskPanel = new JPanel();
        taskPanel.setBounds(250,100,350,100);
        taskPanel.setBackground(Color.DARK_GRAY);
        JLabel taskLabel = new JLabel("Task List");
        taskLabel.setFont(titleFont);
        taskLabel.setForeground(Color.white);

        taskPanel.add(taskLabel);

        task1Panel = new JPanel();
        task1Panel.setBounds(300, 200 ,250, 50);
        //String task1 = "task1: " + String.valueOf(g.getPlayer().getAttributeVal("task1"));
        task1Label = new JLabel("");
        task1Label.setBackground(Color.white);
        task1Label.setForeground(Color.darkGray);
        task1Label.setFont(normalFont);

        task1Panel.add(task1Label);

        task2Panel = new JPanel();
        task2Panel.setBounds(300, 250 ,250, 50);
        //String task2 = "task2: " + String.valueOf(g.getPlayer().getAttributeVal("task2"));
        task2Label = new JLabel("");
        task2Label.setBackground(Color.white);
        task2Label.setForeground(Color.darkGray);
        task2Label.setFont(normalFont);

        task2Panel.add(task2Label);

        con.add(taskPanel);
        con.add(task1Panel);
        con.add(task2Panel);

        taskPanel.setVisible(false);
        task1Panel.setVisible(false);
        task2Panel.setVisible(false);
    }

    //creates the menu screen
    public void createMenuScreen(){
        menuPanel = new JPanel();
        menuPanel.setBounds(120,150,550,100);
        menuPanel.setBackground(Color.DARK_GRAY);
        JLabel menuLabel = new JLabel("Menu");
        menuLabel.setFont(titleFont);
        menuLabel.setForeground(Color.white);

        taskButtonPanel = new JPanel();
        taskButtonPanel.setBounds(275, 300,200, 50);
        taskButton = new JButton("Task List");
        taskButton.setBackground(Color.darkGray);
        taskButton.setForeground(Color.white);
        taskButton.setFont(normalFont);

        taskButton.addActionListener(sHandler);
        taskButtonPanel.add(taskButton);
        con.add(taskButtonPanel);

        savePanel = new JPanel();
        savePanel.setBounds(300, 250 ,150, 50);
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
        con.add(taskButtonPanel);

        menuPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        taskButtonPanel.setVisible(false);
    }

    public void createAttributesScreen(){
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

    //following methods respectively display the quad, northside, southside, menu, and attribute windows
    public void displayMapScreen(){
        hideEverything();
        buildingTextPanel.setVisible(false);

        image = new ImageIcon(buildingImage);
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);

        switch(buildingName) {
            case "Quad":
                introTextPanel.setVisible(false);
                gStartButtonPanel.setVisible(false);

                image.setImage(resizedImage);
                imageLabel.setIcon(image);
                displayQuadBuildings();
                break;
            case "Northside":
                imagePanel.setBounds(-10, 45, 800, 600);
                moveToQuadButtonPanel.setBounds(700, 355, 55, 25);
                resizedImage = getScaledImage(image.getImage(), 800, 450);
                image.setImage(resizedImage);
                imageLabel.setIcon(image);
                displayNorthBuildings();
                break;
            case "Southside":
                moveToQuadButtonPanel.setBounds(350,530,55,25);
                resizedImage = getScaledImage(image.getImage(), 518, 585);
                image.setImage(resizedImage);
                imageLabel.setIcon(image);
                displaySouthBuildings();
                break;
        }

        imagePanel.setVisible(true);
        timePanel.setVisible(true);

        previousScreenName = buildingName;
        previousScreenImage = buildingImage;
    }

    public void displayMenuScreen(){
        imagePanel.setVisible(false);
        quadButtonPanel.setVisible(false);
        buildingTextPanel.setVisible(false);
        hideBuildingButtons();
        hideTaskButtons();
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
        taskPanel.setVisible(false);
        task1Panel.setVisible(false);
        task2Panel.setVisible(false);

        menuPanel.setVisible(true);
        savePanel.setVisible(true);
        returnPanel.setVisible(true);
        attrButtonPanel.setVisible(true);
        taskButtonPanel.setVisible(true);
    }

    public void displayAttrScreen(){
        healthlabel.setText("Health: " + String.valueOf(g.getPlayer().getAttributeVal("Health")));
        strengthlabel.setText("Strength: " + String.valueOf(g.getPlayer().getAttributeVal("Strength")));
        hygienelabel.setText("Hygiene: " + String.valueOf(g.getPlayer().getAttributeVal("Hygiene")));
        intelligencelabel.setText("Intelligence: " + String.valueOf(g.getPlayer().getAttributeVal("Intelligence")));
        socialStandinglabel.setText("Social Standing: " + String.valueOf(g.getPlayer().getAttributeVal("SocialStanding")));

        menuPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        taskButtonPanel.setVisible(false);
        attrPanel.setVisible(true);
        healthPanel.setVisible(true);
        hygienePanel.setVisible(true);
        intelligencePanel.setVisible(true);
        strengthPanel.setVisible(true);
        socialStandingPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
    }

    public void displayTaskScreen(){
        ArrayList<Task> tasks = g.getCurrent().getTasks();

        task1Label.setText(tasks.get(0).getName());
        task2Label.setText(tasks.get(1).getName());
        menuPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        taskButtonPanel.setVisible(false);

        taskPanel.setVisible(true);
        task1Panel.setVisible(true);
        task2Panel.setVisible(true);
        menuButtonPanel.setVisible(true);
    }

    //task related screens
    public void createExerciseScreen(){
        //I want to either move screen initializations to a new class to call
        //I want to give tasks and building buttons different handlers. They'll do the same thing but it'll be easier
        // to look at
        //I want a separate taskButtonHide method
        actionButtonPanel.setVisible(false);
        startExButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/gym.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        g.getPlayer().setAttributeVal("Strength", g.getPlayer().getAttributeVal("Strength") + 1);
        reward = "Strength increased by 1";
        taskName = "Exercise at Veale";
    }

    public void createLectureScreen(){
        actionButtonPanel.setVisible(false);
        startExButtonPanel.setVisible(true);

        image = new ImageIcon("idk/resources/lecture.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        g.getPlayer().setAttributeVal("Intelligence", g.getPlayer().getAttributeVal("Intelligence") + 1);
        reward = "Intelligence increased by 1";
        taskName = "Attend Lecture";
    }

    public void createChoiceTaskScreen(){
        actionButtonPanel.setVisible(false);
        imagePanel.setVisible(false);

        limagePanel = new JPanel();
        limagePanel.setBounds(100,300,100,100);
        limageLabel = new JLabel();
        limage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedLImage = getScaledImage(limage.getImage(), 100, 100);
        limage.setImage(resizedLImage);
        limageLabel.setIcon(image);
        limagePanel.add(imageLabel);
        con.add(limagePanel);


        cimagePanel = new JPanel();
        cimagePanel.setBounds(300,300,100,100);
        cimageLabel = new JLabel();
        cimage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedCImage = getScaledImage(cimage.getImage(), 100, 100);
        cimage.setImage(resizedCImage);
        cimageLabel.setIcon(image);
        cimagePanel.add(imageLabel);
        con.add(cimagePanel);


        rimagePanel = new JPanel();
        rimagePanel.setBounds(500,300,100,100);
        rimageLabel = new JLabel();
        rimage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedRImage = getScaledImage(rimage.getImage(), 100, 100);
        rimage.setImage(resizedRImage);
        rimageLabel.setIcon(image);
        rimagePanel.add(imageLabel);
        con.add(rimagePanel);


        ltextPanel = new JPanel();
        ltextPanel.setBounds(100, 500 ,150, 50);
        ltextLabel = new JLabel("ltext");
        ltextLabel.setBackground(Color.white);
        ltextLabel.setForeground(Color.darkGray);
        ltextLabel.setFont(normalFont);
        ltextPanel.add(ltextLabel);
        con.add(ltextPanel);

        ctextPanel = new JPanel();
        ctextPanel.setBounds(300, 500 ,150, 50);
        ctextLabel = new JLabel("ctext");
        ctextLabel.setBackground(Color.white);
        ctextLabel.setForeground(Color.darkGray);
        ctextLabel.setFont(normalFont);
        ctextPanel.add(ctextLabel);
        con.add(ctextPanel);

        rtextPanel = new JPanel();
        rtextPanel.setBounds(500, 500 ,150, 50);
        rtextLabel = new JLabel("rtext");
        rtextLabel.setBackground(Color.white);
        rtextLabel.setForeground(Color.darkGray);
        rtextLabel.setFont(normalFont);
        rtextPanel.add(rtextLabel);
        con.add(rtextPanel);


        ltextButtonPanel = new JPanel();
        ltextButtonPanel.setBounds(100, 550 ,150, 50);
        ltextButton = new JButton("ltextButton");
        ltextButton.setBackground(Color.white);
        ltextButton.setForeground(Color.darkGray);
        ltextButton.setFont(normalFont);
        ltextButtonPanel.add(ltextButton);
        con.add(ltextButtonPanel);


        ctextButtonPanel = new JPanel();
        ctextButtonPanel.setBounds(300, 550 ,150, 50);
        ctextButton = new JButton("ctextButton");
        ctextButton.setBackground(Color.white);
        ctextButton.setForeground(Color.darkGray);
        ctextButton.setFont(normalFont);
        ctextButtonPanel.add(ctextButton);
        con.add(ctextButtonPanel);


        rtextButtonPanel = new JPanel();
        rtextButtonPanel.setBounds(500, 550 ,150, 50);
        rtextButton = new JButton("rtextButton");
        rtextButton.setBackground(Color.white);
        rtextButton.setForeground(Color.darkGray);
        rtextButton.setFont(normalFont);
        rtextButtonPanel.add(rtextButton);
        con.add(rtextButtonPanel);
        

    }

    //creates a screen when a task is completed
    public void createCompletionScreen(){
        compPanel1 = new JPanel();
        compPanel1.setBounds(245,150,350,50);
        compPanel1.setBackground(Color.DARK_GRAY);
        JLabel compLabel1 = new JLabel("Congratulations!");
        compLabel1.setFont(medFont);
        compLabel1.setForeground(Color.white);

        compPanel1.add(compLabel1);
        con.add(compPanel1);

        compPanel2 = new JPanel();
        compPanel2.setBounds(230,201,375,50);
        compPanel2.setBackground(Color.DARK_GRAY);
        compLabel2 = new JLabel("You Have Completed:");
        compLabel2.setFont(medFont);
        compLabel2.setForeground(Color.white);

        compPanel2.add(compLabel2);
        con.add(compPanel2);

        compPanel3 = new JPanel();
        compPanel3.setBounds(245, 275,350, 50);
        compPanel3.setBackground(Color.DARK_GRAY);
        compLabel3 = new JLabel(" ");
        compLabel3.setForeground(Color.white);
        compLabel3.setFont(medFont);

        compPanel3.add(compLabel3);
        con.add(compPanel3);

        compPanel4 = new JPanel();
        compPanel4.setBounds(165, 400 ,500, 50);
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
        TimeUnit.SECONDS.sleep(1);

        compLabel3.setText(taskName);
        compLabel4.setText(reward);

        imagePanel.setVisible(false);
        startExButtonPanel.setVisible(false);
        compPanel1.setVisible(true);
        compPanel2.setVisible(true);
        compPanel3.setVisible(true);
        compPanel4.setVisible(true);
    }

    public void winScreen(){
        hideEverything();
        menuButtonPanel.setVisible(false);
        quadButtonPanel.setVisible(false);
        timePanel.setVisible(false);
        buildingTextPanel.setVisible(false);

        compPanel1.setVisible(true);
        compLabel2.setText("You Win!");
        startExButtonPanel.setBounds(310, 300 ,200, 50);
        startExButton.setText("Click to Continue");

        imagePanel.setVisible(false);
        startExButtonPanel.setVisible(true);
        compPanel1.setVisible(true);
        compPanel2.setVisible(true);
    }


    public void displayQuadBuildings(){
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
        crawfordButtonPanel.setVisible(true);
        eldredButtonPanel.setVisible(true);
        glennanButtonPanel.setVisible(true);
        khsButtonPanel.setVisible(true);
        nordButtonPanel.setVisible(true);
        olinButtonPanel.setVisible(true);
        searsButtonPanel.setVisible(true);
        tomlinsonButtonPanel.setVisible(true);
        whiteButtonPanel.setVisible(true);
        wickendenButtonPanel.setVisible(true);
        yostButtonPanel.setVisible(true);
    }

    public void displayNorthBuildings(){
        denButtonPanel.setVisible(true);
        freshDormsButtonPanel.setVisible(true);
        leutnerButtonPanel.setVisible(true);
        tinkButtonPanel.setVisible(true);
        thwingButtonPanel.setVisible(true);
        kslButtonPanel.setVisible(true);
        pblButtonPanel.setVisible(true);
        moveToQuadButtonPanel.setVisible(true);
    }

    public void displaySouthBuildings(){
        sophDormsButtonPanel.setVisible(true);
        carltonButtonPanel.setVisible(true);
        elephantButtonPanel.setVisible(true);
        moveToQuadButtonPanel.setVisible(true);
    }

    public void hideEverything(){
        hideBuildingButtons();
        hideTaskButtons();
        hideMenuButtons();
        buildingTextPanel.setVisible(false);
    }

    //hides all building related buttons
    public void hideBuildingButtons(){
        moveToQuadButtonPanel.setVisible(false);
        southButtonPanel.setVisible(false);
        northButtonPanel.setVisible(false);
        awSmithButtonPanel.setVisible(false);
        binghamButtonPanel.setVisible(false);
        carltonButtonPanel.setVisible(false);
        crawfordButtonPanel.setVisible(false);
        denButtonPanel.setVisible(false);
        eldredButtonPanel.setVisible(false);
        elephantButtonPanel.setVisible(false);
        freshDormsButtonPanel.setVisible(false);
        glennanButtonPanel.setVisible(false);
        khsButtonPanel.setVisible(false);
        kslButtonPanel.setVisible(false);
        leutnerButtonPanel.setVisible(false);
        millisButtonPanel.setVisible(false);
        nordButtonPanel.setVisible(false);
        olinButtonPanel.setVisible(false);
        pblButtonPanel.setVisible(false);
        rockButtonPanel.setVisible(false);
        searsButtonPanel.setVisible(false);
        sophDormsButtonPanel.setVisible(false);
        strosackerButtonPanel.setVisible(false);
        thwingButtonPanel.setVisible(false);
        tinkButtonPanel.setVisible(false);
        tomlinsonButtonPanel.setVisible(false);
        vealeButtonPanel.setVisible(false);
        whiteButtonPanel.setVisible(false);
        wickendenButtonPanel.setVisible(false);
        yostButtonPanel.setVisible(false);

        lectureButtonPanel.setVisible(false);
        exerciseButtonPanel.setVisible(false);
        startExButtonPanel.setVisible(false);
        exerciseButtonPanel.setVisible(false);
        actionButtonPanel.setVisible(false);
    }

    //hides all task related buttons
    public void hideTaskButtons(){
        taskPanel.setVisible(false);
        task1Panel.setVisible(false);
        task2Panel.setVisible(false);

        lectureButtonPanel.setVisible(false);
        exerciseButtonPanel.setVisible(false);
        startExButtonPanel.setVisible(false);
        exerciseButtonPanel.setVisible(false);
        actionButtonPanel.setVisible(false);
    }

    //hides all menu related button, used so that 'return' will go to previous screen
    public void hideMenuButtons(){
        menuPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        taskButtonPanel.setVisible(false);
    }

    //Scales an image to be a specific height and width
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImage;
    }
    //checks whether a list of buttons contains a specific button
    public boolean containsButton(JButton[] buttonList, Object objectName){
        boolean isContained = false;
        //add conditional about whether object is a button
        if(objectName instanceof JButton) {
            for (JButton jButton : buttonList) {
                if (jButton.equals(objectName)) {
                    isContained = true;
                    break;
                }
            }
        }
        return isContained;
    }

    public class ScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            //Need to add a manner which differentiates between start/load
            buildingName = "";
            imagePanel.setBounds(-10,-10,800,600);
            if(event.getSource() == startButton){ //Display the introduction
                displayIntroScreen();
            }

            if(taskNames.contains(buildingName)){//when player completes a task, show the task completion screen
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Move to quad from intro screen, building, map, or menu
            JButton[] quadButtonList = {gStartButton,quadButton,moveToQuadButton};
            if(containsButton(quadButtonList, event.getSource())){
                buildingName = "Quad";
                buildingImage = "idk/resources/CWRUquadDots.jpg";
            }
            if(event.getSource() == northButton){ //go to northside
                buildingName = "Northside";
                buildingImage = "idk/resources/CWRUnorthDots.jpg";
            }
            if(event.getSource() == southButton){ //go to southside
                buildingName = "Southside";
                buildingImage = "idk/resources/CWRUsouthDots.jpg";
            }
            if(event.getSource() == awSmithButton){ //Enter AW Smith
                buildingName = "Smith";
                buildingImage = "idk/resources/smith.jpg";
            }
            if(event.getSource() == binghamButton){ // Enter Bingham
                buildingName = "Bingham";
                buildingImage = "idk/resources/bingham.jpg";
            }
            if(event.getSource() == carltonButton){ // Enter Carlton Commons
                buildingName = "Carlton";
                buildingImage = "idk/resources/carlton.jpg";
                actionButton.setText("Eat");
                //createCarltonScreen();
            }
            if(event.getSource() == crawfordButton){ //Enter Crawford
                buildingName = "Crawford";
                buildingImage = "idk/resources/Crawford.jpg";
            }
            if(event.getSource() == denButton){ //The Den
                buildingName = "Dennys";
                buildingImage = "idk/resources/dennys.jpg";
                actionButton.setText("Eat");
                //createDenScreen();
            }
            if(event.getSource() == eldredButton){ //Enter Eldred
                buildingName = "Eldred";
                buildingImage = "idk/resources/eldred.jpg";
                actionButton.setText("Practice acting");
                //createEldredScreen();
            }
            if(event.getSource() == elephantButton){ //Elephant Stairs
                buildingName = "Elephant";
                buildingImage = "idk/resources/elephant.jpg";
                actionButton.setText("Walk up steps");
                //createElephantScreen();
            }
            if(event.getSource() == freshDormsButton){ //Freshman Dorms
                buildingName = "Freshman Dorms";
                buildingImage = "idk/resources/freshDorms.jfif";
                actionButton.setText("Choose Roommate");
                //createFreshmanDormsScreen();
            }
            if(event.getSource() == glennanButton){ //Enter Glennan
                buildingName = "Glennan";
                buildingImage = "idk/resources/glennan.jpg";
            }
            if(event.getSource() == khsButton){//Enter Kent Hale Smith, the Virus
                buildingName = "KHS";
                buildingImage = "idk/resources/KHS.jpeg";
            }
            if(event.getSource() == kslButton){//Enter KSL
                buildingName = "KSL";
                buildingImage = "idk/resources/KSL.jpg";
                actionButton.setText("Study");
                //createKSLScreen();
            }
            if(event.getSource() == leutnerButton){ //Leutner
                buildingName = "Leutner";
                buildingImage = "idk/resources/leutner.jfif";
                actionButton.setText("Eat");
                //createLeutnerScreen();
            }
            if(event.getSource() == millisButton){ //Move to Millis Schmidt
                buildingName = "Millis";
                buildingImage = "idk/resources/millis.jpg";
            }
            if(event.getSource() == nordButton){//Enter Nord
                buildingName = "Nord";
                buildingImage = "idk/resources/nord.jpg";
                actionButton.setText("Choose Major");
                //createNordScreen();
            }
            if(event.getSource() == olinButton){ //Enter Olin
                buildingName = "Olin";
                buildingImage = "idk/resources/olin.jpg";
            }
            if(event.getSource() == pblButton){ //Enter PBL
                buildingName = "PBL";
                buildingImage = "idk/resources/PBL.jpg";
                actionButton.setText("Study");
                //createPBLScreen();
            }
            if(event.getSource() == rockButton){ //Move to Rockefeller
                buildingName = "Rockefeller";
                buildingImage = "idk/resources/Rockefeller.jpg";
            }
            if(event.getSource() == searsButton){ //Enter Sears
                buildingName = "Sears";
                buildingImage = "idk/resources/Sears.jpg";
            }
            if(event.getSource() == sophDormsButton){ //Sophomore Dorms
                buildingName = "Sophomore Dorms";
                buildingImage = "idk/resources/southDorms.jfif";
            }
            if(event.getSource() == strosackerButton){ //Enter Strosacker
                buildingName = "Strosacker";
                buildingImage = "idk/resources/Strosacker.jpg";
                actionButton.setText("Attend Lecture");
            }
            if(event.getSource() == thwingButton){ //Enter Thwing
                buildingName = "Thwing";
                buildingImage = "idk/resources/thwing.jpg";
            }
            if(event.getSource() == tinkButton){ //Enter Tink
                buildingName = "Tink";
                buildingImage = "idk/resources/tink.jpg";
                actionButton.setText("Join Club");
                //createTinkScreen();
            }
            if(event.getSource() == tomlinsonButton){ //Enter Tomlinson
                buildingName = "Tomlinson";
                buildingImage = "idk/resources/tomlinson.jpg";
            }
            if(event.getSource() == vealeButton){ //Go to Veale Gymnasium
                buildingName = "Veale";
                buildingImage = "idk/resources/Veale.jpg";
                actionButton.setText("Exercise at Veale");
            }
            if(event.getSource() == whiteButton){ //enter White
                buildingName = "White";
                buildingImage = "idk/resources/white.jpg";
            }
            if(event.getSource() == wickendenButton){ //Enter Wickenden
                buildingName = "Wickenden";
                buildingImage = "idk/resources/Wickenden.jpg";
            }
            if(event.getSource() == yostButton){ //Enter Yost
                buildingName = "Yost";
                buildingImage = "idk/resources/yost.jpg";
            }
            if(event.getSource() == actionButton){
                buildingTextPanel.setVisible(false);
                if(buildingName.equals("Veale")){
                    buildingName = "Exercise";
                    createExerciseScreen();
                }
                if(buildingName.equals("Strosacker")){
                    buildingName = "Lecture";
                    createLectureScreen();
                }
                if(buildingName == "Freshman Dorms"){
                    buildingName = "Roommate";
                    createChoiceTaskScreen();
                }
            }
            if(event.getSource() == menuButton) { //open menu
                buildingName = "menu";
                displayMenuScreen();
            }
            if(event.getSource()==returnButton){ //return to previous screen
                buildingName = previousScreenName;
                buildingImage = previousScreenImage;
            }
            if(event.getSource() == saveButton){

            }
            if(event.getSource() == attrButton){ //show attributes
                displayAttrScreen();
            }
            if(event.getSource() == taskButton){ //show attributes
                displayTaskScreen();
            }
            if(event.getSource() == startExButton){ //show attributes
                System.exit(0);
            }

            if(buildingNames.contains(buildingName)){
                displayBuildingScreen();
            }
            if(mapNames.contains(buildingName)){
                displayMapScreen();
            }

            JButton[] menuButtonList = {menuButton, attrButton, taskButton, returnButton, saveButton};
            if(!containsButton(menuButtonList, event.getSource())){
                if(event.getSource() != gStartButton) {
                    d.useHours(1);
                    timeLabel.setText("Time: " + String.valueOf(d.getHour()));
                }
            }

            if(g.getCurrent().isFinished()){
                if(g.nextLevel()){
                    winScreen();
                    buildingName = "Win";
                }
            }
        }
    }
}
