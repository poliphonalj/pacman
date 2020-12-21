package hu.peteri.pacman;
//store the actual image wht the window should show(even ghost should do this)

//responsible for its own speed and location and directions

//a pacman is 50x50 pixells

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pacman extends JLabel {

    static Point pacLocation;
    ImageIcon pacToRight = new ImageIcon(getClass().getResource("/pac_right.png"));
    ImageIcon pacToLeft = new ImageIcon(getClass().getResource("/pac_left.png"));
    ImageIcon pacToUp = new ImageIcon(getClass().getResource("/pac_up.png"));
    ImageIcon pacToDown = new ImageIcon(getClass().getResource("/pac_down.png"));
    ImageIcon pacFull = new ImageIcon(getClass().getResource("/pac_full.png"));
    ImageIcon pac = new ImageIcon(getClass().getResource("/pac_right.png"));
    int pacccing = 0; // responisble to delay the mouth motion of the pac

    public Pacman() {
        super();
        this.setSize(50, 50);
        this.setLocation(0, 0);
        this.setIcon(pac);
    }

    public void move(int i) {
        switch (i) {
        case 37: // balra nyil kodja
            if (this.getX() > 0) {
                this.setLocation(this.getX() - 5, this.getY()); // moving and
                                                                // turning
                                                                // towards to
                                                                // west
                if (pacccing <= 5) {
                    this.setIcon(pacToLeft);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10) {
                        pacccing = 0;
                    }
                }
                pacLocation = new Point(this.getX() - 5, this.getY());
                break;
            }

        case 38: // fel nyil kodja
            if (this.getY() > 0) {
                this.setLocation(this.getX(), this.getY() - 5); // moving and
                                                                // turning
                                                                // towards to
                                                                // north
                if (pacccing <= 5) {
                    this.setIcon(pacToUp);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10) {
                        pacccing = 0;
                    }
                }
                pacLocation = new Point(this.getX(), this.getY() - 5);
                break;
            }

        case 39: // jobb nyil kodja
            if (this.getX() < 740) {
                this.setLocation(this.getX() + 5, this.getY()); // moving east
                if (pacccing <= 5) {
                    this.setIcon(pacToRight);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10) {
                        pacccing = 0;
                    }
                }
                pacLocation = new Point(this.getX() + 5, this.getY());
                break;
            }

        case 40: // moving and turning south
            if (this.getY() < 515) {
                this.setLocation(this.getX(), this.getY() + 5);
                if (pacccing <= 5) {
                    this.setIcon(pacToDown);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10) {
                        pacccing = 0;
                    }
                }
                pacLocation = new Point(this.getX(), this.getY() + 5);
                break;
            }
        }
    }

}
