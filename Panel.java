import javax.swing.*;
import java.awt.*;

/**
 * Created by Nastya on 07.10.2014.
 */

class Panel extends JPanel {
    Board my_board;
    int size;

    public Panel(Board amy_board,int asize){
        my_board=amy_board;
        size=asize;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x =0;
        int y =0;
        //рисование поля сначала и после каждого изменения
        for (int i = 0; i < my_board.getrow(); i++) {
            for (int j = 0; j < my_board.getcol(); j++) {
                //если 1-1 игрок
                if (my_board.cells[i][j].getvid() == 1) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, size, size);
                    //если 2-й игрок
                } else if(my_board.cells[i][j].getvid() == 2){
                    g.setColor(Color.green);
                    g.fillOval(x, y, size, size);
                }
                //рисуем клетки в любом случае
                my_board.cells[i][j].x = j;
                g.setColor(Color.BLACK);
                g.drawRect(x, y, size, size);
                x = x + size;
            }
            x = 0;
            y = y + size;
        }
    }
}
