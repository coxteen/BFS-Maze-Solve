import java.awt.Color;
import java.util.HashMap;

public class Node {

    public int x, y;
    public int value;
    public int valueForColor;
    public static int radius = 100;

    public HashMap<Integer, Color> colors = new HashMap<>() {{
        put(0, Color.DARK_GRAY);
        put(1, Color.GRAY);
        put(2, Color.RED);
        put(3, Color.BLUE);
        put(4, Color.GREEN);
    }};

    public int getPositionX(int x) {
        return (x + 1) * 100;
    }

    public int getPositionY(int y) {
        return (y + 1) * 100;
    }

    public Node(int x, int y, int value, int valueForColor) {
        this.x = getPositionX(x);
        this.y = getPositionY(y);
        this.value = value;
        this.valueForColor = valueForColor;
    }
}
