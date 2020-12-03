import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        list.add("C");
        list.add("C");
        list.add("A");
        list.add("B");
        list.add("A");
        HashMap<String, Integer> newlist = new HashMap<>();
        for (String x : list) {
            newlist.put(x, newlist.getOrDefault(x,0)+1);
        }
        System.out.println("Список слов"+newlist);
        PhoneBook Book = new PhoneBook();
        Book.add("8911119487","Sergeev");
        Book.add("8911119486","Stolnikova");
        Book.add("8911119485","Sergeev");
        Book.add("8911119484","Petrov");
        Book.print();
        Book.getPhone("Sergeev");
        Book.getName("8911119487");
    }
}
