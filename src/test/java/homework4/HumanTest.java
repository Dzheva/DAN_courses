package homework4;

import homework5.Species;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HumanTest {
    @Test
    public void testToString() {
        String[][] schedule = {
                {"Monday", "Work"},
                {"Wednesday", "Meeting"},
                {"Friday", "Gym"}
        };
        Human human = new Human("John", "Doe", 1990, 120, schedule);

        String expectedString = "Human{name='John', surname='Doe', year=1990, iq=120, schedule=[[Monday, Work], [Wednesday, Meeting], [Friday, Gym]]}";
        String unexpectedString = "Human{name='John', surname='Doe', year=1990, iq=120, schedule=[[Tuesday, Study], [Thursday, Coffee]]}";

        assertEquals(expectedString, human.toString());
        assertNotEquals(unexpectedString, human.toString());
    }

    @Test
    public void testEqualsAndHashCodeForEqualObjects() {
        Human human1 = new Human("John", "Doe", 1990, 120, new String[][]{{"Monday", "Work"}});
        Human human2 = new Human("John", "Doe", 1990, 120, new String[][]{{"Monday", "Work"}});

        assertEquals(human1, human2);
        assertEquals(human1.hashCode(), human2.hashCode());
    }

    @Test
    public void testEqualsAndHashCodeForDifferentObjects() {
        Human human1 = new Human("John", "Doe", 1990, 120, new String[][]{{"Monday", "Work"}});
        Human human2 = new Human("Jane", "Doe", 1985, 110, new String[][]{{"Tuesday", "Study"}});

        assertNotEquals(human1, human2);
        assertNotEquals(human1.hashCode(), human2.hashCode());
    }
}