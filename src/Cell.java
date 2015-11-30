import java.util.ArrayList;

/**
 * Created by Martin on 30-11-2015.
 */
public class Cell {

    private ArrayList<Integer> posValues;
    private boolean isKnown;

    public Cell(int value){
        this.posValues = new ArrayList<>();
        this.posValues.add(value);
        this.isKnown = false;
    }

    public void setIsKnown(){
        this.isKnown = true;
    }

    public boolean getIsKnown(){
        return this.isKnown;
    }

    public void setPosValues(ArrayList<Integer> values){
        this.posValues.clear();
        this.posValues.addAll(values);
    }

    public void setPosValue(int value){
        this.posValues.clear();
        this.posValues.add(value);
    }

    public int getFirstPosValue(){
        return posValues.get(0);
    }

    public void removeFirstPosValue(){
        posValues.remove(0);
    }

    public boolean hasMultiplePosValues() {
        return posValues.size() > 1;
    }

    public String toString(){
        return posValues.get(0).toString();
    }

}
