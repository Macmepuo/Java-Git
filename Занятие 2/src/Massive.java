import java.util.Arrays;

public class Massive
{
    public static void main (String[] args)
    {
       // Первое задание. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
       int [] change0to1= {1,1,0,0,1};
       for (int i=0; i<change0to1.length; i++)
       {
           if (change0to1[i]==0)
               change0to1[i]=1;
           else if (change0to1[i]==1)
               change0to1[i]=0;
       }
       System.out.println("Отформатированный массив 0 и 1: "+Arrays.toString(change0to1));
       // Второе задание. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
       int [] empty= new int [8];
       for (int i=0; i<empty.length; i++)
       {
           if (i==0)
               empty[i]=0;
           else
               empty[i]=i*3;
       }
       System.out.println("Заполненяем пустой массив: "+Arrays.toString(empty));
       // Третье задание. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2.
       int [] ChangeArrLessSix= {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
       for (int i=0; i<ChangeArrLessSix.length; i++)
       {
           if (ChangeArrLessSix[i]<6)
               ChangeArrLessSix[i]*=2;
       }
       System.out.println("Отформатированный массив x2: "+Arrays.toString(ChangeArrLessSix));
       // Четвертое задание. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
       int [][] EmptySquare= new int [8][8];
       System.out.println("Заполненный двухмерный массив:");
       for (int i=0; i<EmptySquare.length; i++)
       {
           for (int j=0; j<EmptySquare[i].length; j++)
           {
               if (i == j)
               {
                   EmptySquare[i][j] = 1;
                   int help=EmptySquare.length-i-1; // Подскажите пожалуйста почему некорректно заполняется массив по второй диагонали, таким способом?
                   EmptySquare[i][help]=1; //значения help я проверял, считаются корректно, но после прохождения центра массива, ячейки перестают заполняться.
               }
               System.out.print(EmptySquare[i][j]);
           }
           System.out.println("");
       }
       // Пятое задание.Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
       int [] LookingForExtremum= {2, 2, 2, 1, 2, 2, 10, 1};
       int max=LookingForExtremum[0];
       int min=LookingForExtremum[0];
       for (int i=0; i<LookingForExtremum.length; i++)
       {
           if (LookingForExtremum[i]>max)
               max=LookingForExtremum[i];
           if (LookingForExtremum[i]<min)
               min=LookingForExtremum[i];
       }
       System.out.println("Максимум равен:"+max+"; Минимум равен: "+min);
       // Шестое задание. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
       // если в массиве есть место, в котором сумма левой и правой части массива равны.
       // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
       // граница показана символами ||, эти символы в массив не входят.
       System.out.println("Соблюдается ли баланс?: "+CheckBalance(LookingForExtremum));
       // Седьмое задание. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
       // при этом метод должен сместить все элементы массива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
       int [] ArrayToShift= {1,2,3,4,5};
       int ShiftNumber=-2;
       ChangePositionOfArrToN(ArrayToShift, ShiftNumber);
       System.out.println("Исходный массив сдвинут на "+ShiftNumber+" : "+Arrays.toString(ArrayToShift));
    }
    static boolean CheckBalance (int [] arr)
    {
        int MaxSumOfElementsArray=0;
        for (int i=0; i<arr.length; i++)
        {
           MaxSumOfElementsArray+=arr[i];
        }
        int CurrentSumOfElementsArray=0;
        boolean StatementOfCheck = false;
        for (int i=0; i<arr.length; i++)
        {
            CurrentSumOfElementsArray+=arr[i];
            if (CurrentSumOfElementsArray==(MaxSumOfElementsArray-CurrentSumOfElementsArray)) 
            {
                StatementOfCheck=true;  
            }
        }
        return StatementOfCheck;
    }
    static void ChangePositionOfArrToRight (int [] arr) // Вспомогательный метод, если n>0
    {
        int RememberTheFirstElementOfArr=arr[0];
        arr[0]=arr[arr.length-1];
        for (int i=1; i< arr.length-1; i++)
        {
            arr[arr.length-i]=arr[arr.length-i-1];
        }
        arr[1]=RememberTheFirstElementOfArr;
    }
    static void ChangePositionOfArrToLeft (int [] arr) // Вспомогательный метод, если n<0
    {
        int RememberTheFirstElementOfArr=arr[0];
        for (int i=1; i< arr.length; i++)
        {
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=RememberTheFirstElementOfArr;
    }
    static void ChangePositionOfArrToN(int [] arr, int n) // Итоговый метод
    {
        if (n>0)
        {
            for(int i=n-1;i>=0;i--)
            {
                ChangePositionOfArrToRight(arr);
            }
        }
        else if (n<0)
        {
            for(int i=n+1;i<=0;i++)
            {
                ChangePositionOfArrToLeft(arr);
            }
        }
    }
}
