//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

public class Ghost extends JLabel {
    static Point actualPoint;

    public Ghost() {
        super(new ImageIcon("red_Ghost.png"));
        this.setSize(50, 50);
        this.setLocation(735,515);
        actualPoint=(new Point(735,515));
    }

    public void move(int i) {
        Point p = new Point(this.getX(), this.getY());              //actual point of the position of the ghost

        switch (i) {
            case 0:                                              //east
                this.setLocation(new Point(p.x - 5, p.y));
                actualPoint=new Point(p.x , p.y);

                break;
            case 1:                                              //west
                this.setLocation(new Point(p.x + 5, p.y));
                actualPoint=new Point(p.x , p.y);
                break;
            case 2:                                              //south
                this.setLocation(new Point(p.x, p.y + 5));
                actualPoint=new Point(p.x , p.y);
                break;
            case 3:                                              //north
                this.setLocation(new Point(p.x, p.y - 5));
                actualPoint=new Point(p.x , p.y);
                break;
        }
    }
}

