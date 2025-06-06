package src;

public class GameGrid {
    private final int rowNum;
    private final int colNum;
    private final Cell[][] cells;

    public GameGrid(int rowNum, int colNum) {
        validateDimensions(rowNum, colNum);
        this.rowNum = rowNum;
        this.colNum = colNum;
        this.cells = initializeCells();
    }

    private GameGrid(Cell[][] cells) {
        this.rowNum = cells.length;
        this.colNum = cells[0].length;
        this.cells = cells;
    }

    private void validateDimensions(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("grid dimensions should be positive numbers");
        }
    }

    private Cell[][] initializeCells() {
        Cell[][] newCells = new Cell[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                newCells[row][col] = new Cell();
            }
        }
        return newCells;
    }

    public Cell getCell(int row, int col) {
        if (isValid(row, col)) {
            return cells[row][col];
        }
        return new Cell(false);
    }

    public void setCell(int row, int col, boolean alive) {
        if (isValid(row, col)) {
            cells[row][col].setAlive(alive);
        }
    }

    public boolean isValid(int row, int col) {
        return row >= 0 && row < rowNum && col >= 0 && col < colNum;
    }

    public int countLiveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (getCell(row + i, col + j).isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

    public GameGrid createNextGeneration() {
        Cell[][] nextGenerationCells = new Cell[rowNum][colNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                int neighbors = countLiveNeighbors(row, col);
                boolean currentlyAlive = cells[row][col].isAlive();
                boolean willBeAlive = GameRules.shouldCellLive(currentlyAlive, neighbors);
                nextGenerationCells[row][col] = new Cell(willBeAlive);
            }
        }
        return new GameGrid(nextGenerationCells);
    }


    public int getLiveCellCount() {
        int count = 0;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < colNum; col++) {
                if (cells[row][col].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }

}

