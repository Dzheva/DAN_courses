package homework4;

import homework5.Species;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {
    @Test
    public void testToString() {
        Pet pet = new Pet(Species.CAT, "Whiskers", 2, 50, new String[]{"Sleep", "Play"});

        String expectedString = "CAT{can fly= false, has fur= true, number of legs = 4, nickname='Whiskers', " +
                "age=2, trickLevel=50, habits=[Sleep, Play]}";
        String unexpectedString = "DOG{can fly= true, has fur= false, number of legs = 4, nickname='Whiskers', " +
                "age=2, trickLevel=50, habits=[Sleep, Play]}";

        assertEquals(expectedString, pet.toString());
        assertNotEquals(unexpectedString, pet.toString());
    }
}