import javax.swing.*;

public class MainFrame extends JFrame {

    MainFrame(String title, int nPanel) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);

        // Utworzenie N paneli - każdy z nich zajmuje się jednym kółkiem (każdy rysuje osobne)
        DrawPanel[] panels = new DrawPanel[nPanel];
        for(int i=0; i<nPanel; i++)
            panels[i] = new DrawPanel(getSize(), 10); // Arg nCircle ustala liczbe kółek rysowanych przez pojedynczy JPanel
        for(int i=nPanel-1; i>0; i--)
            panels[i-1].add(panels[i]);
        add(panels[0]);

        // Uruchomienie wątków JPaneli
        for(DrawPanel iPanel : panels)
            new Thread(iPanel).start();

        setVisible(true);
    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("turbo kółka!!!", 100);
            }
        });
    }
}
