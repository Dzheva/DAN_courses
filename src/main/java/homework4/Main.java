package homework4;

public class Main {
    public static void main(String[] args) {

        String[][] schedule = new String[2][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do nothing";
        schedule[1][0] = "Monday";
        schedule[1][1] = "do work";

        String[] habits = {"Sleep", "Eat", "Play"};

        Human mother = new Human("Maryna", "Pchilka", 1995, 100, schedule);
        Human father = new Human("Alex", "Pchilka", 1995, 100, schedule);
        Human child = new Human("Taras", "Pchilka", 1995, 100, schedule);
        Pet pet = new Pet("Dog", "Jack", 5, 42, habits);
        //Pet pet = new Pet();

        Family family2 = new Family(mother, father, pet);
        family2.deleteChild(mother);

        family2.addChild(child);
        System.out.println(family2);

        System.out.println("---------------------");
        child.greetPet();
        child.describePet();
        child.feedPet(true);
        pet.respond();
        pet.foul();
        System.out.println(child.getFamily());

        System.out.println("---------------------");
        family2.deleteChild(child);
        System.out.println(family2);
    }
}
