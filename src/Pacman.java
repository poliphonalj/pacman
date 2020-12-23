//store the actual image wht the window should show(even ghost should do this)
//responsible for its own speed and location and directions

//a pacman is 50x50 pixells

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Pacman extends JLabel {

    static Point pacLocation=new Point(0,0);
    ImageIcon pacToRight = new ImageIcon("pac_right.png");
    ImageIcon pacToLeft = new ImageIcon("pac_left.png");
    ImageIcon pacToUp = new ImageIcon("pac_up.png");
    ImageIcon pacToDown = new ImageIcon("pac_down.png");
    ImageIcon pacFull = new ImageIcon("pac_full.png");
    int pacccing = 0;           //responisble to delay the mouth motion of the pac

    public Pacman() {
        super(new ImageIcon("pac_right.png"));
        this.setBounds(100,100,50,50);

    }
/*eredeti jol mukodo


    public void move(int i) {
        switch (i) {
            case 37:       //balra nyil kodja
                if (this.getX() > 0) {
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
                    pacLocation = new Point(this.getX() - 5, this.getY());
                    break;
                }

            case 38:       //fel nyil kodja
                if (this.getY() > 0) {
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
                    pacLocation = new Point(this.getX(), this.getY() - 5);
                    break;
                }


            case 39:       //jobb nyil kodja
                if (this.getX() < 740) {
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
                    pacLocation = new Point(this.getX() + 5, this.getY());
                    break;
                }


            case 40:                                    //moving and turning south
                if (this.getY() < 515) {
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
    }
*/



/////uj proba

    public void move(int i) throws AWTException, IOException {
       // BufferedImage image;
       // File input = new File("simapalya.png");
      //  image = ImageIO.read(input);
       // System.out.println(image.getHeight()+"bbbb");



        //Robot rob=new Robot();
        Color c=new Color(58,85,128);//a fal szine
       // Color c=new Color(60,63,65);//a fal szine4.5.42
        System.out.println(this.getX()+" "+this.getY());

        System.out.println(Window.frame.getContentPane().findComponentAt(100, 100));
        switch (i) {
            case 37:       //balra nyil kodja
              //System.out.println(this.getX()+"  "+this.getY()+"kiiiiiiiiiiiiiiiiiiii"+image.getRGB(this.getX()-10,this.getY()));

                if((Window.frame.getContentPane().findComponentAt(this.getX() -5, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() -5, this.getY()+50) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() -5, this.getY()+25) instanceof Wall)
                ){


                    System.out.println("true its a wall");
                }
                else{
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
                    pacLocation = new Point(this.getX() - 5, this.getY());
                    break;
                }

            case 38:       //fel nyil kodja
                if((Window.frame.getContentPane().findComponentAt(this.getX() , this.getY()-5) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() +50, this.getY()-5) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() +25, this.getY()-5) instanceof Wall)
                ){



                    System.out.println("true its a wall");
                }
                else{

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
                    pacLocation = new Point(this.getX(), this.getY() - 5);
                    break;
                }


            case 39:       //jobb nyil kodja
                if((Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY()+50) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 55, this.getY()+25) instanceof Wall)
                ){

                    System.out.println("true its a wall");
                }
                else{


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
                    pacLocation = new Point(this.getX() + 5, this.getY());
                    break;
                }


            case 40:                                    //moving and turning south
                if((Window.frame.getContentPane().findComponentAt(this.getX() , this.getY()+55) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 50, this.getY()+55) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(this.getX() + 25, this.getY()+55) instanceof Wall)
                ){



                    System.out.println("true its a wall");
                }
                else{

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
    }











}
