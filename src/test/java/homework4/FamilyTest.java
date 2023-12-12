package homework4;

import homework5.Species;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FamilyTest{
    @Test
    public void testToStringPositive() {
        Human mother = new Human("Jane", "Doe", 1980, 110, new String[][]{{"Monday", "Work"}});
        Human father = new Human("John", "Doe", 1982, 120, new String[][]{{"Wednesday", "Meeting"}});
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 70, new String[]{"Fetch", "Play"});
        Family family = new Family(mother, father, pet);

        assertTrue(family.toString().contains(pet.toString()));
        assertTrue(family.toString().contains("nickname='" + "Buddy" + '\''));
        assertFalse(family.toString().contains("nickname='" + "Test" + '\''));
    }

    @Test
    public void testAddChild() {
        Human mother = new Human("Jane", "Doe", 1980, 110, new String[][]{{"Monday", "Work"}});
        Human father = new Human("John", "Doe", 1982, 120, new String[][]{{"Wednesday", "Meeting"}});
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 70, new String[]{"Fetch", "Play"});
        Family family = new Family(mother, father, pet);

        Human child = new Human("Child", "Doe", 2005, 90, null);
        family.addChild(child);

        assertEquals(family, child.getFamily());
        assertTrue(Arrays.asList(family.getChildren()).contains(child));
    }

    @Test
    public void testDeleteChildByIndex() {
        Human mother = new Human("Jane", "Doe", 1980, 110, null);
        Human father = new Human("John", "Doe", 1982, 120, null);
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 70, new String[]{"Fetch", "Play"});
        Family family = new Family(mother, father, pet);

        Human child1 = new Human("Child1", "Doe", 2005, 90, null);
        family.addChild(child1);

        family.deleteChildByIndex(0); // indexChild1 = 0;
        assertNull(child1.getFamily());
        assertNotEquals(family, child1.getFamily());
    }

    @Test
    public void testDeleteChild() {
        Human mother = new Human("Jane", "Doe", 1980, 110, null);
        Human father = new Human("John", "Doe", 1982, 120, null);
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 70, new String[]{"Fetch", "Play"});
        Family family = new Family(mother, father, pet);

        Human child1 = new Human("Child1", "Doe", 2005, 90, null);
        family.addChild(child1);

        family.deleteChild(child1);
        assertNull(child1.getFamily());
        assertNotEquals(family, child1.getFamily());
    }

    @Test
    public void testCountFamily() {
        Human mother = new Human("Jane", "Doe", 1980, 110, null);
        Human father = new Human("John", "Doe", 1982, 120, null);
        Pet pet = new Pet(Species.DOG, "Buddy", 3, 70, new String[]{"Fetch", "Play"});
        Family family = new Family(mother, father, pet);

        Human child1 = new Human("Child1", "Doe", 2005, 90, null);
        Human child2 = new Human("Child2", "Doe", 2010, 80, null);

        family.addChild(child1);
        family.addChild(child2);

        assertEquals(4, family.countFamily());

        family.deleteChild(child1);
        assertNotEquals(4,family.countFamily());
        assertEquals(3, family.countFamily());
    }

}