import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Board {
    public String[][] world = new String[10][10];

    public Board() {
        for (int i = 0; i < 10; i++) {
    	    for (int j = 0; j < 10; j++) {
            	if (life() == 1) {
            		world[i][j] = "■ "; //alive
            	} else {
                	world[i][j] = "◻ "; //dead
                }
                System.out.print(world[i][j]);
            }
            System.out.println();
        }
    }

    public int life() {
        int check = (int)(Math.random()*10);
        check = check%2;
        return check;
    }

    public boolean extinction() {
        for (String[]row : world) {
            for (String col : row) {
                if (col.equals("■ ")){
                    return false;
                }
            }
        }
        return true;
    }

    public int checkAround(int row, int col) {
        int count = 0;
        if ((row - 1) > -1) { //up
            count += checkAlive(row - 1, col);
        }
        if ((row + 1) < 10) { //down
            count += checkAlive(row + 1, col);
        }
        if ((col + 1) < 10) { //right 
            count += checkAlive(row, col + 1);
        }
        if ((col - 1) > -1) { //left check
            count += checkAlive(row, col - 1);
        }
        if (((row - 1) > -1) && ((col + 1) < 10)) { //up + right
            count += checkAlive(row - 1, col + 1);
        }
        if (((col + 1) < 10) && ((row + 1) < 10)) { //down + right 
            count += checkAlive(row + 1, col + 1);
        }
        if (((col - 1) > -1) && ((row - 1) > -1)) { //up + left
            count += checkAlive(row - 1, col - 1);
        }
        if (((row + 1) < 10) && ((col - 1) > -1)) { //down + left
            count += checkAlive(row + 1, col - 1);
        }
        return count;
    }

    public int checkAlive(int row, int col) {
        if(row < 0 || row > 9) {
            System.out.println("problem row: " + row);
            System.out.println("col: " + col);
        }
        if(col < 0 || col > 9) {
            System.out.println("problem col: " + row);
            System.out.println("row: " + row);
        }
        if (world[row][col].equals("■ ")) {
            return 1; //alive
        } else {
            return 0; //dead
        }
    }

    public String[][] copy(String[][] board) {
        String[][] newBoard = new String[10][10];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    public void testGame() {
        System.out.println("");
        String[][] test_world = {
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "},
            {"◻ ", "◻ ", "■ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","■ ","■ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","■ ","■ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","■ ","■ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "},
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "}, 
            {"◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ", "◻ ","◻ ","◻ "}
        };
        for (String[] row : test_world) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println("");
        }
        world = test_world;
        //runGame();
    }

    public void runGame(BufferedWriter writer) throws IOException, InterruptedException{
        for (String[] row : world) {
            for (String col : row) {
                writer.write(col);
            }
            writer.newLine();
        }
        writer.newLine();
        System.out.println();
        //int rounds = 0;
        while (!extinction()) {
            String[][] newWorld = copy(world);
            for (int i = 0; i < world.length; i++) {
                for (int j = 0; j < world[0].length; j++) {
                    int cellNeighbors = checkAround(i, j);
                    int cellStatus = checkAlive(i, j);
                    if (cellStatus == 1) {
                        if (cellNeighbors == 2) {
                            newWorld[i][j] = "■ ";
                        } else if (cellNeighbors == 3) {
                            newWorld[i][j] = "■ ";
                        } else {
                            newWorld[i][j] = "◻ ";
                        }
                    } else {
                        if(cellNeighbors == 3) {
                            newWorld[i][j] = "■ ";
                        } else {
                            newWorld[i][j] = "◻ ";
                        }
                    }
                    System.out.print(newWorld[i][j]);
                    writer.write(newWorld[i][j]);
                }
                System.out.println();
                writer.newLine();
            }
            System.out.println();
            writer.newLine();
            Thread.sleep((long) 200.0);
            //rounds++;
            world = newWorld;
        }
      
    }
    
    public static void main(String[] args) throws IOException, InterruptedException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("GOL.txt"));
        Board game = new Board();
        game.runGame(writer);
        
        writer.flush();
        writer.close();
        
    }

}
