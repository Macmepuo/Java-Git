package ru.geekbrains.racing.participants;

public class Dog extends Animal implements Swimable{

    private int maxSwimDistance;

    public Dog(String name, Color color)
    {
        super("Dog", name, color, 1000, 50);
        maxSwimDistance = 10;
    }

    @Override
    public void swim(int distance) {
        if (distance <= maxSwimDistance) {
            System.out.println(this + " - Swim OK");
        } else {
            System.out.println(this + " - Swim FAILED");
            onDistance = false;
        }
    }
}
