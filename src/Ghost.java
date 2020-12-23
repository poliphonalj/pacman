//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

public class Ghost extends JLabel {
    //static Point actualPoint;

    public Ghost(int x, int y, String color) {
        super(new ImageIcon(color + "_Ghost.png"));
        this.setSize(50, 50);
        this.setLocation(x, y);
        // actualPoint=(new Point(x,y));
    }

    public void move(int i) {
        Point p = new Point(this.getX(), this.getY());              //actual point of the position of the ghost

        switch (i) {
            case 0:       //east
                if ((Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY() + 50) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY() + 25) instanceof Wall)
                ) {
                    System.out.println("true its a wall");
                } else {
                    this.setLocation(new Point(p.x + 5, p.y));
                }
                break;

            case 1: //west
                if ((Window.frame.getContentPane().findComponentAt(this.getX() - 5, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() - 5, this.getY() + 50) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() - 5, this.getY() + 25) instanceof Wall)
                ) {
                    System.out.println("true its a wall");
                } else {
                    this.setLocation(new Point(p.x - 5, p.y));
                    //actualPoint=new Point(p.x , p.y);
                    break;
                }

            case 2:   //south

                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 55) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 50, this.getY() + 55) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 25, this.getY() + 55) instanceof Wall)
                ) {
                    System.out.println("true its a wall");
                } else {
                    this.setLocation(new Point(p.x, p.y + 5));
                    //actualPoint=new Point(p.x , p.y);
                    break;
                }


            case 3:  //north
                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 5) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 50, this.getY() - 5) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 25, this.getY() - 5) instanceof Wall)
                ) {
                    System.out.println("true its a wall");
                } else {
                    this.setLocation(new Point(p.x, p.y - 5));
                    //actualPoint=new Point(p.x , p.y);
                }
        }
    }
}

