import java.util.Random;
import java.util.Scanner;

public class Mission3
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
    {
        RandomGameCasino();
        String [] Words= {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
    }
    static void RandomGameCasino() // Угадай число за три попытки.
    {
        int RandomNumber= (int) (Math.random()*9);
        int NumberOfTry=3;
        int DoYouWannaPlay=1;
        while (DoYouWannaPlay>0)
        {
            System.out.println("Попробуй отгадать:");
            int input_number = scanner.nextInt();
            if (input_number==RandomNumber)
            {
                System.out.println("Вы победили, хотите еще раз? 1- да, 0 -нет");
                DoYouWannaPlay= scanner.nextInt();
            }
            else if (input_number>RandomNumber)
            {
                System.out.println("Загаданное число меньше");
                NumberOfTry-=1;
                System.out.println("Осталось попыток: "+NumberOfTry);
                if (NumberOfTry==0)
                {
                    System.out.println("Вы проиграли, хотите еще раз? 1- да, 0 -нет");
                    DoYouWannaPlay= scanner.nextInt();
                    NumberOfTry=3;
                }
            }
            else if (input_number<RandomNumber)
            {
                System.out.println("Загаданное число больше");
                NumberOfTry-=1;
                System.out.println("Осталось попыток: "+NumberOfTry);
                if (NumberOfTry==0)
                {
                    System.out.println("Вы проиграли, хотите еще раз? 1- да, 0 -нет");
                    DoYouWannaPlay= scanner.nextInt();
                    NumberOfTry=3;
                }
            }
        }
    }
}
