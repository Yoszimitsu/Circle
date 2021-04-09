import java.awt.*;

public class Circle {
    Circle(int posX, int posY, int size, int velX, int velY, Color color, Dimension windowSize) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.velX = velX;
        this.velY = velY;
        this.color = color;
        this.windowSize = windowSize;
    }

    void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, size, size);
    }

    void move() {
        if (posX + velX < 0 || posX + size > windowSize.width)
            velX *= -1;
        if (posY + velY < 0 || posY + size > windowSize.height)
            velY *= -1;

        posX += velX;
        posY += velY;

        if(posX < 0) {
            posX = 0;
            velX *= -1;
        }
        else if(posX+size > windowSize.width) {
            posX = windowSize.width-size;
            velX *= -1;
        }

        if(posY < 0) {
            posY = 0;
            velY *= -1;
        }
        else if(posY+size > windowSize.height) {
            posY = windowSize.height-size;
            velY *= -1;
        }
    }

    void setWindowSize(Dimension windowSize) {
        this.windowSize = windowSize;
    }

    private int posX, posY, size, velX, velY;
    private Color color;
    private Dimension windowSize;
}