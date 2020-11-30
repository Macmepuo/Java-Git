package ru.geekbrains.racing.participants;

public class Team
{
    private final Participant[] participants;

    public Team (Participant... participants)
    {
        this.participants= participants;
    }

    public Participant[] getParticipants()
    {
        return participants;
    }

    public void showResults()
    {
        System.out.println("Results:");
        for(Participant p: participants)
        {
            System.out.println(p+ ": " + p.isOnDistance());
        }
    }
}
