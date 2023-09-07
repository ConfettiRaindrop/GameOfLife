public class Main {
    /*A living cell with two or three living neighbors survives to the next time step.
        A cell with no or one living neighbor dies.
        A dead cell with exactly three neighbors will be alive in the next time step. */
  public static void main(String[] args) {
    String[][] world = new String[10][10];
    for (int i = 0; i < 10; i++) {
    	for (int j = 0; j < 10; j++) {
        	if (life() == 1) {
        		world[i][j] = "■ "; //alive
                System.out.print(world[i][j]);
        	} else {
            	world [i][j] = "◻ "; //dead
                System.out.print(world[i][j]);
            }
        }
        System.out.println();
    }
  }
  
  public static int life() {
  	int check = (int)(Math.random()*10);
    check = check%2;
    return check;
  }
}
