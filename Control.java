import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Nastya on 07.10.2014.
 */
 
public class Control {
    JFrame frame;
    Board my_board;
    int my_size;
    int step;
    public Control(JFrame jf, Board amy_board, int amy_size, int astep) {
        frame=jf;
        my_board=amy_board;
        my_size=amy_size;
        step=astep;
    }
    
     public void GoGame()
     {
        //обработчик событий, вызываемых мышей. КЛИК ЛЕВОЙ КНОПКОЙ ПОКА
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int q=0;
                //добавить кирпич
                q=my_board.add_brick((e.getX()-9)/my_size,(step%2)+1);
                //перерисовка панели
                frame.repaint();
                //смотрим выиграли ли игрок после своего хода...
                if (q==1){
                    JOptionPane.showMessageDialog(null, String.valueOf("Выиграл синий игрок"));
                }
                if (q==2){JOptionPane.showMessageDialog(null, String.valueOf("Выиграл зеленый игрок"));
                }
                //конец игры и начало новой: очистка и перерисовка
                if(q!=0){my_board.Board_clear();frame.repaint();}
                //для смены игроков
                step++;
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

}
