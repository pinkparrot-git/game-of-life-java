package src;

public abstract class Pattern {
    protected final String name;
    protected final int[][] coordinates;

    protected Pattern(String name, int[][] coordinates) {
        this.name = name;
        this.coordinates = coordinates.clone();
    }

    public void applyTo(GameOfLife game, int startX, int startY) {
        for (int[] cord : coordinates) {
            game.setCell(startX + cord[0], startY + cord[1], true);
        }
    }


}

