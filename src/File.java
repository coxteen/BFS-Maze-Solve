import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File {

    public static void fileReader() throws IOException {
        List<int[]> matrixList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                int[] row = new int[values.length];

                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }

                matrixList.add(row);
            }
        }

        int[][] matrix = new int[matrixList.size()][];
        for (int i = 0; i < matrixList.size(); i++) {
            matrix[i] = matrixList.get(i);
        }

        int val = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                Graph.addNode(j, i, val, matrix[i][j]);
                val = val + 1;
                if (i > 0 && matrix[i][j] != 0 && matrix[i - 1][j] != 0) {
                    Graph.addEdge(Graph.findNode(j, i), Graph.findNode(j, i - 1));
                    Graph.addEdge(Graph.findNode(j, i - 1), Graph.findNode(j, i));
                }
                if (j > 0 && matrix[i][j] != 0 && matrix[i][j - 1] != 0) {
                    Graph.addEdge(Graph.findNode(j, i), Graph.findNode(j - 1, i));
                    Graph.addEdge(Graph.findNode(j - 1, i), Graph.findNode(j, i));
                }
            }
        }
    }
}
