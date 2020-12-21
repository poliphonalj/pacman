//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

public class Ghost extends JLabel {
    //static Point actualPoint;

    public Ghost(int x, int y, String color) {
        super(new ImageIcon(color+"_Ghost.png"));
        this.setSize(50, 50);
        this.setLocation(x,y);
       // actualPoint=(new Point(x,y));
    }

    public void move(int i) {
        Point p = new Point(this.getX(), this.getY());              //actual point of the position of the ghost

        switch (i) {
            case 0:                                              //east
                this.setLocation(new Point(p.x - 5, p.y));
               // actualPoint=new Point(p.x , p.y);//==mindenki egy actualpointon oszozik most

                break;
            case 1:                                              //west
                this.setLocation(new Point(p.x + 5, p.y));
                //actualPoint=new Point(p.x , p.y);
                break;
            case 2:                                              //south
                this.setLocation(new Point(p.x, p.y + 5));
                //actualPoint=new Point(p.x , p.y);
                break;
            case 3:                                              //north
                this.setLocation(new Point(p.x, p.y - 5));
                //actualPoint=new Point(p.x , p.y);
                break;
        }
    }
}

