import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook
{
    private HashMap<String,String> Book = new HashMap<>();

    public void add(String Phone, String SecondName) //добавить в телефонную книгу номер и фамилию
    {
        Book.put(Phone,SecondName);
    }

    public void print() //вывести всю книгу
    {
        for (Map.Entry<String,String> o: Book.entrySet())
        {
            System.out.println(o.getKey()+": "+ o.getValue());
        }
    }

    public void getPhone(String SecondName) //поиск по фамилии
    {
        for (Map.Entry<String,String> o: Book.entrySet())
        {
            if(o.getValue().equals(SecondName))
            System.out.println("Выполнен поиск по фамилии "+o.getValue()+" "+o.getKey());
        }
    }

    public void getName(String Phone) //поиск по фамилии
    {
        for (Map.Entry<String,String> o: Book.entrySet())
        {
            if (o.getKey().equals(Phone))
                System.out.println("Выполнен поиск по телефону "+o.getKey() + ": " + o.getValue());
        }
    }



}
