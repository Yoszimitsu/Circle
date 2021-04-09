import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel implements Runnable {
    DrawPanel(Dimension windowSize, int nCircle, int framesPerSecond) {
        this.windowSize = windowSize;
        this.frameRateTime = 1000/framesPerSecond;

        for(int i=0; i<nCircle; i++)
            addCircle();
    }

    void addCircle() {
        int size = rand.nextInt(20) + 5;
        int x = rand.nextInt(windowSize.width - size);
        int y = rand.nextInt(windowSize.height - size);
        int velX = rand.nextInt(7) + 1;
        int velY = rand.nextInt(7) + 1;
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        circleList.add(new Circle(x, y, size, velX, velY, color, windowSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(!setSize) {
            windowSize = new Dimension(g.getClipBounds().width, g.getClipBounds().height);
            for(Circle circle : circleList)
                circle.setWindowSize(windowSize);
            setSize = true;
        }

        for(Circle circle : circleList)
            circle.paint(g);
    }

    @Override
    public void run() {
        while(true) {
            long start = System.nanoTime();

            for(Circle circle : circleList)
                circle.move();

            repaint();
            System.out.println(Thread.currentThread().getName());

            long end = System.nanoTime();
            long wait = (long) (frameRateTime - (end-start) / 1e6);
            if(wait < 0)
                wait = 0;

            try {
                Thread.sleep(wait);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Dimension windowSize;
    private List<Circle> circleList = new ArrayList<Circle>();
    private Random rand = new Random();
    private long frameRateTime;
    private boolean setSize = false;
}