//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import javax.swing.text.Position;
import java.awt.*;
import java.util.Random;

public class Ghost extends JLabel {

    public Ghost(){
        super(new ImageIcon("red_Ghost.png"));
        this.setSize(50,50);
    }

   //for now it is a random ghost motion
   public void move(){
        Point p= new Point(this.getX(),this.getY());              //actual point of the position
       Random rm=new Random();
       int i=rm.nextInt(4);

       switch (i){
           case 0:                                              //north
               this.setLocation(p.x-5,p.y);
               break;
           case 1:                                              //south
               this.setLocation(p.x+5,p.y);
               break;
           case 2:                                              //west
               this.setLocation(p.x,p.y+5);
               break;
           case 3:                                              //east
               this.setLocation(p.x,p.y-5);
               break;
       }
    }
}

