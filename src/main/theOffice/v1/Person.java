package main.theOffice.v1;

public class Person {
    final String name;    // team memnber's name
    final int happiness;  // happiness rating out of 10

    public Person(String name, int happiness) {
        this.name = name;
        this.happiness = happiness;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public void d(){}
}

class men extends Person {

    public men(String name, int happiness) {
        super(name, happiness);
    }

    @Override
    public void d() {


        super.d();
    }
}
