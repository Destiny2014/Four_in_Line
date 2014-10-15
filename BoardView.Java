import javax.swing.*;

/**
 * Created by Nastya on 07.10.2014.
 */
public class Boardview extends JFrame{
    public int my_size=50;//размер клетки
    public int my_rows=10;//количество строк
    public int my_cols=10;//количество столбцов
    public static int step=0;//
    public JFrame frame;
    public Control ctrl;

    Board my_board = new Board(my_rows,my_cols);//создаем объект поле
    JPanel contentPane = new Panel(my_board,my_size);


    public Boardview()
    {
        frame = new JFrame();
        frame.setTitle("4 в РЯД V1.1");
        frame.setSize(my_size * my_cols + 17, my_size * my_rows + 39);//задаем окно нужного размера
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        ctrl=new Control(frame,my_board,my_size,step);
    }

    public void Go()
    {
        ctrl.GoGame();
    }
}
