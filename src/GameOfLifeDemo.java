package src;

public class GameOfLifeDemo {

   static int rowNumber = 25;
   static int columnNumber = 25;
   static int generation = 10;

    public static void main(String[] args) {
        System.out.println("Conway's Game of Life");
        GameOfLife game = new GameOfLife(rowNumber, columnNumber);
        addPatterns(game);
        System.out.print ("initial state: ");
        game.displayState();
        runSimulation(game, generation);
    }

    private static void addPatterns(GameOfLife game) {
        new Glider().applyTo(game, rowNumber/2, columnNumber/2);
    }

    private static void runSimulation(GameOfLife game, int generations) {
        for (int i = 0; i < generations; i++) {
            sleepBeforeNextStep();
            game.nextGeneration();
            game.displayState();
        }
    }

    private static void sleepBeforeNextStep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("the simulation was interrupted unexpectedly");
        }
    }
}
