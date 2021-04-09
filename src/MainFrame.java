import javax.swing.*;
import java.util.Scanner;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        System.out.println("SINGLE THREAD");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter # of circles");
        int nCircle = keyboard.nextInt();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("SINGLE THREAD");
                DrawPanel panel = new DrawPanel(frame.getSize(), nCircle,120);
                frame.add(panel);

                new Thread(panel).start();

                frame.setVisible(true);
            }
        });
    }

    MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
    }

}