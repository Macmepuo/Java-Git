import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class KrestikiNoliki
{
    static char [][] Map;
    static final char Map_Empty= '.';
    static final char Map_X= 'X';
    static final char Map_O= 'O';
    static int input_Size;

    public static void main(String[] args)
    {
        InputMap(); //Ввод поля
        PrintMap(); //Вывод текущего поля
        while(true)
        {
            HumanTurn();
            PrintMap();
            if (CheckVictory(Map_X, input_Size))
            {
                System.out.println("Победа игрока");
                break;
            }
            if (CheckDraw())
            {
                System.out.println("Ничья");
                break;
            }
            AIDumpTurn();
            PrintMap();
            if (CheckVictory(Map_O, input_Size))
            {
                System.out.println("Победа бота");
                break;
            }
            if (CheckDraw())
            {
                System.out.println("Ничья");
                break;
            }
        }
    }

    static void InputMap() // Вводится размер игрового поля любого размера, его ячейки заполняются.
    {
        System.out.println("Введите размер поля, 3 или 5:");
        Scanner scanner= new Scanner(System.in);
        input_Size = scanner.nextInt();
        Map= new char[input_Size][input_Size];
        for (int Row=0; Row< input_Size; Row++)
        {
            for (int Columns =0; Columns < input_Size; Columns++)
            {
                Map[Row][Columns]= Map_Empty;
            }
        }
    }

    static void PrintMap() // Выводит текущее поле на экран
    {
        for (int i=0; i <=Map.length; i++)
        {
            if (i==0)
                System.out.print("  ");
            else
                System.out.print(i+" ");
        }
        System.out.println();
        for (int Row=0; Row< Map.length; Row++)
        {
            System.out.print((Row+1)+ " ");
            for (int Columns =0; Columns < Map[Row].length; Columns++)
            {
                System.out.print(Map[Row][Columns]+ " ");
            }
            System.out.println();
        }
    }

    static void HumanTurn() // Ход игрока
    {
        Scanner scanner= new Scanner(System.in);
        int Row;
        int Columns;
        do
        {
            System.out.println("Введите координаты в формате X Y");
            Row= scanner.nextInt()-1;
            Columns= scanner.nextInt()-1;

        } while (!IsCellEmpty(Row, Columns)); // Проверка ячейки
        Map[Row][Columns]= Map_X;
    }

    static void AIDumpTurn() //Простой бот, не работает функция Random, замена на Math.random.
    {
        int Row;
        int Columns;
        do
        {
            Row= (int) (Math.random()*3);
            Columns= (int) (Math.random()*3);
        } while (!IsCellEmpty(Row, Columns)); // Проверка ячейки
        Map[Row][Columns]= Map_O;
        System.out.println("Компьютер сходил по координатам"+(Row+1)+" "+(Columns+1));
    }

    static boolean CheckVictory(char Symbol, int Size) //универсальная проверка победы циклами.
    {
        int RowCheck=0;
        int ColumnCheck=0;
        int DiagonalCheck=0;
        for (int Row=0; Row< Map.length; Row++) // проверка по строкам
        {
            for (int Columns =0; Columns < Map[Row].length; Columns++)
            {
                if (Map[Row][Columns]==Symbol) //проверка строки
                {
                    RowCheck++;
                    if (input_Size==3 && RowCheck==input_Size) return true;
                    if (input_Size>3 && RowCheck==input_Size-1) return true;
                }
            }
            RowCheck=0;
        }
        for (int Columns =0; Columns < Map.length; Columns++) //проверка по столбцам
        {
            for (int Row=0; Row< Map.length; Row++)
            {
                if (Map[Row][Columns]==Symbol) //проверка столбца
                {
                    ColumnCheck++;
                    if (input_Size==3 && ColumnCheck==input_Size) return true;
                    if (input_Size==5 && ColumnCheck==input_Size-1) return true;
                }
            }
            ColumnCheck=0;
        }
        for (int Row=0; Row< Map.length; Row++) //проверка первой диагонали
        {
            if (Map[Row][Row]==Symbol)
            {
                DiagonalCheck++;
                if (input_Size==3 && DiagonalCheck==input_Size) return true;
                if (input_Size==5 && DiagonalCheck==input_Size-1) return true;
            }
        }
        DiagonalCheck=0;
        int j=0;
        for (int i=Map.length-1; i>=0; i--) //проверка второй диагонали
        {
            if (Map[j][i]==Symbol)
            {
                DiagonalCheck++;
                if (input_Size==3 && DiagonalCheck==input_Size) return true;
                if (input_Size==5 && DiagonalCheck==input_Size-1) return true;
            }
            j++;
        }
        return false;
    }

    static boolean CheckDraw() //проверка ничьи
    {
        for (int Row=0; Row< Map.length; Row++) // проверка по строкам
        {
            for (int Columns =0; Columns < Map[Row].length; Columns++)
            {
                if (Map[Row][Columns]==Map_Empty) //проверка строки
                {
                        return false;
                }
            }
        }
        return true;
    }

    static boolean IsCellEmpty(int Row, int Columns) // Проверяем допустимая ли ячейка
    {
        if(Row<0 || Row >= Map.length || Columns<0 || Columns >= Map.length)
        {
            return false;
        }
        if (Map[Row][Columns] == Map_Empty)
        {
            return true;
        }
        return false;
    }
}
