package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ChanceTest {

    @Test
    public void twoChanceObjectsWithTheSameValueShouldBeEqual() {
        Chance half = new Chance(0.5);
        Chance anotherHalf = new Chance(0.5);
        assertEquals(half, anotherHalf);
        assertFalse(half.equals(null));
        assertFalse(half.equals(new Chance(0.75)));
    }

    @Test
    public void shouldBeAbleToRetrieveAnObjectFromAHash() {
        Map<Chance, String> hash = new HashMap<>();
        hash.put(new Chance(0.5), "Coin Toss");
        assertEquals("Coin Toss", hash.get(new Chance(0.5)));
    }

    @Test
    public void notOfADieThrowShouldReturnFiveSixths() {
        Chance dieThrow = new Chance(1.0/6.0);
        assertEquals(new Chance(5.0/6.0), dieThrow.not());
    }
}
