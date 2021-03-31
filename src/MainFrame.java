import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
    }

    MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("Główne okienko");
                DrawPanel panel = new DrawPanel(frame.getSize(), 10);
                frame.add(panel);

                new Thread(panel).start();

                frame.setVisible(true);
            }
        });
    }
}
