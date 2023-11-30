package homework4;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class Human {
    static {
        System.out.println("Class Human is loading...");
    }

    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        if (iq >= 0 && iq <= 100) {
            this.iq = iq;
        } else {
            System.out.println("Рівень IQ повинен бути в межах від 0 до 100.");
        }
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    private boolean hasPet() {
        if (getFamily().getPet().getNickname() != null){
            return true;
        } else {
            System.out.println("I don't have a pet");
            return false;
        }
    }

    public void greetPet() {
        if (hasPet()) {
            System.out.println("Привіт, " + getFamily().getPet().getNickname() + ".");
        }
    }

    public void describePet() {
        if (hasPet()) {
            if (getFamily().getPet().getTrickLevel() > 50) {
                System.out.println("У мене є " + getFamily().getPet().getSpecies() +
                        ", їй " + getFamily().getPet().getAge() + " років, він дуже хитрий.");
            } else {
                System.out.println("У мене є " + getFamily().getPet().getSpecies() +
                        ", їй " + getFamily().getPet().getAge() + " років, він майже не хитрий.");
            }
        }
    }

    public boolean feedPet(boolean isTimeToFeed) {
        if(!hasPet()) return false;

        if (isTimeToFeed || (getFamily().getPet().getTrickLevel() > new Random().nextInt(101))) {
            System.out.println("Хм... годувати я " + getFamily().getPet().getNickname() + ".");
            return true;
        } else {
            System.out.println("Думаю, " + getFamily().getPet().getNickname() + " не голодний.");
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;

        if (year != human.year) return false;
        if (iq != human.iq) return false;
        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + year;
        result = 31 * result + iq;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder scheduleString = new StringBuilder();
        boolean isFirst = true;

        for (String[] entry : schedule) {
            if (!isFirst) {
                scheduleString.append(", ");
            } else {
                isFirst = false;
            }
            scheduleString.append("[").append(entry[0]).append(", ").append(entry[1]).append("]");
        }

        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", year=" + year +
                ", iq=" + iq +
                ", schedule=[" + scheduleString.toString() + "]" +
                '}';
    }
}
