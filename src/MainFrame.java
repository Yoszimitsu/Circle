import javax.swing.*;
import java.util.Scanner;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        System.out.println("MULTI-THREAD WITHOUT EXECUTORS");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter # of threads");
        int nPanel = keyboard.nextInt();
        System.out.println("enter # of circles per thread");
        int nCircle = keyboard.nextInt();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("MULTI-THREAD WITHOUT EXECUTORS", nPanel, nCircle);
            }
        });
    }

    MainFrame(String title, int nPanel, int nCircle) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        // Utworzenie N paneli - każdy z nich zajmuje się jednym kółkiem (każdy rysuje osobne)
        DrawPanel[] panels = new DrawPanel[nPanel];
        for(int i=0; i<nPanel; i++)
            panels[i] = new DrawPanel(getSize(), nCircle, 120); // Arg nCircle ustala liczbe kółek rysowanych przez pojedynczy JPanel
        for(int i=nPanel-1; i>0; i--)
            panels[i-1].add(panels[i]);
        add(panels[0]);

        // Uruchomienie wątków JPaneli
        for(DrawPanel iPanel : panels)
            new Thread(iPanel).start();

        setVisible(true);
    }

}