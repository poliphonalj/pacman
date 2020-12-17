//store the actual image wht the window should show(even ghost should do this)
//responsible for its own speed and location and directions

//a pacman is 50x50 pixells


import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Pacman extends JLabel {

    ImageIcon pacToRight=new ImageIcon("pac_right.png");
    ImageIcon pacToLeft=new ImageIcon("pac_left.png");
    ImageIcon pacToUp=new ImageIcon("pac_up.png");
    ImageIcon pacToDown=new ImageIcon("pac_down.png");
    ImageIcon pacFull=new ImageIcon("pac_full.png");

    int pacccing = 0;

    public Pacman() {
        super(new ImageIcon("pac_right.png"));
        Point p = new Point(this.getX(), this.getY());
        this.setSize(50, 50);
        this.setLocation(0, 0);
    }

    public void move(int i) {
        switch (i) {
            case 37:       //balra nyil kodja
                this.setLocation(this.getX() - 5, this.getY());     //moving and turning towards to west
                if (pacccing <= 5) {
                    this.setIcon(pacToLeft);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10)
                        pacccing = 0;
                }
                break;

            case 38:       //fel nyil kodja
                this.setLocation(this.getX(), this.getY() - 5);     //moving and turning towards to north
                if (pacccing <= 5) {
                    this.setIcon(pacToUp);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10)
                        pacccing = 0;
                }
                break;

            case 39:       //jobb nyil kodja
                this.setLocation(this.getX() + 5, this.getY());     //moving east
                if (pacccing <= 5) {
                    this.setIcon(pacToRight);
                    pacccing++;
                } else if (pacccing > 5) {
                    this.setIcon(pacFull);
                    pacccing++;
                    if (pacccing == 10)
                        pacccing = 0;
                }
                break;

            case 40:                                    //moving and turning south
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
                break;
        }
    }

}
