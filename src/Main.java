import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Graph Builder");
        Window window = new Window();
        frame.add(window);
        frame.setSize(720, 740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        window.showPaths();
    }
}
