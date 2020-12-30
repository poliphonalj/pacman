import javax.swing.*;
import java.awt.*;


public class Dot extends JLabel {//a boardhoz wallakat tartalmazo arraylist miatt szarmazik a wallbol
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.setText(".");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
        this.setOpaque(true);
        this.setBackground(new Color(4, 5, 42));
        this.setForeground((Color.WHITE));

        this.setBounds(x, y, 32, 32);
    }
}




