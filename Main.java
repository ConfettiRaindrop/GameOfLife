
public class Main {
    /*A living cell with two or three living neighbors survives to the next time step.
        A cell with no or one living neighbor dies.
        A dead cell with exactly three neighbors will be alive in the next time step. */
  public static void main(String[] args) {
    String[][] test = {{"Hello", "Goodbye"}};
    String[][] copied = test.clone();
    copied[0][0] = "change";
    System.out.println(test[0][0]);
    System.out.println(copied[0][0]);
    Board game = new Board();
    game.testGame();
  }

}

