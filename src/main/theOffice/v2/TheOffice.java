package main.theOffice.v2;

/*
Every now and then people in the office moves teams or departments.
Depending what people are doing with their time they can become more or less boring. Time to assess the current team.

You will be provided with an array of Person objects with each instance containing the name and department for a staff member.

public class Person {
  public final String name;        // name of the staff member
  public final String department;  // department they work in
}

Each department has a different boredom assessment score, as follows:

accounts = 1
finance = 2
canteen = 10
regulation = 3
trading = 6
change = 6
IS = 8
retail = 5
cleaning = 4
pissing about = 25

Depending on the cumulative score of the team, return the appropriate sentiment:

<=80: 'kill me now'
< 100 & > 80: 'i can handle this'
100 or over: 'party time!!'
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheOffice {

    static Map<String, Integer> departments = new HashMap<>();

    static {
        departments.put("accounts", 1);
        departments.put("finance", 2);
        departments.put("canteen", 10);
        departments.put("regulation", 3);
        departments.put("trading", 6);
        departments.put("change", 6);
        departments.put("IS", 8);
        departments.put("retail", 5);
        departments.put("cleaning", 4);
        departments.put("pissing about", 25);
    }

    public static String boredom(Person[] staff) {
        int sum = Arrays.stream(staff)
                .mapToInt(person -> departments.get(person.department))
                .sum();
        return sum <= 80 ? "kill me now" : sum < 100 ? "i can handle this" : "party time!!";
    }

    public static void main(String[] args) {
        Person[] teem = new Person[]{
                new Person("tim", "change"),
                new Person("jim", "accounts"),
                new Person("randy", "canteen"),
                new Person("sandy", "change"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "change"),
                new Person("saajid", "IS"),
                new Person("alex", "trading"),
                new Person("john", "accounts"),
                new Person("mr", "finance")
        };

        System.out.println(boredom(teem));

        Person[] teem1 = new Person[] {
                new Person("tim", "IS"),
                new Person("jim", "finance"),
                new Person("randy", "pissing about"),
                new Person("sandy", "cleaning"),
                new Person("andy", "cleaning"),
                new Person("katie", "cleaning"),
                new Person("laura", "pissing about"),
                new Person("saajid", "regulation"),
                new Person("alex", "regulation"),
                new Person("john", "accounts"),
                new Person("mr", "canteen")
        };

        System.out.println(boredom(teem1));

        Person[] teem2 = new Person[] {
                new Person("tim", "accounts"),
                new Person("jim", "accounts"),
                new Person("randy", "pissing about"),
                new Person("sandy", "finance"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "IS"),
                new Person("saajid", "canteen"),
                new Person("alex", "pissing about"),
                new Person("john", "retail"),
                new Person("mr", "pissing about")
        };

        System.out.println(boredom(teem2));
    }
}
