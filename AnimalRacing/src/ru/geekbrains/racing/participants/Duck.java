package ru.geekbrains.racing.participants;

public class Duck extends Animal implements Swimable {

    private int maxSwimDistance;

    public Duck(String name, Color color)
    {
        super("Duck", name, color,100, 50);
        maxSwimDistance = 100;
    }

    @Override
    public void swim(int distance)
    {
        if (distance <= maxSwimDistance)
        {
            System.out.println(this + " - Swim OK");
        }
        else
        {
            System.out.println(this + " - Swim FAILED");
            onDistance = false;
        }
    }
}
