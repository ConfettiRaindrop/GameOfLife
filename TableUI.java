import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.GridLayout;

public class TableUI extends JPanel {
    
    public TableUI(String[][] game) { 
        super(new GridLayout(1, 0));

        String[] coulmms = {"this",
                            "is", 
                            "a", 
                            "test"};
        Object[][] rows = {
            {"Hello", "World"}, 
            {"palindrome", "tacocat"}, 
            {"god", "I", "hope", "this", "works"}
        };

        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

    }

    public static void createAndShowGUI(String[][] game) {
        JFrame frame = new JFrame("worldOfLife");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        TableUI newContentPane = new TableUI(game);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);
    
        frame.pack();
        frame.setVisible(true);
    }

      public static void main(String[] args) {
        Board game = new Board();
    
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            createAndShowGUI(game.world);
          }
        });
    }



}
