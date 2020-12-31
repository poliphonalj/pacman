//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Ghost extends JLabel implements Runnable {

    public Ghost(int x, int y, String color) {
        super(new ImageIcon(color + "_Ghost.png"));
        this.setSize(30,30 );
        this.setLocation(x, y);

        Thread thread = new Thread(this);   //every ghosts has its own thread
        thread.start();
    }

    @Override
    public void run() {
        try {
            move();
            System.out.println("ww");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void move() throws InterruptedException {
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {

            int seged = r.nextInt(4);

            switch (seged) {
                case 0:  System.out.println(seged);
                    felmegy();
                    break;
                case 1:
                     balramegy();
                    break;
                case 2:
                    lemegy();
                    break;
                case 3:
                    jobbramegy();
                    break;
            }
        }
    }


    public synchronized void felmegy() throws InterruptedException {//amig nem megy a falnak vagy valasztomezobe nem lep--nincs fal es nincs valasztomezo
        while (!((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() - 4) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 15, this.getY() - 4) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 30, this.getY() - 4) instanceof Wall)
        ) && !valasztomezo(new Point(this.getX(),this.getY())))
        {
            this.setLocation(this.getX(), this.getY()-4);

            this.wait(10);
        }




    }

    public synchronized void balramegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY()) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY() + 30) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() - 4, this.getY() + 15) instanceof Wall)
        ) && !valasztomezo(new Point(this.getX(),this.getY())) )
        {
            this.setLocation(this.getX()-4, this.getY());
            this.wait(10);
        }
        //System.out.println("valasztopont"+ this.getX()+" - "+this.getY());
        //this.setLocation(this.getX()+4 , this.getY());

    }

    public synchronized void lemegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(this.getX(), this.getY() + 34) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 15, this.getY() + 34) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 30, this.getY() + 34) instanceof Wall)
        ) && !valasztomezo(new Point(this.getX(),this.getY())) )
        {

            this.setLocation(this.getX(), this.getY()+4);
            this.wait(10);
        }
       // System.out.println("valasztopont"+ this.getX()+" - "+this.getY());
        //this.setLocation(this.getX(), this.getY() -4);

    }

    public synchronized void jobbramegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(this.getX() + 34, this.getY()) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 34, this.getY() + 15) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(this.getX() + 34, this.getY() + 30) instanceof Wall)
        ) && !valasztomezo(new Point(this.getX(),this.getY())))
        {

            this.setLocation(this.getX()+4, this.getY());
            this.wait(10);
        }
       // this.setLocation(this.getX() -4, this.getY());
        //System.out.println("valasztopont"+ this.getX()+" - "+this.getY());

    }


    public boolean valasztomezo(Point p) {
        ArrayList<Point> pontok = new ArrayList<>();        //olyan pontok halmaza ahol fal nelkuli keresztezodes van
        pontok.add(new Point(33,161));
        pontok.add(new Point(33,289));
        pontok.add(new Point(97,353));
        pontok.add(new Point(157,353));
       // pontok.add(new Point(289,481));
        pontok.add(new Point(289,385));
        pontok.add(new Point(225,193));
        pontok.add(new Point(481,225));
        pontok.add(new Point(481,353));
        pontok.add(new Point(481,385));
        pontok.add(new Point(545,321));
        pontok.add(new Point(609,321));
        pontok.add(new Point(545,193));
        pontok.add(new Point(609,193));
        pontok.add(new Point(673,289));
        pontok.add(new Point(321,129));
        pontok.add(new Point(257,97));
        pontok.add(new Point(97,161));


        for (Point actualpoint : pontok) {
            if(actualpoint.equals(p)){
                System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
                return true;

            }
        }
        return false;


    }


}







/*
 ArrayList<Integer> generateDirArray = new ArrayList<>();    //contains the possible directions and choose one of them to step

                //ha balra nincsfal
                if (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 30) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 15) instanceof Wall)
                )) {
                    generateDirArray.add(0);
                }

                //ha jobbra nincs fal
                if (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY()) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 30) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 15) instanceof Wall)
                )) {
                    generateDirArray.add(1);
                }

                // ha lefele nincs fal
                if (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() + 31) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() + 31) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() + 31) instanceof Wall)
                )) {
                    generateDirArray.add(2);
                }

                //ha felfele nincs fal
                if (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() - 1) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() - 1) instanceof Wall) ||
                        (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() - 1) instanceof Wall)
                )) {
                    generateDirArray.add(3);
                }

                Collections.shuffle(generateDirArray);
                int i = generateDirArray.get(0);
                switch (i) {
                    case 0: //balra lep
                        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY()) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 30) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 15) instanceof Wall)
                        )) {
                            Window.g1.setLocation(Window.g1.getX() - 1, Window.g1.getY());
                        }
                        break;
                    case 1://jobbra lep
                        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY()) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 30) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 15) instanceof Wall)
                        )) {
                            Window.g1.setLocation(Window.g1.getX() + 1, Window.g1.getY());
                        }
                        break;
                    case 2://lefele
                        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() + 31) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() + 31) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() + 31) instanceof Wall)
                        )) {
                            Window.g1.setLocation(Window.g1.getX(), Window.g1.getY() + 1);
                        }
                        break;
                    case 3://felfele
                        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() - 1) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() - 1) instanceof Wall) ||
                                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() - 1) instanceof Wall)
                        )) {
                            Window.g1.setLocation(Window.g1.getX(), Window.g1.getY());
                        }
                }
            }
 */


















