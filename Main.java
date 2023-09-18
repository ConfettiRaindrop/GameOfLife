import javax.swing.JFrame;

public class Main {
    /*A living cell with two or three living neighbors survives to the next time step.
        A cell with no or one living neighbor dies.
        A dead cell with exactly three neighbors will be alive in the next time step. */
  public static void main(String[] args) {
    Board game = new Board();
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI(game.world);
      }
    });
    //game.runGame();
  }



  public static void createAndShowGUI(String[][] game) {
    JFrame frame = new JFrame("worldOfLife");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    TableUI newConcentPane = new TableUI(game);
    newConcentPane.setOpaque(true);
    frame.setContentPane(newConcentPane);

    frame.pack();
    frame.setVisible(true);
  }
  /*
   * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
   * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#SimpleTableDemo
   * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html
   * https://docs.oracle.com/javase/tutorial/uiswing/components/index.html
   * 
   */

}

