package ru.geekbrains.racing;

import ru.geekbrains.racing.obstacles.*;
import ru.geekbrains.racing.participants.*;

public class Main {
    public static void main(String[] args)
    {
        final Team team = new Team(
            new Cat("Barsik", Color.RED),
            new Dog("Bobik", Color.BLACK),
            new Duck("Scrooge", Color.WHITE),
            new Robot("RB-2", Color.RED, 200, 100, 100)
        );

        final Course course = new Course
        (
            new Cross(100),
            new Wall(10),
            new Water(15)
        );

        course.doIt(team);
        team.showResults(); // почему то на коте выводится не так как надо
    }
}
