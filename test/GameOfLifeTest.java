package test;

import src.GameRules;

public class GameOfLifeTest {

    public static void main(String[] args) {
        testConwaysRules();
    }

    public static void testConwaysRules() {
        assertTrue(GameRules.shouldCellLive(true, 2),"Live cell with 2 neighbors should survive");
        assertTrue(GameRules.shouldCellLive(true, 3), "Live cell with 3 neighbors should survive");

        assertFalse(GameRules.shouldCellLive(true, 1), "Live cell with 1 neighbor should die");
        assertFalse(GameRules.shouldCellLive(true, 4), "Live cell with 4 neighbors should die");

        assertTrue(GameRules.shouldCellLive(false, 3), "Dead cell with 3 neighbors should become alive");

        assertFalse(GameRules.shouldCellLive(false, 2), "Dead cell with 2 neighbors should stay dead");
        assertFalse(GameRules.shouldCellLive(false, 4), "Dead cell with 4 neighbors should stay dead");
    }


    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("test failed: " + message);
        }
    }

    private static void assertFalse(boolean condition, String message) {
        if (condition) {
            throw new AssertionError("test failed: " + message);
        }
    }
}
