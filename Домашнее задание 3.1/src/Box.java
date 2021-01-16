import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Box<T extends Fruit> {
    private ArrayList<T> box;

    Box(T... box){
        this.box= new ArrayList<>(Arrays.asList(box));
    }

    public void add(T... fruits) {
        this.box.addAll(new ArrayList<>(Arrays.asList(fruits)));
    }

    //Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
    // (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
    public float getWeight() {
        float weight = 0;
        for (T fruit : box) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    //Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
    // которую подадут в compare в качестве параметра, true - если их веса равны,
    // false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
    public boolean compare(Box<T> box1) {
        return this.getWeight() == box1.getWeight();
    }

    //Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
    // (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
    // соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
    // которые были в этой коробке;
    public void AddFromBox(Box<T> box1) {
        this.box.addAll(box1.box);
        box1.clear();
    }

    private void clear() {
        this.box.clear();
    }
}

