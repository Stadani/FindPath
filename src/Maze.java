public class Maze {
    private final char[][] grid;
    private int startRow;
    private int startCol;
    private int targetRow;
    private int targetCol;

    public Maze(char[][] grid) {
        this.grid = grid;
        findStartAndTargetPositions();
    }

    public char[][] getGrid() {
        return grid;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public int getTargetRow() {
        return targetRow;
    }

    public int getTargetCol() {
        return targetCol;
    }

    private void findStartAndTargetPositions() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 'X') {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }
    }
}
