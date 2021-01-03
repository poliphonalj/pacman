//holds each game field in a 2 dim array......
//directing the actors. Each field knows its own possible directions
//and knows its type(wall, empty field, food, etc)
//control the ghosts and pacman (not letting them to walk into a wall)
//controls and runs the whole game
//knows the lives of pacman
//knows the scores and level of the game



/*      TODOs

1. add another ghost
2. start to work on the labirinth and fields
3. stop ghosts to get out of the sreen
4. add some random factor to ghosts movement

*/


import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;

public class GameEngine {
    int lifeFlag = 3;
    static boolean pacEatsGhostMode = false;
    Ghost g;
    Timer timer;
    static int counter=0;
    static int seged=0;
    //tries to move the ghost towards to the pac.
    //this method calculate the distance of the ghost and pac and chose the best direction for the ghost
    //to minimalize this distance
    public void moveGhost(Ghost g) {

        this.g = g;

        int pacX = (int) Pacman.pacLocation.getX();
        int pacY = (int) Pacman.pacLocation.getY();

        int ghostX = g.getX();
        int ghostY = g.getY();

        Point pointPac = (new Point(pacX, pacY));
        Point pointGhost = new Point(ghostX, ghostY);

        //to ghost tries to chase down the pac
        //if the original distance gets less in case of moving then the motion to east>>>the ghost moves to east
        if (pointPac.distance(pointGhost) > pointPac.distance(pointGhost.getX() + 1, pointGhost.getY())) {   //west
            // g1.move(1);
        } else if (pointPac.distance(pointGhost) >= pointPac.distance(pointGhost.getX() - 1, pointGhost.getY())) {   //east
            //g1.move(0);
        } else if (pointPac.distance(pointGhost) > pointPac.distance(pointGhost.getX(), pointGhost.getY() - 1)) {   //north
            //g1.move(3);
        } else if (pointPac.distance(pointGhost) >= pointPac.distance(pointGhost.getX(), pointGhost.getY() + 1)) {   //south
            //g1.move(2);
        }
    }


    //this method runs if the pac and ghost are crashing eachother
    public int isCrash(Ghost g1, Ghost g2) {
        //in case of a collision, we have to remove one life, and set the ghost and pac back to starter position, until the last life, after it the gameover comes
        if ((!pacEatsGhostMode) && (((Math.abs(Pacman.pacLocation.getX() - g1.getX()) < 30) && (Math.abs(Pacman.pacLocation.getY() - g1.getY()) < 30)) || ((Math.abs(Pacman.pacLocation.getX() - g2.getX()) < 30) && (Math.abs(Pacman.pacLocation.getY() - g2.getY()) < 30)))) {
            lifeFlag--;
            return lifeFlag;
        } else if ((pacEatsGhostMode && (((Math.abs(Pacman.pacLocation.getX() - g1.getX()) < 30) && (Math.abs(Pacman.pacLocation.getY() - g1.getY()) < 30))))) {     //pac and ghost1 crash
            return 5;
        } else if ((pacEatsGhostMode && (((Math.abs(Pacman.pacLocation.getX() - g2.getX()) < 30) && (Math.abs(Pacman.pacLocation.getY() - g2.getY()) < 30))))) {     //pac and ghost2 crash
            return 6;
        }

        return 100;
    }

    public boolean isPacEatsGhostMode() {
        return pacEatsGhostMode;
    }

    public void setPacEatsGhostMode(boolean pacEatsGhostMode) {
        this.pacEatsGhostMode = pacEatsGhostMode;

        if (pacEatsGhostMode) {
            timer = new Timer();

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {


                    System.out.println("orrrfog"+counter);

                    System.out.println(seged);
                    seged++;
                    if(seged<=12 && seged%2==0){
                        Window.g1.setIcon(new ImageIcon("red_Ghost.png"));
                        Window.g2.setIcon(new ImageIcon("blue_Ghost.png"));
                    }
                    else if(seged<=12  && seged%2==1){
                        Window.g1.setIcon(new ImageIcon("running_ghost.png"));
                        Window.g2.setIcon(new ImageIcon("running_ghost.png"));
                    }
                    else if(seged>12){
                        seged=0;
                        System.out.println("hzhzhzhzhzhzhzhzhzhhzhzzhzhzhzhz");
                        GameEngine.pacEatsGhostMode=false;          //belso oszt miatt statikus
                        Window.g1.setIcon(new ImageIcon("red_Ghost.png"));
                        Window.g2.setIcon(new ImageIcon("blue_Ghost.png"));

                        timer.cancel();timer.purge();
                    }
                }
            }, 1000,1000);

            // elindit egy timert
            //  majd 5 mp utan leallitja es akkor falsera allitja a pac eat gostot
            pacEatsGhostMode = (false);
        }

    }


}
