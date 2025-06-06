package src;

public class GameOfLife {
    private GameGrid grid;
    private int generation;

    public GameOfLife(int rowNum, int colNum) {
        this.grid = new GameGrid(rowNum, colNum);
        this.generation = 0;
    }

    public void nextGeneration() {
        grid = grid.createNextGeneration();
        generation++;
    }

    public void setCell(int x, int y, boolean alive) {
        grid.setCell(x, y, alive);
    }

    public Cell getCell(int x, int y) {
        return grid.getCell(x, y);
    }

    public int getLiveCellCount() {
        return grid.getLiveCellCount();
    }


    public void displayState() {
        System.out.println("generation: " + generation + "   |   live cells: " + getLiveCellCount());
        System.out.println(grid);
    }
}

