import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class GameScreen extends JPanel implements Runnable{
    public String screenName;

    static JFrame gameScreen;
    Container con;
    JPanel titleNamePanel, startButtonPanel, loadButtonPanel, imagePanel, introTextPanel;
    JLabel titleNameLabel, imageLabel;
    JButton startButton, loadButton;
    JTextArea introTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 80);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    Font introFont = new Font("Times New Roman", Font.PLAIN, 20);

    ImageIcon image;

    ScreenHandler sHandler = new ScreenHandler();

    private Player player = new Player(0, 0, new int[]{0}, new int[]{0, 0, 0, 0, 0});
    private Image playerImage;
    private int x, y;

//    private Thread animator;

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            gameScreen = new ThreadAnimation();
            gameScreen.setSize(800,600);
            gameScreen.setVisible(false);
        });
//        new GameScreen();
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

//        imagePanel.setFocusable(true);
        imagePanel.addKeyListener(sHandler);
//        imagePanel.requestFocus();

        setFocusable(true);
        addKeyListener(sHandler);
        requestFocus();

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

        screenName = "Intro Screen";
        startButtonPanel.setBounds(300, 425, 150,50);

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

        //find a way to center text
        introTextArea = new JTextArea(textIntro);
        introTextArea.setBounds(25,25,725,375);
        introTextArea.setFont(introFont);
        introTextArea.setLineWrap(true);
        introTextArea.setWrapStyleWord(true);

        introTextPanel.add(introTextArea);
    }

    public void createQuadScreen(){
        startButtonPanel.setVisible(false);
        introTextPanel.setVisible(false);

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

    public void createVealeScreen(){
        image = new ImageIcon("idk/resources/Veale.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createMillisScreen(){
        image = new ImageIcon("idk/resources/Millis.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }

    public void createRockefellerScreen(){
        image = new ImageIcon("idk/resources/Rockefeller.jpg");
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        image.setImage(resizedImage);
        imageLabel.setIcon(image);
    }


    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = resizedImage.createGraphics();
//
//        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g2.drawImage(srcImg, 0, 0, w, h, null);
//        g2.dispose();

        Graphics g2 = resizedImage.createGraphics();

        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImage;
    }

    private void initializePlayer(){
        ImageIcon imageIconPlayer = new ImageIcon("idk/resources/bit_character2.png");
        playerImage = getScaledImage(imageIconPlayer.getImage(), 50, 50);
        System.out.println("HELLO");
        player = new Player(0, 0, new int[]{0}, new int[]{0, 0, 0, 0, 0});
    }

    public void addNotify() {
        super.addNotify();
        Thread animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
        drawPlayer(g);
    }

    private void drawPlayer(Graphics g){
//        g.drawImage(playerImage, player.getX(), player.getY(), this);
        g.drawImage(playerImage, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawBackground(Graphics g) {
        Image resizedImage = getScaledImage(image.getImage(), 800, 600);
        g.drawImage(resizedImage, 0, 0, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void cycle() {
        System.out.println(player.getX());
        x = player.getX();
        y = player.getY();

    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = 25 - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

                String msg = String.format("Thread interrupted: %s", e.getMessage());

                JOptionPane.showMessageDialog(this, msg, "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

            beforeTime = System.currentTimeMillis();
        }
    }

    public class ScreenHandler implements ActionListener, KeyListener{
        public void actionPerformed(ActionEvent event){
            //Need to add a manner which differentiates between start/load
//            System.out.println("HELL3O");
            switch (screenName){
                case "Title Screen":
                    createIntroScreen();
                    break;
                case "Intro Screen":
                    createQuadScreen();
                    initializePlayer();
                    gameScreen.setVisible(true);
                    break;
            }

        }

        public void keyPressed(KeyEvent k) {
            System.out.println("HELL2O");
            if (k.getKeyCode() == KeyEvent.VK_LEFT) {
                player.setX(player.getX() - 5);
            }
            if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
                player.setX(player.getX() + 5);
            }
            if (k.getKeyCode() == KeyEvent.VK_UP) {
                player.setY(player.getY() - 5);
            }
            if (k.getKeyCode() == KeyEvent.VK_DOWN) {
                player.setY(player.getY() + 5);
            }
        }

        public void keyTyped(KeyEvent e) {}

        public void keyReleased(KeyEvent e) {}

    }


}
