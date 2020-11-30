package ru.geekbrains.racing.participants;

public  class Robot implements Participant, Walkable, Jumpable, Swimable
{
    private final String type;
    private final Color color;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public boolean isOnDistance()
    {
        return onDistance;
    }

    public void setOnDistance(boolean onDistance)
    {
        this.onDistance = onDistance;
    }

    public Robot(String type, Color color, int maxRunDistance, int maxJumpHeight, int maxSwimDistance)
    {
        this.type = type;
        this.color = color;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance= maxSwimDistance;
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
    @Override
    public String toString()
    {
        return color.getEnglishColorName()+" " +type;
    }
}
