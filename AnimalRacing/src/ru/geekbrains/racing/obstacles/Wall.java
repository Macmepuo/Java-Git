package ru.geekbrains.racing.obstacles;

import ru.geekbrains.racing.participants.*;

public class Wall extends Obstacle
{
    private int height;

    public Wall(int height)
    {
        this.height = height;
    }

    @Override
    public void doIt (Participant a)
    {
        if (a instanceof Jumpable)
        {
            ((Jumpable) a).jump(height);
        }
        else
        {
            System.out.println(this + " - can't jump");
            a.setOnDistance(false);
        }
    }
}
