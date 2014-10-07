package view;

/**
 * Created by Nastya on 07.10.2014.
 */
import model.Board;
import model.Cell;

import java.awt.*;

public class BoardView extends Canvas {

    public static  int rows = 6;
    public static  int cols = 7;
    public static int x=20;
    public static  int y=20;
    private Board field;

    public BoardView(){
        setSize(600,400);
    }

    public void BoardPanel(){
        BoardView wh = new BoardView();
        Frame fr = new Frame();
        fr.add(wh);
        fr.add(wh);
        fr.pack();// фиксирует размер окна
        fr.setTitle("4 в ряд");
        fr.setVisible(true);
    }


    public void Draw(Graphics g){

        field = new Board();
        Color oldColor=new Color(255, 125, 32);


        g.setColor(oldColor);
        Cell[][]cells= field.getCells();
        for (int r = 0; r < cells.length; r++){
            for (int c = 0; c < cells[r].length; c++){
                if (cells[r][c] != null){
                    g.drawRect(x,y,20,20);
                    g.fillRect(x,y,20,20);
                    x=x+20;
                    y=y+20;
                }

            }
        }
    }
}
