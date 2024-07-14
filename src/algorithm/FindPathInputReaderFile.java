package algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindPathInputReaderFile extends AbstractFindPathInputReader {
    private String filePath;

    public FindPathInputReaderFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Maze readMaze() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String[] lines = sb.toString().split("\n");
        char[][] grid = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
        return new Maze(grid);

    }
}
