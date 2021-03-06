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
            lastMapName, lastMapImage, previousScreenName, previousScreenImage;
    public String major = "Major: Undeclared";

    JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel,introTextPanel, vealeButtonPanel,
            mapButtonPanel, millisButtonPanel, rockButtonPanel, strosackerButtonPanel,
            awSmithButtonPanel, binghamButtonPanel,
            carltonButtonPanel, crawfordButtonPanel, eldredButtonPanel, elephantButtonPanel, northButtonPanel, southButtonPanel, gStartButtonPanel,
            menuButtonPanel, returnPanel, savePanel, menuPanel, attrButtonPanel, attrPanel, healthPanel, hygienePanel, intelligencePanel,
            strengthPanel, socialStandingPanel, glennanButtonPanel, khsButtonPanel, kslButtonPanel, nordButtonPanel, olinButtonPanel, pblButtonPanel,
            searsButtonPanel, thwingButtonPanel, tinkButtonPanel, whiteButtonPanel, wickendenButtonPanel, yostButtonPanel, tomlinsonButtonPanel, exerciseButtonPanel,
            compPanel1, compPanel2, compPanel3, compPanel4, startExButtonPanel, lectureButtonPanel,
            moveToQuadButtonPanel, denButtonPanel, freshDormsButtonPanel,
            schoolMajorPanel, sophDormsButtonPanel, leutnerButtonPanel, taskPanel, taskButtonPanel, buildingTextPanel, actionButtonPanel, task1Panel,
            task2Panel, timePanel, limagePanel, cimagePanel, rimagePanel, ltextPanel, ctextPanel, rtextPanel, ltextButtonPanel, ctext2Panel, rtext2Panel, ltext2Panel, ctextButtonPanel, rtextButtonPanel, continueButtonPanel;
    JLabel titleNameLabel, imageLabel, intelligencelabel, healthlabel, socialStandinglabel, strengthlabel, hygienelabel, compLabel1, compLabel2, compLabel3, compLabel4, task1Label,
            task2Label, timeLabel, limageLabel, cimageLabel, rimageLabel, ltextLabel,
            ctextLabel, rtextLabel, ltext2Label, ctext2Label, rtext2Label,
            schoolMajorLabel;
    JButton startButton, loadButton, vealeButton, mapButton, millisButton,
            strosackerButton, rockButton, northButton, southButton, gStartButton,
            menuButton, returnButton, saveButton, attrButton, awSmithButton, binghamButton, carltonButton, crawfordButton, eldredButton, elephantButton,
            glennanButton, kslButton, khsButton, nordButton, olinButton, pblButton, searsButton, thwingButton, tinkButton, tomlinsonButton, whiteButton,
            wickendenButton, yostButton, exerciseButton, startExButton, lectureButton, moveToQuadButton, denButton, taskButton,
            freshDormsButton, sophDormsButton, upperDormsButton, leutnerButton, actionButton, ltextButton, ctextButton, rtextButton, continueButton;
    JTextArea introTextArea, buildingTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font introFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font descFont = new Font("Times New Roman", Font.PLAIN, 20);
    Font medFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font mapFont = new Font("Times New Roman", Font.PLAIN, 12);
    Day d;

    ImageIcon image, limage, cimage, rimage;
    ScreenDescriptions roomTextDesc = new ScreenDescriptions(buildingName);

    //sHandler is for changing the window screen from one map/building to another
    ScreenHandler sHandler = new ScreenHandler();

    Game g;
    Player p1;
    BuildingImplementation building;

    List<String> buildingNames = Arrays.asList("Bingham", "Carlton", "Crawford","Dennys","Eldred", "Elephant", "Freshman Dorms", "Glennan", "KHS", "KSL",
            "Leutner", "Millis", "Nord", "Olin", "PBL", "Rockefeller", "Sears", "Smith",
            "Sophomore Dorms", "Strosacker", "Thwing", "Tink", "Tomlinson", "Veale",
            "White", "Wickenden","Yost");
    List<String> mapNames = Arrays.asList("Quad", "Northside", "Southside");
    List<String> taskNames = Arrays.asList("Exercise", "Lecture");

    int[] visited = new int[27];

    boolean majorComp, roommateComp, campusComp = false;

    public static void main(String[] args){
        new GameScreen();
    }

    public GameScreen() {
        //image home screen - intro, save, and load


        building = new BuildingImplementation();
        g = new Game();
        p1 = g.getPlayer();
        d = new Day("Monday");

        createTitleScreen();
        createIntroScreen();
        buttonInitializer();
        createCompletionScreen();
        createChoiceTaskScreen();
        hideBuildingButtons();

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
                "Use your mouse to interact with buttons on the screen. By clicking " +
                "on the buttons, you will be able to enter buildings and interact " +
                "with both the menu and available tasks.\n\nThe menu will allow you " +
                "to look at your attributes, task list, and major as well as save the " +
                "game and return to the previous game screen. Your major will be " +
                "able to be accessed through the attributes screen.\n\n" +
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
        buildingTextArea.setFont(descFont);
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
        menuButtonPanel.setVisible(false);
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
        vealeButtonPanel.setBounds(building.veale.getX(), building.veale.getY(),50, 25);
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
        millisButtonPanel.setBounds(building.millis.getX(), building.millis.getY(),50, 25);
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
        rockButtonPanel.setBounds(building.rockefeller.getX(), building.rockefeller.getY(),70
                , 25);
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
        strosackerButtonPanel.setBounds(building.strosacker.getX(),
                building.strosacker.getY(),70, 25);
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
        awSmithButtonPanel.setBounds(building.smith.getX(), building.smith.getY(),70, 25);
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
        binghamButtonPanel.setBounds(building.bingham.getX(), building.bingham.getY(),70,
                25);
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
        crawfordButtonPanel.setBounds(building.crawford.getX(),building.crawford.getY(),70,
                25);
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
        eldredButtonPanel.setBounds(building.eldred.getX(),building.eldred.getY(),65, 25);
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
        glennanButtonPanel.setBounds(building.glennan.getX(),building.glennan.getY(),70,
                25);
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
        khsButtonPanel.setBounds(building.khs.getX(),building.khs.getY(), 50, 25);
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
        nordButtonPanel.setBounds(building.nord.getX(),building.nord.getY(),50, 25);
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
        olinButtonPanel.setBounds(building.olin.getX(),building.olin.getY(),50, 25);
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
        searsButtonPanel.setBounds(building.sears.getX(),building.sears.getY(),50, 25);
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
        tomlinsonButtonPanel.setBounds(building.tomlinson.getX(),building.tomlinson.getY(),70
                , 25);
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
        whiteButtonPanel.setBounds(building.white.getX(),building.white.getY(),50, 25);
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
        wickendenButtonPanel.setBounds(building.wickenden.getX(),building.wickenden.getY(),70
                , 25);
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
        yostButtonPanel.setBounds(building.yost.getX(),building.yost.getY(),50, 25);
        yostButton = new JButton("Yost");
        yostButton.setBackground(Color.darkGray);
        yostButton.setForeground(Color.white);
        yostButton.setFont(mapFont);

        yostButton.addActionListener(sHandler);
        yostButtonPanel.add(yostButton);
        con.add(yostButtonPanel);

        //Return to map (from a building)
        mapButtonPanel = new JPanel();
        mapButtonPanel.setVisible(false);
        mapButtonPanel.setBounds(100, 100, 180, 50);
        mapButton = new JButton("Return to Map");
        mapButton.setBackground(Color.white);
        mapButton.setForeground(Color.darkGray);
        mapButton.setFont(normalFont);
        mapButtonPanel.setVisible(false);

        mapButton.addActionListener(sHandler);
        mapButtonPanel.add(mapButton);
        con.add(mapButtonPanel);

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

        continueButtonPanel = new JPanel();
        continueButtonPanel.setVisible(false);
        continueButtonPanel.setBounds(310, 300 ,200, 50);
        continueButton = new JButton("Click to Continue");
        continueButton.setBackground(Color.darkGray);
        continueButton.setForeground(Color.white);
        continueButton.setFont(normalFont);

        continueButton.addActionListener(sHandler);
        continueButtonPanel.add(continueButton);
        con.add(continueButtonPanel);
        continueButtonPanel.setVisible(false);

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
        denButtonPanel.setBounds(building.dennys.getX(), building.dennys.getY(),50, 25);
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
        freshDormsButtonPanel.setBounds(building.freshmanDorms.getX(),building.freshmanDorms.getY(), 120,
                25);
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
        leutnerButtonPanel.setBounds(building.leutner.getX(), building.leutner.getY(),65, 25);
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
        pblButtonPanel.setBounds(building.pbl.getX(),building.pbl.getY(),55, 25);
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
        thwingButtonPanel.setBounds(building.thwing.getX(),building.thwing.getY(),60, 25);
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
        tinkButtonPanel.setBounds(building.tink.getX(),building.tink.getY(),55, 25);
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
        kslButtonPanel.setBounds(building.ksl.getX(),building.ksl.getY(),55, 25);
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
        carltonButtonPanel.setBounds(building.carlton.getX(),building.carlton.getY(),60, 25);
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
        elephantButtonPanel.setBounds(building.elephant.getX(),building.elephant.getY(),70,
                25);
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
        sophDormsButtonPanel.setBounds(building.sophomoreDorms.getX(),building.sophomoreDorms.getY(), 120,
                25);
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
        actionButtonPanel.setBounds(100, 150,200, 50);
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
        mapButtonPanel.setVisible(true);
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
        healthPanel.setBounds(325, 375 ,150, 50);
        //String health = "Health: " + String.valueOf(g.getPlayer().getAttributeVal("Health"));
        healthlabel = new JLabel("Health: 1");
        healthlabel.setBackground(Color.white);
        healthlabel.setForeground(Color.darkGray);
        healthlabel.setFont(normalFont);

        hygienePanel = new JPanel();
        hygienePanel.setBounds(325, 325 ,150, 50);
        hygienelabel = new JLabel("Hygiene: 1");
        hygienelabel.setBackground(Color.white);
        hygienelabel.setForeground(Color.darkGray);
        hygienelabel.setFont(normalFont);

        intelligencePanel = new JPanel();
        intelligencePanel.setBounds(325, 275 ,150, 50);
        intelligencelabel = new JLabel("Intelligence: 1");
        intelligencelabel.setBackground(Color.white);
        intelligencelabel.setForeground(Color.darkGray);
        intelligencelabel.setFont(normalFont);

        strengthPanel = new JPanel();
        strengthPanel.setBounds(325, 225 ,150, 50);
        strengthlabel = new JLabel("Strength: 1");
        strengthlabel.setBackground(Color.white);
        strengthlabel.setForeground(Color.darkGray);
        strengthlabel.setFont(normalFont);

        socialStandingPanel = new JPanel();
        socialStandingPanel.setBounds(300, 175 ,200, 50);
        socialStandinglabel = new JLabel("Social Standing: 1");
        socialStandinglabel.setBackground(Color.white);
        socialStandinglabel.setForeground(Color.darkGray);
        socialStandinglabel.setFont(normalFont);

        schoolMajorPanel = new JPanel();
        schoolMajorPanel.setBounds(200, 425 ,400, 50);
        schoolMajorLabel = new JLabel("Major: " + major);
        schoolMajorLabel.setBackground(Color.white);
        schoolMajorLabel.setForeground(Color.darkGray);
        schoolMajorLabel.setFont(normalFont);

        attrPanel.add(attrLabel);
        healthPanel.add(healthlabel);
        hygienePanel.add(hygienelabel);
        intelligencePanel.add(intelligencelabel);
        strengthPanel.add(strengthlabel);
        socialStandingPanel.add(socialStandinglabel);
        schoolMajorPanel.add(schoolMajorLabel);

        con.add(attrPanel);
        con.add(healthPanel);
        con.add(hygienePanel);
        con.add(intelligencePanel);
        con.add(strengthPanel);
        con.add(socialStandingPanel);
        con.add(schoolMajorPanel);

        attrPanel.setVisible(false);
        healthPanel.setVisible(false);
        hygienePanel.setVisible(false);
        intelligencePanel.setVisible(false);
        strengthPanel.setVisible(false);
        socialStandingPanel.setVisible(false);
        schoolMajorPanel.setVisible(false);
    }

    public void displayIntroScreen(){
        titleNamePanel.setVisible(false);
        loadButtonPanel.setVisible(false);
        startButtonPanel.setVisible(false);
        introTextPanel.setVisible(true);
        gStartButtonPanel.setVisible(true);
    }

    //following methods respectively display a map(depending on buildingName), menu, and
    // attribute windows
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
        hideEverything();

        menuPanel.setVisible(true);
        savePanel.setVisible(true);
        returnPanel.setVisible(true);
        attrButtonPanel.setVisible(true);
        taskButtonPanel.setVisible(true);
    }

    //While in the menu, clicking on the attribute button will display this screen
    //This screen will list the players current attributes
    public void displayAttrScreen(){
        healthlabel.setText("Health: " + String.valueOf(g.getPlayer().getAttributeVal("Health")));
        strengthlabel.setText("Strength: " + String.valueOf(g.getPlayer().getAttributeVal("Strength")));
        hygienelabel.setText("Hygiene: " + String.valueOf(g.getPlayer().getAttributeVal("Hygiene")));
        intelligencelabel.setText("Intelligence: " + String.valueOf(g.getPlayer().getAttributeVal("Intelligence")));
        socialStandinglabel.setText("Social Standing: " + String.valueOf(g.getPlayer().getAttributeVal("SocialStanding")));
        schoolMajorLabel.setText(major);

        hideMenuButtons();

        attrPanel.setVisible(true);
        healthPanel.setVisible(true);
        hygienePanel.setVisible(true);
        intelligencePanel.setVisible(true);
        strengthPanel.setVisible(true);
        socialStandingPanel.setVisible(true);
        schoolMajorPanel.setVisible(true);
        menuButtonPanel.setVisible(true);
    }

    //While in the menu, clicking on the task button will display this screen
    //This screen will list the current tasks
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

    //This will change the room to display task rooms like the "Exercise" or "Lecture"
    // rooms
    public void displayCurrentTaskScreen(){
        //I want to either move screen initializations to a new class to call
        //I want to give tasks and building buttons different handlers. They'll do the same thing but it'll be easier
        // to look at
        actionButtonPanel.setVisible(false);
        startExButtonPanel.setVisible(true);

        image = new ImageIcon(buildingImage);
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);

        switch(buildingName){
            case "Exercise":
                g.getPlayer().setAttributeVal("Strength", g.getPlayer().getAttributeVal("Strength") + 1);
                reward = "Strength increased by 1";
                taskName = "Exercise at Veale";
                break;
            case "Lecture":
                g.getPlayer().setAttributeVal("Intelligence", g.getPlayer().getAttributeVal("Intelligence") + 1);
                reward = "Intelligence increased by 1";
                taskName = "Attend Lecture";
                break;
        }
    }

    //tasks such as choose major, choose roommate, etc.
    public void createChoiceTaskScreen(){
        limagePanel = new JPanel();
        limagePanel.setBounds(75,200,100,100);
        limageLabel = new JLabel();
        limage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedLImage = getScaledImage(limage.getImage(), 100, 100);
        limage.setImage(resizedLImage);
        limageLabel.setIcon(limage);
        limagePanel.add(limageLabel);
        con.add(limagePanel);

        limagePanel.setVisible(false);

        cimagePanel = new JPanel();
        cimagePanel.setBounds(325,200,100,100);
        cimageLabel = new JLabel();
        cimage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedCImage = getScaledImage(cimage.getImage(), 100, 100);
        cimage.setImage(resizedCImage);
        cimageLabel.setIcon(cimage);
        cimagePanel.add(cimageLabel);
        con.add(cimagePanel);

        cimagePanel.setVisible(false);

        rimagePanel = new JPanel();
        rimagePanel.setBounds(575,200,100,100);
        rimageLabel = new JLabel();
        rimage = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        Image resizedRImage = getScaledImage(rimage.getImage(), 100, 100);
        rimage.setImage(resizedRImage);
        rimageLabel.setIcon(rimage);
        rimagePanel.add(rimageLabel);
        con.add(rimagePanel);

        rimagePanel.setVisible(false);

        ltextPanel = new JPanel();
        ltextPanel.setBounds(50, 300 ,150, 50);
        ltextLabel = new JLabel("ltext");
        ltextLabel.setBackground(Color.white);
        ltextLabel.setForeground(Color.darkGray);
        ltextLabel.setFont(normalFont);
        ltextPanel.add(ltextLabel);
        con.add(ltextPanel);

        ltextPanel.setVisible(false);

        ltext2Panel = new JPanel();
        ltext2Panel.setBounds(35, 350 ,200, 50);
        ltext2Label = new JLabel("ltext2");
        ltext2Label.setBackground(Color.white);
        ltext2Label.setForeground(Color.darkGray);
        ltext2Label.setFont(normalFont);
        ltext2Panel.add(ltext2Label);
        con.add(ltext2Panel);

        ltext2Panel.setVisible(false);

        ctextPanel = new JPanel();
        ctextPanel.setBounds(300, 300 ,150, 50);
        ctextLabel = new JLabel("ctext");
        ctextLabel.setBackground(Color.white);
        ctextLabel.setForeground(Color.darkGray);
        ctextLabel.setFont(normalFont);
        ctextPanel.add(ctextLabel);
        con.add(ctextPanel);

        ctextPanel.setVisible(false);

        ctext2Panel = new JPanel();
        ctext2Panel.setBounds(250, 350 ,250, 50);
        ctext2Label = new JLabel("ctext2");
        ctext2Label.setBackground(Color.white);
        ctext2Label.setForeground(Color.darkGray);
        ctext2Label.setFont(normalFont);
        ctext2Panel.add(ctext2Label);
        con.add(ctext2Panel);

        ctext2Panel.setVisible(false);

        rtextPanel = new JPanel();
        rtextPanel.setBounds(550, 300 ,150, 50);
        rtextLabel = new JLabel("rtext");
        rtextLabel.setBackground(Color.white);
        rtextLabel.setForeground(Color.darkGray);
        rtextLabel.setFont(normalFont);
        rtextPanel.add(rtextLabel);
        con.add(rtextPanel);

        rtextPanel.setVisible(false);

        rtext2Panel = new JPanel();
        rtext2Panel.setBounds(520, 350 ,225, 50);
        rtext2Label = new JLabel("rtext2");
        rtext2Label.setBackground(Color.white);
        rtext2Label.setForeground(Color.darkGray);
        rtext2Label.setFont(normalFont);
        rtext2Panel.add(rtext2Label);
        con.add(rtext2Panel);

        rtext2Panel.setVisible(false);

        ltextButtonPanel = new JPanel();
        ltextButtonPanel.setBounds(50, 400 ,150, 50);
        ltextButton = new JButton("Choose");
        ltextButton.setBackground(Color.white);
        ltextButton.setForeground(Color.darkGray);
        ltextButton.setFont(normalFont);
        ltextButtonPanel.add(ltextButton);
        con.add(ltextButtonPanel);
        ltextButton.addActionListener(sHandler);

        ltextButtonPanel.setVisible(false);

        ctextButtonPanel = new JPanel();
        ctextButtonPanel.setBounds(300, 400 ,150, 50);
        ctextButton = new JButton("Choose");
        ctextButton.setBackground(Color.white);
        ctextButton.setForeground(Color.darkGray);
        ctextButton.setFont(normalFont);
        ctextButtonPanel.add(ctextButton);
        con.add(ctextButtonPanel);
        ctextButton.addActionListener(sHandler);

        ctextButtonPanel.setVisible(false);

        rtextButtonPanel = new JPanel();
        rtextButtonPanel.setBounds(550, 400 ,150, 50);
        rtextButton = new JButton("Choose");
        rtextButton.setBackground(Color.white);
        rtextButton.setForeground(Color.darkGray);
        rtextButton.setFont(normalFont);
        rtextButtonPanel.add(rtextButton);
        con.add(rtextButtonPanel);
        rtextButton.addActionListener(sHandler);

        rtextButtonPanel.setVisible(false);

    }

    public void displayChoiceTaskScreen(){
        actionButtonPanel.setVisible(false);
        mapButtonPanel.setVisible(false);
        imagePanel.setVisible(false);

        if(buildingName.equals("Roommate")){
            limage = new ImageIcon("idk/resources/roommate1.jpg");
            Image resizedImage = getScaledImage(limage.getImage(), 200, 200);
            limage.setImage(resizedImage);
            limageLabel.setIcon(limage);

            cimage = new ImageIcon("idk/resources/roommate2.jpeg");
            resizedImage = getScaledImage(cimage.getImage(), 200, 200);
            cimage.setImage(resizedImage);
            cimageLabel.setIcon(cimage);

            rimage = new ImageIcon("idk/resources/roommate3.jpg");
            resizedImage = getScaledImage(rimage.getImage(), 200, 200);
            rimage.setImage(resizedImage);
            rimageLabel.setIcon(rimage);

            ltextLabel.setText("Roomate 1");
            ctextLabel.setText("Roomate 2");
            rtextLabel.setText("Roomate 3");

            ltext2Label.setText("increases strength");
            ctext2Label.setText("increases social standing");
            rtext2Label.setText("increases intelligence");
        }

        else if(buildingName.equals("Major")){
            limage = new ImageIcon("idk/resources/major1.jpg");
            Image resizedImage = getScaledImage(limage.getImage(), 200, 200);
            limage.setImage(resizedImage);
            limageLabel.setIcon(limage);

            cimage = new ImageIcon("idk/resources/major2.jpg");
            resizedImage = getScaledImage(cimage.getImage(), 200, 200);
            cimage.setImage(resizedImage);
            cimageLabel.setIcon(cimage);

            rimage = new ImageIcon("idk/resources/major3.jpg");
            resizedImage = getScaledImage(rimage.getImage(), 200, 200);
            rimage.setImage(resizedImage);
            rimageLabel.setIcon(rimage);

            ltextLabel.setText("Major 1");
            ctextLabel.setText("Major 2");
            rtextLabel.setText("Major 3");

            ltext2Label.setText("Computer Science");
            ctext2Label.setText("Pre Med");
            rtext2Label.setText("Economics");
        }


        limagePanel.setVisible(true);
        cimagePanel.setVisible(true);
        rimagePanel.setVisible(true);
        ltextPanel.setVisible(true);
        ctextPanel.setVisible(true);
        rtextPanel.setVisible(true);
        ltextButtonPanel.setVisible(true);
        ctextButtonPanel.setVisible(true);
        rtextButtonPanel.setVisible(true);
        ltext2Panel.setVisible(true);
        ctext2Panel.setVisible(true);
        rtext2Panel.setVisible(true);

    }

    public boolean campusTour(){
        for(int i = 0; i < 27; i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }

    //creates a screen when a task is completed
    public void createCompletionScreen(){
        compPanel1 = new JPanel();
        compPanel1.setBounds(245,150,350,50);
        compPanel1.setBackground(Color.DARK_GRAY);
        compLabel1 = new JLabel("Congratulations!");
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
        compPanel4.setBounds(145, 400 ,590, 50);
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
        TimeUnit.SECONDS.sleep(1/2);


        compLabel3.setText(taskName);
        compLabel4.setText(reward);

        mapButtonPanel.setVisible(false);
        imagePanel.setVisible(false);
        buildingTextPanel.setVisible(false);
        mapButton.setVisible(true);
        hideTaskButtons();

        compPanel1.setVisible(true);
        compPanel2.setVisible(true);
        compPanel3.setVisible(true);
        compPanel4.setVisible(true);
    }

    public void alreadyCompleted(){

        compLabel4.setText("You already did that task!");

        imagePanel.setVisible(false);
        hideTaskButtons();

        compPanel4.setVisible(true);
    }

    public void winScreen(){
        hideEverything();
        menuButtonPanel.setVisible(false);
        timePanel.setVisible(false);
        buildingTextPanel.setVisible(false);

        compPanel1.setVisible(true);
        compLabel2.setText("You Win!");

        imagePanel.setVisible(false);
        continueButtonPanel.setVisible(true);
        compPanel1.setVisible(true);
        compPanel2.setVisible(true);
    }

    public void loseScreen(){
        hideEverything();
        menuButtonPanel.setVisible(false);
        timePanel.setVisible(false);
        buildingTextPanel.setVisible(false);

        compLabel1.setText("Oh No!");
        compLabel2.setText("You Ran Out of Time!");

        imagePanel.setVisible(false);
        continueButtonPanel.setVisible(true);
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
        mapButtonPanel.setVisible(false);
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

        limagePanel.setVisible(false);
        cimagePanel.setVisible(false);
        rimagePanel.setVisible(false);
        ltextPanel.setVisible(false);
        ctextPanel.setVisible(false);
        rtextPanel.setVisible(false);
        ltextButtonPanel.setVisible(false);
        ctextButtonPanel.setVisible(false);
        rtextButtonPanel.setVisible(false);
        ltext2Panel.setVisible(false);
        ctext2Panel.setVisible(false);
        rtext2Panel.setVisible(false);

        compPanel1.setVisible(false);
        compPanel2.setVisible(false);
        compPanel3.setVisible(false);
        compPanel4.setVisible(false);
    }

    //hides all menu related button, used so that 'return' will go to previous screen
    public void hideMenuButtons(){
        menuPanel.setVisible(false);
        savePanel.setVisible(false);
        returnPanel.setVisible(false);
        attrButtonPanel.setVisible(false);
        taskButtonPanel.setVisible(false);

        attrPanel.setVisible(false);
        healthPanel.setVisible(false);
        hygienePanel.setVisible(false);
        intelligencePanel.setVisible(false);
        strengthPanel.setVisible(false);
        socialStandingPanel.setVisible(false);
        schoolMajorPanel.setVisible(false);
        menuButtonPanel.setVisible(false);
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
            //Move to quad from intro screen, building, map, or menu
            JButton[] quadButtonList = {gStartButton,moveToQuadButton};
            if(containsButton(quadButtonList, event.getSource())){
                lastMapName = buildingName = "Quad";
                lastMapImage = buildingImage = "idk/resources/CWRUquadDots.jpg";
            }
            if(event.getSource() == northButton){ //go to northside
                lastMapName = buildingName = "Northside";
                lastMapImage = buildingImage = "idk/resources/CWRUnorthDots.jpg";
            }
            if(event.getSource() == southButton){ //go to southside
                lastMapName = buildingName = "Southside";
                lastMapImage = buildingImage = "idk/resources/CWRUsouthDots.jpg";
            }
            if(event.getSource() == awSmithButton){ //Enter AW Smith
                buildingName = "Smith";
                buildingImage = "idk/resources/smith.jpg";
                visited[0]++;
            }
            if(event.getSource() == binghamButton){ // Enter Bingham
                buildingName = "Bingham";
                buildingImage = "idk/resources/bingham.jpg";
                visited[1]++;
            }
            if(event.getSource() == carltonButton){ // Enter Carlton Commons
                buildingName = "Carlton";
                buildingImage = "idk/resources/carlton.jpg";
                actionButton.setText("Eat");
                visited[2]++;
            }
            if(event.getSource() == crawfordButton){ //Enter Crawford
                buildingName = "Crawford";
                buildingImage = "idk/resources/Crawford.jpg";
                visited[3]++;
            }
            if(event.getSource() == denButton){ //The Den
                buildingName = "Dennys";
                buildingImage = "idk/resources/dennys.jpg";
                actionButton.setText("Eat");
                visited[4]++;
            }
            if(event.getSource() == eldredButton){ //Enter Eldred
                buildingName = "Eldred";
                buildingImage = "idk/resources/eldred.jpg";
                actionButton.setText("Practice acting");
                visited[5]++;
            }
            if(event.getSource() == elephantButton){ //Elephant Stairs
                buildingName = "Elephant";
                buildingImage = "idk/resources/elephant.jpg";
                actionButton.setText("Walk up steps");
                visited[6]++;
            }
            if(event.getSource() == freshDormsButton){ //Freshman Dorms
                buildingName = "Freshman Dorms";
                buildingImage = "idk/resources/freshDorms.jfif";
                actionButton.setText("Choose Roommate");
                visited[7]++;
            }
            if(event.getSource() == glennanButton){ //Enter Glennan
                buildingName = "Glennan";
                buildingImage = "idk/resources/glennan.jpg";
                visited[8]++;
            }
            if(event.getSource() == khsButton){//Enter Kent Hale Smith, the Virus
                buildingName = "KHS";
                buildingImage = "idk/resources/KHS.jpeg";
                visited[9]++;
            }
            if(event.getSource() == kslButton){//Enter KSL
                buildingName = "KSL";
                buildingImage = "idk/resources/KSL.jpg";
                actionButton.setText("Study");
                visited[10]++;
            }
            if(event.getSource() == leutnerButton){ //Leutner
                buildingName = "Leutner";
                buildingImage = "idk/resources/leutner.jfif";
                actionButton.setText("Eat");
                visited[11]++;
            }
            if(event.getSource() == millisButton){ //Move to Millis Schmidt
                buildingName = "Millis";
                buildingImage = "idk/resources/millis.jpg";
                visited[12]++;
            }
            if(event.getSource() == nordButton){//Enter Nord
                buildingName = "Nord";
                buildingImage = "idk/resources/nord.jpg";
                actionButton.setText("Choose Major");
                visited[13]++;
            }
            if(event.getSource() == olinButton){ //Enter Olin
                buildingName = "Olin";
                buildingImage = "idk/resources/olin.jpg";
                visited[14]++;
            }
            if(event.getSource() == pblButton){ //Enter PBL
                buildingName = "PBL";
                buildingImage = "idk/resources/PBL.jpg";
                actionButton.setText("Study");
                visited[15]++;
            }
            if(event.getSource() == rockButton){ //Move to Rockefeller
                buildingName = "Rockefeller";
                buildingImage = "idk/resources/Rockefeller.jpg";
                visited[16]++;
            }
            if(event.getSource() == searsButton){ //Enter Sears
                buildingName = "Sears";
                buildingImage = "idk/resources/Sears.jpg";
                visited[17]++;
            }
            if(event.getSource() == sophDormsButton){ //Sophomore Dorms
                buildingName = "Sophomore Dorms";
                buildingImage = "idk/resources/southDorms.jfif";
                visited[18]++;
            }
            if(event.getSource() == strosackerButton){ //Enter Strosacker
                buildingName = "Strosacker";
                buildingImage = "idk/resources/Strosacker.jpg";
                actionButton.setText("Attend Lecture");
                visited[19]++;
            }
            if(event.getSource() == thwingButton){ //Enter Thwing
                buildingName = "Thwing";
                buildingImage = "idk/resources/thwing.jpg";
                visited[20]++;
            }
            if(event.getSource() == tinkButton){ //Enter Tink
                buildingName = "Tink";
                buildingImage = "idk/resources/tink.jpg";
                actionButton.setText("Join Club");
                visited[21]++;
            }
            if(event.getSource() == tomlinsonButton){ //Enter Tomlinson
                buildingName = "Tomlinson";
                buildingImage = "idk/resources/tomlinson.jpg";
                visited[22]++;
            }
            if(event.getSource() == vealeButton){ //Go to Veale Gymnasium
                buildingName = "Veale";
                buildingImage = "idk/resources/Veale.jpg";
                actionButton.setText("Exercise at Veale");
                visited[23]++;
            }
            if(event.getSource() == whiteButton){ //enter White
                buildingName = "White";
                buildingImage = "idk/resources/white.jpg";
                visited[24]++;
            }
            if(event.getSource() == wickendenButton){ //Enter Wickenden
                buildingName = "Wickenden";
                buildingImage = "idk/resources/Wickenden.jpg";
                visited[25]++;
            }
            if(event.getSource() == yostButton){ //Enter Yost
                buildingName = "Yost";
                buildingImage = "idk/resources/yost.jpg";
                visited[26]++;
            }
            if(event.getSource() == actionButton){
                buildingTextPanel.setVisible(false);
                if(previousScreenName.equals("Veale")){
                    buildingName = "Exercise";
                    buildingImage = "idk/resources/gym.jpg";
                }
                if(previousScreenName.equals("Strosacker")){
                    buildingName = "Lecture";
                    buildingImage = "idk/resources/lecture.jpg";
                }
                if(previousScreenName.equals("Freshman Dorms")){
                    if(roommateComp){
                        alreadyCompleted();
                    }
                    else {
                        buildingName = "Roommate";
                        taskName = "Choose Roommate";
                        displayChoiceTaskScreen();
                    }
                }
                if(previousScreenName.equals("Nord")){
                    if(majorComp){
                        alreadyCompleted();
                    }
                    else {
                        buildingName = "Major";
                        taskName = "Choose Major";
                        displayChoiceTaskScreen();
                    }
                }
            }
            if(event.getSource() == startExButton){
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource() == ltextButton){
                if(taskName.equals("Choose Roommate")){
                    g.getPlayer().setAttributeVal("Strength", g.getPlayer().getAttributeVal("Strength") + 1);
                    reward = "Strength increased by 1";
                    roommateComp = true;
                    g.getCurrent().getTasks().get(1).setFinish();
                }
                else if(taskName.equals("Choose Major")){
                    reward = "Chosen Computer Science Major";
                    majorComp = true;
                    major = "Major: Computer Science";
                }
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource() == ctextButton){
                if(taskName.equals("Choose Roommate")){
                    g.getPlayer().setAttributeVal("SocialStanding", g.getPlayer().getAttributeVal("SocialStanding") + 1);
                    reward = "Social Standing increased by 1";
                    roommateComp = true;
                    g.getCurrent().getTasks().get(1).setFinish();
                }
                else if(taskName.equals("Choose Major")){
                    reward = "Chosen Pre Med Major";
                    majorComp = true;
                    major = "Major: Pre Med";
                }
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(event.getSource() == rtextButton){
                if(taskName.equals("Choose Roommate")){
                    g.getPlayer().setAttributeVal("Intelligence", g.getPlayer().getAttributeVal("Intelligence") + 1);
                    reward = "Intelligence increased by 1";
                    roommateComp = true;
                    g.getCurrent().getTasks().get(1).setFinish();
                }
                else if(taskName.equals("Choose Major")){
                    reward = "Chosen Economics Major";
                    majorComp = true;
                    major = "Major: Economics";
                }
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            if(event.getSource() == menuButton) { //open menu
                buildingName = "Menu";
                displayMenuScreen();
            }
            if(event.getSource() == returnButton){ //return to previous screen
                buildingName = previousScreenName;
                buildingImage = previousScreenImage;
            }
            if(event.getSource() == mapButton){ //return to map from a building
                buildingName = lastMapName;
                buildingImage = lastMapImage;
            }
            if(event.getSource() == saveButton){
                g.save();
            }
            if(event.getSource() == attrButton){ //show attributes
                displayAttrScreen();
            }
            if(event.getSource() == taskButton){ //show attributes
                displayTaskScreen();
            }

            if(event.getSource() == continueButton){ //close screen
                System.exit(0);
            }

            if(buildingNames.contains(buildingName)){
                displayBuildingScreen();
            }
            if(mapNames.contains(buildingName)){
                displayMapScreen();
            }
            if(taskNames.contains(buildingName)){
                displayCurrentTaskScreen();
            }

            JButton[] menuButtonList = {menuButton, attrButton, taskButton, returnButton, saveButton};
            if(!containsButton(menuButtonList, event.getSource())){
                if(event.getSource() != gStartButton) {
                    d.useHours(1);
                    timeLabel.setText("Time: " + String.valueOf(d.getHour()));
                }
            }

            if(campusTour() && !campusComp){
                try {
                    taskName = "Campus Tour";
                    reward = "Good Job!";
                    g.getCurrent().getTasks().get(0).setFinish();
                    displayCompletionScreen();
                    campusComp = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if((g.getCurrent().isFinished()) && (buildingName == "Quad")){
                hideBuildingButtons();
                reward = "You have advanced to the next grade!";
                taskName = "Freshman Year";
                try {
                    displayCompletionScreen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(g.nextLevel()){
                    winScreen();
                    buildingName = "Win";
                }
            }

            if(d.getHour() >= 100){
                loseScreen();
            }
        }
    }
}
