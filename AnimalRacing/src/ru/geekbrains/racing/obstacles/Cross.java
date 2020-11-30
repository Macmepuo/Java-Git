package ru.geekbrains.racing.obstacles;

import ru.geekbrains.racing.participants.*;

public class Cross extends Obstacle
{
    private int length;

    public Cross(int length)
    {
        this.length = length;
    }

    @Override
    public void doIt(Participant a)
    {
        if (a instanceof Walkable)
        {
            ((Walkable) a).run(length);
        }
        else
        {
            System.out.println(this + " - can't run");
            a.setOnDistance(false);
        }
    }
}
