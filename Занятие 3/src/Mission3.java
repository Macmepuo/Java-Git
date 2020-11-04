import java.util.Random;
import java.util.Scanner;

public class Mission3
{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
    {
        System.out.println("Выберите игру: 1- Угадать цифру от 0 до 9; 2- Угадать слово");
        int input_Game = scanner.nextInt();
        if (input_Game==1)
        {
            RandomGameCasino();
        }
        else
        {
            RandomGameWord();
        }
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
    static void RandomGameWord () //Угадай слово
    {
        String [] Words= {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        int random_IndexOfWord= (int) (Math.random()*(Words.length-1));
        int Victory=0;
        while (Victory==0)
        {
            System.out.println(System.lineSeparator()+"Введите слово");
            Scanner in = new Scanner(System.in);
            String input_Word = in.nextLine();
            if (input_Word.equals(Words[random_IndexOfWord]))
            {
                Victory=1;
            }
            else
            {
              for(int i=0;i<15;i++)
              {
                  if (i<input_Word.length() && i<Words[random_IndexOfWord].length() && input_Word.charAt(i) == Words[random_IndexOfWord].charAt(i))
                  {
                      System.out.print(input_Word.charAt(i));
                  }
                  else
                      System.out.print("*");
              }
            }
        }
        System.out.println("Вы отгадали");
    }
}
