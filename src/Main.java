import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AbstractFindPathInputReader inputReader;
        if (args.length > 0) {
            inputReader = new FindPathInputReaderFile(args[0]);
        } else {
            inputReader = new FindPathInputReaderStdIn();
        }

        try {
            Maze maze = inputReader.readMaze();
            FindShortestPath solver = new FindShortestPath();
            String path = solver.findPath(maze);
            System.out.println("Path: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}