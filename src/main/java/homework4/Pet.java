package homework4;

import homework5.Species;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Pet {
    static {
        System.out.println("Class Pet is loading...");
    }

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Pet() {
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        {
            System.out.println("A new object of type " + species + " is creating...");
        }
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        {
            System.out.println("A new object of type " + species + " is creating...");
        }
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        if (trickLevel >= 0 && trickLevel <= 100) {
            this.trickLevel = trickLevel;
        } else {
            System.out.println("Рівень хитрості повинен бути в межах від 0 до 100.");
        }
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public void eat() {
        System.out.println("Я ї'м!");
    }

    public void respond() {
        if (getNickname() != null) {
            System.out.println("Привіт, хазяїн. Я - " + getNickname() + ". Я скучив!");
        } else {
            System.out.println("I don't have a name.");
        }
    }

    public void foul() {
        System.out.println("Потрібно добре замести сліди...");
    }

    @Override
    public String toString() {
        return species + "{" +
                "can fly= " + species.canFly() +
                ", has fur= " + species.hasFur() +
                ", number of legs = " + species.getNumberOfLegs() +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + Arrays.toString(habits) +
                '}';
    }

}
