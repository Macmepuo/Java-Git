package ru.geekbrains.racing.participants;

public abstract class Animal implements Participant, Jumpable, Walkable
{
    String type;
    String name;
    Color color;

    int maxRunDistance;
    int maxJumpHeight;

    boolean onDistance;

    @Override
    public boolean isOnDistance()
    {
        return onDistance;
    }

    @Override
    public void setOnDistance(boolean onDistance)
    {
        this.onDistance = onDistance;
    }

    public Animal(String type, String name, Color color, int maxRunDistance, int maxJumpHeight)
    {
        this.type = type;
        this.name = name;
        this.color = color;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance = true;
    }

    @Override
    public void run(int distance)
    {
        if (distance <= maxRunDistance)
        {
            System.out.println(this + " - Run OK");
        }
        else
        {
            System.out.println(this + " - Run FAILED");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height)
    {
        if (height <= maxJumpHeight)
        {
            System.out.println(this + " - Jump OK");
        }
        else
        {
            System.out.println(this + " - Jump FAILED");
            onDistance = false;
        }
    }

    @Override
    public String toString()
    {
        return color.getEnglishColorName()+" " +type + "" + name;
    }
}
