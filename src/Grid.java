import java.lang.reflect.Array;
import java.util.ArrayList;

public class Grid {
    private final int gridSize = 9;

    private Cell[][] cells;

    public Grid(int[][] values) {
        this.cells = new Cell[gridSize][gridSize];
        for(int x = 0; x < this.gridSize; x++) {
            for (int y = 0; y < this.gridSize; y++){
                this.cells[x][y] = new Cell(values[x][y]);
                if (values[x][y] != 0){
                    this.cells[x][y].setIsKnown();
                }
            }
        }
    }

    public Cell getCell(int x, int y){
        return this.cells[x][y];
    }

    public int getPosValue(int x, int y){
        return this.getCell(x, y).getFirstPosValue();
    }

    public boolean isSolved() {
        boolean isSolved = true;
        for(int x = 0; x < this.gridSize; x++){
            for (int y = 0; y < this.gridSize; y++){
                if (this.getPosValue(x, y) == 0){
                    isSolved = false;
                    break;
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> possibleCellValues(int x, int y){
        ArrayList<Integer> possibleValues = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            if (isValLegal(x, y, i)){
                possibleValues.add(i);
            }
        }
        return possibleValues;
    }

    private boolean isValLegal(int x, int y, int value){
        for (int i = 0; i < this.gridSize; i++){
            if (getPosValue(i, y) == value || getPosValue(x, i) == value){
                return false;
            }
        }

        int offsetX = (x/3) * 3;
        int offsetY = (y/3) * 3;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (this.getPosValue(offsetX + i, offsetY + j) == value){
                    return false;
                }
            }
        }

        return true;
    }

    public String toString(){
        String line = "-------------------------\n";
        String str = line;
        for (int i = 0; i < this.gridSize; i++){
            str += "| ";
            for (int j = 0; j < this.gridSize; j++){
                int cellValue = getPosValue(j, i);
                if (cellValue == 0){
                    str += "  ";
                } else {
                    str += cellValue + " ";
                }
                if ((j + 1) % 3 == 0) {
                    str += "| ";
                }
            }
            str += "\n";
            if ((i + 1) % 3 == 0) {
                str += line;
            }
        }
        return str;
    }
}
