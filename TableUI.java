import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TableUI extends JPanel {
    
    public TableUI(String[][] game) {
        super(new GridLayout(1, 0));

        String[] coulmms = new String[game.length];
        String[][] rows = game;

        JTable table = new JTable(rows, coulmms);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        
    }


}
