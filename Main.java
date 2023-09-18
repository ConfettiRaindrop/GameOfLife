import javax.swing.JFrame;

public class Main {
    /*A living cell with two or three living neighbors survives to the next time step.
        A cell with no or one living neighbor dies.
        A dead cell with exactly three neighbors will be alive in the next time step. */
  public static void main(String[] args) {
    Board game = new Board();
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        TableUI world = new TableUI(game.world);
        world.createAndShowGUI(game.world);
      }
    });
    //game.runGame();
  }




  /*
   * https://docs.oracle.com/javase/tutorial/uiswing/components/table.html
   * https://docs.oracle.com/javase/tutorial/uiswing/examples/components/index.html#SimpleTableDemo
   * https://docs.oracle.com/javase/tutorial/uiswing/components/componentlist.html
   * https://docs.oracle.com/javase/tutorial/uiswing/components/index.html
   * 
   */

}

