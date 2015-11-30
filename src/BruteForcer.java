import java.util.ArrayList;

/**
 * Created by Martin on 30-11-2015.
 */
public class BruteForcer {
    private Grid grid;

    public BruteForcer(Grid grid){
        this.grid = grid;
    }

    public Grid getGrid(){
        return this.grid;
    }

    public boolean solve() {
        int x = 0;
        int y = 0;
        boolean backtrack = false;

        while(inBounds(x, y)){
            if (!backtrack && grid.getPosValue(x, y) == 0){
                backtrack = forward(x, y, backtrack);
            } else {
                backtrack = backtrack(x, y, backtrack);
            }

            int oldX = x;
            int oldY = y;

            if (backtrack){
                x = prevX(oldX, oldY);
                y = prevY(oldX, oldY);
            } else {
                x = nextX(oldX, oldY);
                y = nextY(oldX, oldY);
            }
        }

        return grid.isSolved();
    }

    private boolean backtrack(int x, int y, boolean backtrack){
        if (this.grid.getCell(x, y).hasMultiplePosValues()){
            this.grid.getCell(x, y).removeFirstPosValue();
            return false;
        }
        if (!this.grid.getCell(x, y).getIsKnown()){
            this.grid.getCell(x, y).setPosValue(0);
        }

        return backtrack;
    }

    private boolean forward(int x, int y, boolean backtrack){
        ArrayList<Integer> possible = this.grid.possibleCellValues(x, y);
        if (possible.isEmpty()){
            return true;
        } else {
            this.grid.getCell(x, y).setPosValues(possible);
        }
        return backtrack;
    }

    private boolean inBounds(int x, int y){
        return x > -1 && y > -1 && x < 9 && y < 9;
    }

    private int nextX(int x, int y) {return nextPos(x, y)[0]; }
    private int nextY(int x, int y) {return nextPos(x, y)[1]; }
    private int prevX(int x, int y) {return prevPos(x, y)[0]; }
    private int prevY(int x, int y) {return prevPos(x, y)[1];}

    private int[] prevPos(int x, int y) {
        if (x == 0){
            y--;
            x = 8;
        } else {
            x--;
        }
        int[] array = {x, y};
        return array;
    }

    private int[] nextPos(int x, int y){
        if ((x + 1) % 9 == 0){
            y++;
            x = 0;
        } else {
            x++;
        }
        int[] array = {x, y};
        return array;
    }

}
