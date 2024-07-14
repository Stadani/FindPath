package tests;

import algorithm.FindShortestPath;
import algorithm.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFunction {
    private Maze createTestMaze() {
        String[] gridLines = {
                "....................................",
                "..S...#......................#......",
                "......#......................#......",
                ".............................#......",
                "....................................",
                "....................................",
                "..............#.....................",
                "............#.......................",
                "..........#.........................",
                "....................................",
                ".....................#..........#...",
                ".....................#....X.....#...",
                ".....................#..........#...",
                "...................................."
        };
        char[][] grid = new char[gridLines.length][];
        for (int i = 0; i < gridLines.length; i++) {
            grid[i] = gridLines[i].toCharArray();
        }
        return new Maze(grid);
    }

    @Test
    public void testFindPath() {
        Maze maze = createTestMaze();

        FindShortestPath solver = new FindShortestPath();
        String path = solver.findPath(maze);

        System.out.println("Path: " + path);
        assertFalse(path.equals("No path found"));
        String expectedPath = "ddddddddrrrrrrrrrrrrrrrrrrrrddrrrr";
        assertEquals(expectedPath, path);
    }

    @Test
    public void testPerformance() {
        Maze maze = createTestMaze();
        FindShortestPath solver = new FindShortestPath();

        long startTime = System.nanoTime();
        String path = solver.findPath(maze);
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " nanoseconds");
    }
}
