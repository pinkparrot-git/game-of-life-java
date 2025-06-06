package test;

import src.Blinker;
import src.GameOfLife;
import src.GameRules;

public class GameOfLifeTest {

    public static void main(String[] args) {
        System.out.println("game of life unit tests starts");
        testConwaysRules();
        testBlinkerPattern();
        System.out.println("all tests passed successfully");
    }

    public static void testConwaysRules() {
        System.out.println("Conway's rules tests starts");

        assertTrue(GameRules.shouldCellLive(true, 2),"live cell with 2 neighbors should survive");
        assertTrue(GameRules.shouldCellLive(true, 3), "live cell with 3 neighbors should survive");

        assertFalse(GameRules.shouldCellLive(true, 1), "live cell with 1 neighbor should die");
        assertFalse(GameRules.shouldCellLive(true, 4), "live cell with 4 neighbors should die");

        assertTrue(GameRules.shouldCellLive(false, 3), "dead cell with 3 neighbors should become alive");

        assertFalse(GameRules.shouldCellLive(false, 2), "dead cell with 2 neighbors should stay dead");
        assertFalse(GameRules.shouldCellLive(false, 4), "dead cell with 4 neighbors should stay dead");

        System.out.println("Conway's rules ends successfully");
    }

    public static void testBlinkerPattern() {
        System.out.println("blinker pattern tests starts");

        GameOfLife game = new GameOfLife(5, 5);
        new Blinker().applyTo(game, 1, 1);

        assertTrue(game.getLiveCellCount() == 3, "verify initial state of horizontal blinker with 3 live cells");
        assertTrue(game.getCell(1, 2).isAlive(), "cell (1,2) should be alive");
        assertTrue(game.getCell(2, 2).isAlive(), "cell (2,2) should be alive");
        assertTrue(game.getCell(3, 2).isAlive(), "cell (3,2) should be alive");

        game.nextGeneration();
        assertTrue(game.getLiveCellCount() == 3, "blinker should become vertical with 3 live cells");
        assertTrue(game.getCell(2, 1).isAlive(), "cell (2,1) should be alive after evolution");
        assertTrue(game.getCell(2, 2).isAlive(), "cell (2,2) should be alive after evolution");
        assertTrue(game.getCell(2, 3).isAlive(), "cell (2,3) should be alive after evolution");

        game.nextGeneration();
        assertTrue(game.getLiveCellCount() == 3, "blinker should return to horizontal and still have 3 live cells");
        assertTrue(game.getCell(1, 2).isAlive(), "cell (1,2) should be alive after second evolution");
        assertTrue(game.getCell(2, 2).isAlive(), "cell (2,2) should be alive after second evolution");
        assertTrue(game.getCell(3, 2).isAlive(), "cell (3,2) should be alive after second evolution");

        System.out.println("blinker pattern tests ends successfully");
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
