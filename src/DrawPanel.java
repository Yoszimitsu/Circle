import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawPanel extends JPanel implements Runnable {
    DrawPanel(Dimension windowSize, int nCircle) {
        this.windowSize = windowSize;

        // Pozwala na uwidocznienie warst leżących pod tym JPanel
        setOpaque(false);
        setPreferredSize(windowSize);
        for(int i=0; i<nCircle; i++)
            addCircle();
        setLayout(new BorderLayout());
    }

    void addCircle() {
        int size = rand.nextInt(80) + 20;
        int x = rand.nextInt(windowSize.width - size);
        int y = rand.nextInt(windowSize.height - size);
        int velX = rand.nextInt(7);
        int velY = rand.nextInt(7);
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
		for(Circle circle : circleList)
			circle.move();

		repaint();
    }

    private Dimension windowSize;
    private List<Circle> circleList = new ArrayList<Circle>();
    private Random rand = new Random();
    private boolean setSize = false;
}
