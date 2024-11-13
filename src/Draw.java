import java.awt.*;

public class Draw {

    private static void drawNode(Graphics2D g2d, Node node) {
        g2d.setColor(node.colors.get(node.valueForColor));
        g2d.fillRect(node.x - Node.radius / 2, node.y - Node.radius / 2, Node.radius, Node.radius);
    }

    private static void drawEdge(Graphics2D g2d, Edge edge) {
        g2d.setStroke(new BasicStroke(edge.strokeWidth));
        g2d.setColor(Color.black);
        g2d.drawLine(edge.start.x, edge.start.y, edge.end.x, edge.end.y);
    }

    public static void draw(Graphics2D g2d) {
        for (Edge edge : Graph.edges) {
            drawEdge(g2d, edge);
        }
        for (Node node : Graph.nodes) {
            drawNode(g2d, node);
        }
    }
}
