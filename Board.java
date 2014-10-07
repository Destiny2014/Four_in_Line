package model;

/**
 * Created by Nastya on 07.10.2014.
 */
public class Board {

    public static  int rows = 6;
    public static  int cols = 7;

    private Cell[][] cells;

    public Board() {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                cells[i][j] = new Cell();
                cells[i][j].setMark(Cell.CellMark.EMPTY);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
