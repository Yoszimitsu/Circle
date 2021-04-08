import javax.swing.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainFrame extends JFrame {

    MainFrame(String title, int nPanel) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setResizable(false);
		setVisible(true);

        // Utworzenie N paneli - każdy z nich zajmuje się jednym kółkiem (każdy rysuje osobne)
        DrawPanel[] panels = new DrawPanel[nPanel];
        for(int i=0; i<nPanel; i++)
            panels[i] = new DrawPanel(getSize(), 10); // Arg nCircle ustala liczbe kółek rysowanych przez pojedynczy JPanel
        for(int i=nPanel-1; i>0; i--)
            panels[i-1].add(panels[i]);
        add(panels[0]);

		//Sprawdzanie ile mamy dostepnych rdzeni procesora
		int coreCount = Runtime.getRuntime().availableProcessors();
        System.out.println("# dostepnych rdzeni procesora: " + coreCount);

		//Tworzenie ScheduledExecutorService'a z liczba watkow rowna liczbe dostepnych rdzeni
        ScheduledExecutorService service = Executors.newScheduledThreadPool(coreCount);

		int framesPerSecond = 60;
        // Uruchomienie wątków JPaneli
        for(DrawPanel iPanel : panels){
			// scheduleAtFixedRate zeby byly stale odstepy miedzy 'klatkami'
            service.scheduleAtFixedRate(iPanel,0,(int)(1000/framesPerSecond), TimeUnit.MILLISECONDS);
		}

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame("turbo kolka!!!", 100);
            }
        });
    }
}
