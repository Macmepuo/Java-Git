package ru.geekbrains.racing.obstacles;

import ru.geekbrains.racing.participants.Participant;
import ru.geekbrains.racing.participants.Team;

public class Course
{
    private final Obstacle[] obstacles;

    public Course(Obstacle... obstacles)
    {
        this.obstacles= obstacles;
    }

    public void doIt(Team team)
    {
        for (Participant p: team.getParticipants())
        {
            for(Obstacle o: obstacles)
            {
                o.doIt(p);
                if(!p.isOnDistance())
                {
                    break;
                }
            }
        }
    }
}
