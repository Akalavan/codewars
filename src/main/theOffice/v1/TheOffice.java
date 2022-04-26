package main.theOffice.v1;

/*
Your colleagues have been looking over you shoulder. When you should have been doing your boring real job,
you've been using the work computers to smash in endless hours of codewars.

In a team meeting, a terrible, awful person declares to the group that you aren't working.
You're in trouble. You quickly have to gauge the feeling in the room to decide whether or not you should gather your things and leave.

Given a Person array (meet) containing team members, you need to assess the overall happiness rating of the group. If <= 5, return "Get Out Now!".
Else return "Nice Work Champ!".

The Person class looks like:

class Person {
  final String name;    // team memnber's name
  final int happiness;  // happiness rating out of 10
}

Happiness rating will be total score / number of people in the room.

Note that your boss is in the room (boss), their score is worth double it's face value (but they are still just one person!).
 */

import java.util.Arrays;

public class TheOffice {
    public static String outed(Person[] meet, String boss) {

        return Arrays.stream(meet)
                .mapToInt(person -> person.getName().equals(boss) ? person.getHappiness() * 2 : person.getHappiness())
                .average()
                .orElse(0.0) <= 5 ? "Get Out Now!" : "Nice Work Champ!";



    }

    public static void main(String[] args) {
        Person[] meet = new Person[]{
                new Person("tim", 0),
                new Person("jim", 2),
                new Person("randy", 0),
                new Person("sandy", 7),
                new Person("andy", 0),
                new Person("katie", 5),
                new Person("laura", 1),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 0)
        };
        System.out.println(TheOffice.outed(meet, "laura"));
        //"Get Out Now!", TheOffice.outed(meet, "laura"));

        Person[] meet1 = new Person[] {
                new Person("tim", 1),
                new Person("jim", 3),
                new Person("randy", 9),
                new Person("sandy", 6),
                new Person("andy", 7),
                new Person("katie", 6),
                new Person("laura", 9),
                new Person("saajid", 9),
                new Person("alex", 9),
                new Person("john", 9),
                new Person("mr", 8)
        };

        System.out.println(TheOffice.outed(meet1, "katie"));

        Person[] meet2 = new Person[] {
                new Person("tim", 2),
                new Person("jim", 4),
                new Person("randy", 0),
                new Person("sandy", 5),
                new Person("andy", 8),
                new Person("katie", 6),
                new Person("laura", 2),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 8),
        };

        System.out.println(TheOffice.outed(meet2, "john"));


        Person[] meet3 = new Person[] {
                new Person("tim", 9),
                new Person("jim", 2),
                new Person("randy", 8),
                new Person("sandy", 4),
                new Person("andy", 2),
                new Person("katie", 1),
                new Person("laura", 5),
                new Person("saajid", 6),
                new Person("alex", 7),
                new Person("john", 6),
                new Person("mr", 5),
        };

        System.out.println(TheOffice.outed(meet3, "john"));
    }
}
