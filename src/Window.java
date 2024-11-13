import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class Window extends JPanel implements MouseListener {

    public Window() {
        addMouseListener(this);
        try {
            File.fileReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Draw.draw(g2d);
    }

    ArrayList<Node> exists = new ArrayList<>();

    public void showPaths () throws InterruptedException {

        BFS.bfSearch();

        for (Node node : Graph.nodes) {
            if (node.valueForColor == 2) {
                exists.add(node);
            }
        }

        for (Node node : exists) {

            Node exitNode = node;
            ArrayList<Node> path = new ArrayList<>();
            ArrayList<Integer> initialColors = new ArrayList<>();

            while (exitNode.valueForColor != 3) {
                path.add(exitNode);
                initialColors.add(exitNode.valueForColor);
                exitNode = Graph.getNodeByValue(BFS.parents.get(exitNode.value));
            }

            for (int i = path.size() - 1; i >= 0; i--) {
                path.get(i).valueForColor = 4;
                Thread.sleep(500);
                repaint();
            }

            for (int i = 0; i < initialColors.size(); i++) {
                path.get(i).valueForColor = initialColors.get(i);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
