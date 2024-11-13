import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    public static ArrayList<Edge> edges = new ArrayList<>();
    public static ArrayList<Node> nodes = new ArrayList<>();

    public static HashMap<Node, ArrayList<Node>> adjacentList = new HashMap<>();

    private Graph() {}

    public static void addNode(int x, int y, int value, int valueForColor) {
        Node node = new Node(x, y, value, valueForColor);
        nodes.add(node);
    }

    public static void addEdge(Node start, Node end) {
        Edge edge = new Edge(start, end);
        edges.add(edge);

        if (!adjacentList.containsKey(start)) {
            adjacentList.put(start, new ArrayList<>());
        }
        adjacentList.get(start).add(end);
    }

    public static Node findNode(int x, int y) {
        for (Node node : nodes) {
            if (node.x == node.getPositionX(x) && node.y == node.getPositionY(y)) {
                return node;
            }
        }
        return new Node(-1, -1, -1, -1);
    }

    public static Node getNodeByValue(int value) {
        for (Node node : nodes) {
            if (node.value == value) {
                return node;
            }
        }
        return new Node(-1, -1, -1, -1);
    }
}
