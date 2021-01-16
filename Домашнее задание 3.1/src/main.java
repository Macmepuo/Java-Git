import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args){
        Integer arr1[] = {5, 6, 7, 8};
        String arr2[] = {"A", "B", "C"} ;
        //1
        SwapToElements(arr1,0,1);
        SwapToElements(arr2,0,1);
        //2
        ArrayToArrayList(arr1);
        ArrayToArrayList(arr2);
        //3
        Box<Orange> or = new Box<>();
        Box<Orange> or1 = new Box<>();
        Box<Apple> ap = new Box<>();
        Box<Apple> ap1 = new Box<>();
        or.add(new Orange(),new Orange(),new Orange());
        or1.add(new Orange());
        ap.add(new Apple());
        ap1.add(new Apple());
        //d
        System.out.println("Вес Коробки 1: "+or.getWeight());
        System.out.println("Вес Коробки 2: "+or1.getWeight());
        System.out.println("Вес Коробки 3: "+ap.getWeight());
        System.out.println("Вес Коробки 4: "+ap1.getWeight());
        //e
        System.out.println(ap.compare(ap1));
        System.out.println(or.compare(or1));
        //f
        or.AddFromBox(or1);
        System.out.println("Вес коробки 1: " + or.getWeight());
    }
    //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
    public static void SwapToElements(Object[] arr, int index1, int index2){
        System.out.println("Current: "+ Arrays.toString(arr));
        Object sw = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=sw;
        System.out.println("Swap: "+Arrays.toString(arr));
    }
    //2. Написать метод, который преобразует массив в ArrayList;
    public static <T> List ArrayToArrayList(T[] arr) {
        List<T> NewList = new ArrayList<>();
        System.out.println("Начало преобразования массива в лист");
        for (int i = 0; i < arr.length;i++) {
            NewList.add((T) arr[i]);
            System.out.println(NewList.get(i));
        }
        System.out.println("Преобразование массива в лист завершено");
        return NewList;
    }
}
