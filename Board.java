package model;

/**
 * Created by Nastya on 07.10.2014.
 */
public class Board {
    public int row, col;
    public Cell[][] cells;
    //конструктор игрового поля
    public Board(int arow, int acol) {
        this.row = arow;
        this.col = acol;
        cells = new Cell[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                cells[i][j] = new Cell(0);
            }
        }
    }
    //метод обнуления поля
    public void Board_clear() {
        cells = new Cell[row][col];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                cells[i][j] = new Cell(0);
            }
        }
    }
    //функция проверки победы
    public boolean win(int avid) {
        boolean flag = false;
        //горизонталь 4 подряд идущих одинаковых шарика типа avid
        for (int i = 0; i < this.row; i++) {
        int j=0;
            while (j < this.col) {
                int rez=0;
                while ((j < this.col) && (cells[i][j]).getvid() == avid) {
                    rez++;
                    j++;
                }
                //если найдено 4 в ряд, то вернуть true;
                if (rez==4){flag=true;}
                j++;
            }
        }
        //вертикаль 4 подряд идущих одинаковых шарика типа avid
        for (int i = 0; i < this.col; i++) {
            int j=0;
            while (j < this.row) {
                int rez=0;
                while ((j < this.row) && (cells[j][i]).getvid() == avid) {
                    rez++;
                    j++;
                }
                //если найдено 4 в ряд, то вернуть true;
                if (rez==4){flag=true;}
                j++;
            }
        }
        //диагональ - проходим и для каждой точки проверяем условие победы(4 рядом)
        for (int j = 0; j < this.col; j++)
            for (int i = 0; i < this.row; i++)
            {
                try {
                    if ((cells[i][j].getvid() == avid) && (cells[i + 1][j + 1].getvid() == avid) && (cells[i + 2][j + 2].getvid() == avid) && (cells[i + 3][j + 3].getvid() == avid))
                    flag = true;}catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if ((cells[i][j].getvid() == avid) && (cells[i - 1][j + 1].getvid() == avid) && (cells[i - 2][j + 2].getvid() == avid) && (cells[i - 3][j + 3].getvid() == avid))
                    flag = true;}catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if ((cells[i][j].getvid() == avid) && (cells[i + 1][j - 1].getvid() == avid) && (cells[i + 2][j - 2].getvid() == avid) && (cells[i + 3][j - 3].getvid() == avid))
                    flag = true;}catch (ArrayIndexOutOfBoundsException e){}
                try {
                    if ((cells[i][j].getvid() == avid) && (cells[i - 1][j - 1].getvid() == avid) && (cells[i - 2][j - 2].getvid() == avid) && (cells[i - 3][j - 3].getvid() == avid))
                    flag = true;}catch (ArrayIndexOutOfBoundsException e){}
            }
        return flag;
    }
    //метод добавления нового шарика заданного вида(цвета) в нужный столбец, определяемый по координатам мышки
    public int add_brick(int ax, int avid) {
        int i = row - 1;
        //опускаем на дно
        while (cells[i][ax].getvid() != 0) {i--;}
        //ставим шарик
        cells[i][ax].setvid(avid);
        //проверяем, если достигнуто одно из условий победы - возвращаем номер победившего игрока
           if (win(avid)){
            return avid;
        }
        //иначе возвращаем ноль
        else return 0;
    }


    public int getrow(){
        return this.row;
    }
    public int getcol(){
        return this.col;
    }

    }
