import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPath {
    private static final int[] dr = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] dc = {0, 0, -1, 1};
    private static final char[] dirSymbols = {'u', 'd', 'l', 'r'};

    public String findPath(Maze maze) {
        int startRow = maze.getStartRow();
        int startCol = maze.getStartCol();
        int targetRow = maze.getTargetRow();
        int targetCol = maze.getTargetCol();
        char[][] grid = maze.getGrid();

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, -1}); // {row, col, direction index}
        visited[startRow][startCol] = true;

        int[][] parent = new int[rows][cols]; // to store parent for each cell
        int[][] parentDirection = new int[rows][cols]; // to store direction taken to reach each cell

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dirIndex = current[2];

            if (r == targetRow && c == targetCol) {
                // Construct path from parent array
                StringBuilder pathBuilder = new StringBuilder();
                while (!(r == startRow && c == startCol)) {
                    int prevDirIndex = parentDirection[r][c];
                    pathBuilder.append(dirSymbols[prevDirIndex]);
                    r -= dr[prevDirIndex];
                    c -= dc[prevDirIndex];
                }
                return pathBuilder.reverse().toString();
            }

            for (int i = 0; i < 4; i++) { // iterates over 4 directions
                int nr = r + dr[i];
                int nc = c + dc[i];

                //if cell is within bounds, not visited and not #, it's added to queue
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && !visited[nr][nc] && grid[nr][nc] != '#') {
                    queue.offer(new int[]{nr, nc, i});
                    visited[nr][nc] = true;
                    parent[nr][nc] = dirIndex;
                    parentDirection[nr][nc] = i;
                }
            }
        }

        return "No path found";
    }
}
