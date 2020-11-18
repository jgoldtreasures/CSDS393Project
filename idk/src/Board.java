import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel implements Runnable {

    private final int B_WIDTH = 800;
    private final int B_HEIGHT = 600;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image player;
    private Image background;
    private Thread animator;
    private int x, y;

    public Board() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("idk/resources/bit_character2.png");
        player = ii.getImage();

        ImageIcon iib = new ImageIcon("idk/resources/CWRUquadDots.jpg");
        background = iib.getImage();
    }

    private void initBoard() {

//        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    @Override
    public void addNotify() {
        super.addNotify();

        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBackground(g);
        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(player, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawBackground(Graphics g) {
        Image resizedImage = getScaledImage(background, 800, 600);
        g.drawImage(resizedImage, 0, 0, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImage = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImage.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImage;
    }

    private void cycle() {

        x += 1;
        y += 1;

        if (y > B_HEIGHT) {

            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

//    @Override
    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {

            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

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
}