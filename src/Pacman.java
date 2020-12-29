//store the actual image wht the window should show(even ghost should do this)
//responsible for its own speed and location and directions

//a pacman is 50x50 pixells

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Pacman extends JLabel {

    static Point pacLocation = new Point(0, 0);
    ImageIcon pacToRight = new ImageIcon("pac_right.png");
    ImageIcon pacToLeft = new ImageIcon("pac_left.png");
    ImageIcon pacToUp = new ImageIcon("pac_up.png");
    ImageIcon pacToDown = new ImageIcon("pac_down.png");
    ImageIcon pacFull = new ImageIcon("pac_full.png");
    int pacccing = 0;           //responisble to delay the mouth motion of the pac

    public Pacman() {
        super(new ImageIcon("pac_right.png"));
        this.setBounds(100, 100, 30, 30);

    }

    public void move(int i) throws AWTException, IOException {
        switch (i) {
            case 37:       //balra nyil kodja
                if ((Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY()) instanceof Dot)) {//51


                    if ((((Dot) Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY())).getText().equals("."))) {
                        Window.score += 10;
                        System.out.println(Window.score);
                    }
                    ((Dot) Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY())).setText("");


                    //dotslistbol kivenni es emptybe betetnni
                }


                if (this.getX() <= -54) {                                   //leaving the board on the left side, coming back on the right
                    this.setLocation(781, this.getY());
                    pacLocation = new Point(781, this.getY());
                }

                if ((Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY() + 30) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY() + 15) instanceof Wall)
                ) {
                    // System.out.println("true its a wall");
                } else {
                    this.setLocation(this.getX() - 4, this.getY());     //moving and turning towards to west
                    if (pacccing <= 5) {
                        this.setIcon(pacToLeft);
                        pacccing++;
                    } else if (pacccing > 5) {
                        this.setIcon(pacFull);
                        pacccing++;
                        if (pacccing == 10)
                            pacccing = 0;
                    }
                    pacLocation = new Point(this.getX() - 4, this.getY());
                    break;

                }


            case 38:       //fel nyil kodja
                System.out.println(this.getX() + " " + this.getY());
                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 31) instanceof Dot)) {//51

                    if ((((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 31)).getText().equals("."))) {
                        Window.score += 10;
                        System.out.println(Window.score);
                    }
                    ((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 31)).setText("");


                    //dotslistbol kivenni es emptybe betetnni
                }


                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 4) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 30, this.getY() - 4) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 15, this.getY() - 4) instanceof Wall)
                ) {
                    // System.out.println("true its a wall");
                } else {
                    this.setLocation(this.getX(), this.getY() - 4);     //moving and turning towards to north
                    if (pacccing <= 5) {
                        this.setIcon(pacToUp);
                        pacccing++;
                    } else if (pacccing > 5) {
                        this.setIcon(pacFull);
                        pacccing++;
                        if (pacccing == 10)
                            pacccing = 0;
                    }
                    pacLocation = new Point(this.getX(), this.getY() - 4);
                    break;
                }

            case 39:       //jobb nyil kodja

                if ((Window.frame.getContentPane().findComponentAt(this.getX() + 31, this.getY()) instanceof Dot)) {//51
                    if ((((Dot) Window.frame.getContentPane().findComponentAt(this.getX() + 31, this.getY())).getText().equals("."))) {
                        Window.score += 10;
                        System.out.println(Window.score);
                    }
                    ((Dot) Window.frame.getContentPane().findComponentAt(this.getX() + 31, this.getY())).setText("");
                }


                if (this.getX() >= 781) {       //leaving the board on the right side and coming back from the left
                    this.setLocation(-54, this.getY());
                    pacLocation = new Point(-54, this.getY());
                }

                if ((Window.frame.getContentPane().findComponentAt(this.getX() + 33, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 33, this.getY() + 30) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 33, this.getY() + 15) instanceof Wall)
                ) {
                    // System.out.println("true its a wall");
                } else {
                    this.setLocation(this.getX() + 4, this.getY());     //moving east
                    if (pacccing <= 5) {
                        this.setIcon(pacToRight);
                        pacccing++;
                    } else if (pacccing > 5) {
                        this.setIcon(pacFull);
                        pacccing++;
                        if (pacccing == 10)
                            pacccing = 0;
                    }
                    pacLocation = new Point(this.getX() + 4, this.getY());
                    break;
                }


            case 40:                                    //moving and turning south

                if ((Window.frame.getContentPane().findComponentAt(this.getX(),this.getY()+31) instanceof Dot )) {//51
                    if(( ((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 31)).getText().equals("."))){
                        Window.score += 10;
                        System.out.println(Window.score);
                    }
                    ((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 31)).setText("");


                }
                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 33) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 30, this.getY() + 33) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 13, this.getY() + 33) instanceof Wall)
                ) {
                     System.out.println("true its a wall a faszomba");
                } else {
                    this.setLocation(this.getX(), this.getY() + 4);
                    if (pacccing <= 5) {
                        this.setIcon(pacToDown);
                        pacccing++;
                    } else if (pacccing > 5) {
                        this.setIcon(pacFull);
                        pacccing++;
                        if (pacccing == 10)
                            pacccing = 0;
                    }
                    pacLocation = new Point(this.getX(), this.getY() + 4);
                    break;
                }

        }
        // System.out.println(pacLocation);
    }




/*
                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 31) instanceof Dot)) {//51
                    if ((((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 31)).getText().equals("."))) {
                        Window.score += 10;
                        System.out.println(Window.score);
                    }
                    ((Dot) Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 31)).setText("");


                }
                if ((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 33) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 30, this.getY() + 33) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 15, this.getY() + 33) instanceof Wall)) {
                    // System.out.println("true its a wall");
                } else {
                    this.setLocation(this.getX(), this.getY() + 5);
                    if (pacccing <= 5) {
                        this.setIcon(pacToDown);
                        pacccing++;
                    } else if (pacccing > 5) {
                        this.setIcon(pacFull);
                        pacccing++;
                        if (pacccing == 10)
                            pacccing = 0;
                    }
                    pacLocation = new Point(this.getX(), this.getY() + 5);
                    break;
                }

        }
        // System.out.println(pacLocation);
    }


 */
        }
