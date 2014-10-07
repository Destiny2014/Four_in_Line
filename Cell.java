package model;

/**
 * Created by Nastya on 07.10.2014.
 */
public class Cell {

    public enum CellMark { X, O, EMPTY };

    private Coord coordinate;
    private CellMark mark;

    public Coord getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coord coordinate) {
        this.coordinate = coordinate;
    }

    public CellMark getMark() {
        return mark;
    }

    public void setMark(CellMark mark) {
        this.mark = mark;
    }
}
