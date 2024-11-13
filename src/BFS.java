import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static ArrayList<Integer> parents = new ArrayList<>();
    public static ArrayList<Node> U = new ArrayList<>();
    public static Queue<Node> V = new LinkedList<>();
    public static ArrayList<Node> W = new ArrayList<>();

    public static void bfSearch() {

        for (Node node : Graph.nodes) {
            if (node.valueForColor != 3) {
                U.add(node);
            } else {
                V.add(node);
            }
        }

        for (int i = 0; i < Graph.nodes.size(); i++) {
            parents.add(0);
        }

        while (!V.isEmpty()) {
            Node x = V.poll();
            for (Node y : Graph.adjacentList.get(x)) {
                if (U.contains(y)) {
                    U.remove(y);
                    V.add(y);
                    parents.set(y.value, x.value);
                }
            }
            V.remove(x);
            W.add(x);
        }
    }
}
