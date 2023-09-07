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
        if ((col - 1) > -1) { //up
            count += checkAlive(row, col - 1);
        } else if ((col + 1) < 9) { //down
            count += checkAlive(row, col + 1);
        } else if ((row + 1) < 9) { //right
            count += checkAlive(row + 1, col);
        } else if ((row - 1) > -1) { //left
            count += checkAlive(row - 1, col);
        } else if (((col - 1) > -1) && ((row + 1) < 9)) { //up + right
            count += checkAlive(row + 1, col - 1);
        } else if (((col + 1) > 9) && ((row + 1) < 9)) { //down + right
            count += checkAlive(row + 1, col + 1);
        } else if (((col - 1) > -1) && ((row - 1) > -1)) { //up + left
            count += checkAlive(row - 1, col - 1);
        } else if (((col + 1) < 9) && ((row - 1) > -1)) { //down + left
            count += checkAlive(row - 1, col + 1);
        }
        return count;
    }

    public int checkAlive(int row, int col) {
             if (world[row][col] == "■ ") {
                return 1; //alive
            } else {
                return 0; //dead
            }
    }

    public void runGame() {
        while (!extinction()) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int cellNeighbors = checkAround(i, j);
                    int cellStatus = checkAlive(i, j);
                    if (cellStatus == 1) {
                        if (cellNeighbors == 2) {
                            continue;
                        } else if (cellNeighbors == 3) {
                            continue;
                        } else {
                            world[i][j] = "◻ ";
                        }
                    } else {
                        if(cellNeighbors == 3) {
                            world[i][j] = "■ ";
                        }
                    }
                    System.out.print(world[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    //when testing try to look to see if asymmetrical is so check w/ Mr. Puri for debugging help
}
