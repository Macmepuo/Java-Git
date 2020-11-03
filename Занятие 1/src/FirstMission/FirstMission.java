package FirstMission;

import java.time.temporal.ValueRange;

public class FirstMission
{
    public static void main(String[] args)
    {
//      byte maxb=127;
//      byte minb=-127;
//      short maxs=32767;
//      short mins=-32768;
//      int maxi=2147483647;
//      int mini=-2147483648;
//      long maxl=2147483647; //это нормально, что такой же диапозон как у int?
//      long minl=2147483647;
//      float floa= 3.4f;
//      double doubl= 3.4;
//      char cha= 'З';
//      boolean truet=true;
//      boolean falsef=false;
        System.out.println("Результат вычислений -" + FirstCalculation(2,2,2,3));
        System.out.println("Сумма от 10 до 20? -" + IsSumBetween10And20(10,4));
        CheckPlusOrMinus(1);
        CheckPlusOrMinus(-1);
        System.out.println("Число отрицательное -"+ CheckMinus(-1));
        SendHelloTo("Илья");
        System.out.println("Год высокосный -"+CheckLeapYear (33));
    }
    static float FirstCalculation (float a3,float b3, float c3,float d3)
    {
        return a3*(b3+c3/d3);
    }
    static boolean IsSumBetween10And20 (int a4, int b4) // Edit. Не понял, где тут лишние вычисления?
    {
        return a4 + b4 > 10 && a4 + b4 <= 20;
    }
    static void CheckPlusOrMinus (int a5)
    {
        if (a5>=0)
            System.out.println("Положительное");
        else
            System.out.println("Отрицательное");
    }
    static boolean CheckMinus (int a6)
    {
            return a6<0;
    }
    static void SendHelloTo (String a7)
    {
        System.out.println("Привет,"+a7);
    }
    static boolean CheckLeapYear (int a8)
    {
        return (a8 % 4 ==0 && a8 % 100 !=0) || a8%400==0;
    }
}
