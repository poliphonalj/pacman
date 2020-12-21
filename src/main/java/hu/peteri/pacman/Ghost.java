package hu.peteri.pacman;
//creating a ghost object which follows a strategy to chase pacman

//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ghost extends JLabel {
    static Point actualPoint;

    ImageIcon icon = new ImageIcon(getClass().getResource("/red_Ghost.png"));

    public Ghost() {
        super();
        this.setSize(50, 50);
        this.setLocation(735, 515);
        this.setIcon(icon);
        actualPoint = (new Point(735, 515));
    }

    public void move(int i) {
        Point p = new Point(this.getX(), this.getY()); // actual point of the
                                                       // position of the ghost

        switch (i) {
        case 0: // east
            this.setLocation(new Point(p.x - 5, p.y));
            actualPoint = new Point(p.x, p.y);

            break;
        case 1: // west
            this.setLocation(new Point(p.x + 5, p.y));
            actualPoint = new Point(p.x, p.y);
            break;
        case 2: // south
            this.setLocation(new Point(p.x, p.y + 5));
            actualPoint = new Point(p.x, p.y);
            break;
        case 3: // north
            this.setLocation(new Point(p.x, p.y - 5));
            actualPoint = new Point(p.x, p.y);
            break;
        }
    }
}
