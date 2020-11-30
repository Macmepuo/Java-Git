package ru.geekbrains.racing.obstacles;

import ru.geekbrains.racing.participants.Animal;
import ru.geekbrains.racing.participants.Participant;
import ru.geekbrains.racing.participants.Robot;
import ru.geekbrains.racing.participants.Swimable;

public class Water extends Obstacle
{
    private int length;

    public Water(int length)
    {
        this.length = length;
    }

    @Override
    public void doIt(Participant a)
    {
        if (a instanceof Swimable)
        {
            ((Swimable) a).swim(length);
        }
        else
            {
            System.out.println(this + " - can't swim");
            a.setOnDistance(false);
        }
    }
}
