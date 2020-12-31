//creating a ghost object which follows a strategy to chase pacman
//is able to locate itself and judge the (random)?? best way to follow the pacman (distance calc)


import javax.swing.*;
import java.util.*;


public class Ghost extends JLabel implements Runnable {

    public Ghost(int x, int y, String color) {
        super(new ImageIcon(color + "_Ghost.png"));
        this.setSize(29, 29);
        this.setLocation(x, y);

        Thread thread = new Thread(this);   //every ghosts has its own thread
        thread.start();
    }

    @Override
    public void run() {
        try {
            move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void move() throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            Random r = new Random();
            int seged = r.nextInt(4);

            switch (seged) {
                case 0:
                    felmegy();
                    break;
                case 1:
                    lemegy();
                    break;
                case 2:
                    balramegy();
                    break;
                case 3:
                    jobbramegy();
                    break;
            }
        }
    }


    public synchronized void felmegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() - 1) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() - 1) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() - 1) instanceof Wall)
        )) {
            this.setLocation(this.getX(), this.getY() - 1);
            this.wait(30);
        }
    }

    public synchronized void balramegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY()) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 30) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() - 1, Window.g1.getY() + 15) instanceof Wall)
        )) {
            this.setLocation(this.getX() - 1, this.getY());
            this.wait(30);
        }
    }

    public synchronized void lemegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX(), Window.g1.getY() + 31) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 15, Window.g1.getY() + 31) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 30, Window.g1.getY() + 31) instanceof Wall)
        )) {
            this.setLocation(this.getX(), this.getY() + 1);
            this.wait(30);
        }
    }

    public synchronized void jobbramegy() throws InterruptedException {
        while (!((Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY()) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 15) instanceof Wall) ||
                (Window.frame.getContentPane().findComponentAt(Window.g1.getX() + 31, Window.g1.getY() + 30) instanceof Wall)
        )) {
            this.setLocation(this.getX() + 1, this.getY());
            this.wait(30);
        }
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


















