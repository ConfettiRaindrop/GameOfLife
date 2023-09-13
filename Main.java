import javax.swing.JFrame;

public class Main {
    /*A living cell with two or three living neighbors survives to the next time step.
        A cell with no or one living neighbor dies.
        A dead cell with exactly three neighbors will be alive in the next time step. */
  public static void main(String[] args) {
    Board game = new Board();
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        testUI();
      }
    });
    //game.runGame();
  }

  public static void testUI() {
    JFrame frame = new JFrame("worldOfLife");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.pack();
    frame.setVisible(true);
  }

}

