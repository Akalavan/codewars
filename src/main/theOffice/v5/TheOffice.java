package main.theOffice.v5;

/*
So you've found a meeting room - phew! You arrive there ready to present, and find that someone has taken one or more of the chairs!!
 You need to find some quick.... check all the other meeting rooms to see if all of the chairs are in use.

Your meeting room can take up to 8 chairs. need will tell you how many have been taken. You need to find that many.

Find the spare chairs from the array of meeting rooms.
Each meeting room tuple will have the number of occupants as a string. Each occupant is represented by 'X'.
The room tuple will also have an integer telling you how many chairs there are in the room.

You should return an array of integers that shows how many chairs you take from each room in order, up until you have the required amount.

example:

[['XXX', 3], ['XXXXX', 6], ['XXXXXX', 9], ['XXX',2]] when you need 4 chairs:

result -> [0, 1, 3] no chairs free in room 0, take 1 from room 1, take 3 from room 2. no need to consider room 3 as you have your 4 chairs already.

If you need no chairs, return "Game On". If there aren't enough spare chairs available, return "Not enough!".
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class TheOffice {

    public static Object meeting(Room[] x, int need) {
        if (need == 0) return "Game On";
        List<Integer> list = new ArrayList<>();
        Arrays.stream(x)
                .forEach(room -> {
                    int addAll = list.stream().mapToInt(integer -> integer).sum();
                    if (addAll == need) {
                        return ;
                    }
                    int accept = room.getChairs() - room.getOccupants().length();
                    int add = (int) IntStream.iterate(0, i -> i < accept && addAll + i < need, i -> i + 1).count();
                    list.add(add);
                });

        int[] mas = list.stream().mapToInt(item -> item).toArray();

        return list.stream().mapToInt(integer -> integer).sum() == need ? mas : "Not enough!";
    }

    public static void main(String[] args) {
//        Room[] rooms = new Room[] {
//                new Room("XXX", 3),
//                new Room("XXXXX", 6),
//                new Room("XXXXXX", 9)
//        };
//        System.out.println(meeting(rooms, 4));
//
//        Room[] rooms1 = new Room[] {
//                new Room("XXX", 1),
//                new Room("XXXXXX", 6),
//                new Room("X", 2),
//                new Room("XXXXXX", 8),
//                new Room("X", 3),
//                new Room("XXX", 1)
//        };
//        System.out.println(meeting(rooms1, 5));
//
//        Room[] rooms2 = new Room[] {
//                new Room("XX", 2),
//                new Room("XXXX", 6),
//                new Room("XXXXX", 4)
//        };
//        System.out.println(meeting(rooms2, 0));



        Room[] rooms3 = new Room[] {
                new Room("XXXXX", 8),
                new Room("X", 4),
                new Room("X", 1),
                new Room("X", 8),
                new Room("XXXXXX", 3),
                new Room("XXXXXXX", 8),
                new Room("XXXXXX", 6),
                new Room("XX", 5),
                new Room("XXXX", 4),
        };
        System.out.println(Arrays.toString((int[]) meeting(rooms3, 7)));
    }
}
