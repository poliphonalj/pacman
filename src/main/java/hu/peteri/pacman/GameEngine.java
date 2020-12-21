package hu.peteri.pacman;
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

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GameEngine {
    JLabel over;

    // tries to move the ghost towards to the pac.
    // this method calculate the distance of the ghost and pac and chose the
    // best direction for the ghost
    // to minimalize this distance
    public int moveGhost() {
        int pacX = (int) Pacman.pacLocation.getX();
        int pacY = (int) Pacman.pacLocation.getY();

        int ghostX = (int) Ghost.actualPoint.getX();
        int ghostY = (int) Ghost.actualPoint.getY();

        Point pointPac = (new Point(pacX, pacY));
        Point pointGhost = new Point(ghostX, ghostY);

        // to ghost tries to chase down the pac
        // if the original distance gets less in case of moving then the motion
        // to east>>>the ghost moves to east
        if (pointPac.distance(pointGhost) > pointPac.distance(pointGhost.getX() + 5, pointGhost.getY())) { // west
            System.out.println("1");
            return 1;
        }

        else if (pointPac.distance(pointGhost) >= pointPac.distance(pointGhost.getX() - 5, pointGhost.getY())) { // east
            System.out.println("0");
            return 0;
        }

        else if (pointPac.distance(pointGhost) > pointPac.distance(pointGhost.getX(), pointGhost.getY() - 5)) { // north
            System.out.println("3");
            return 3;
        }

        else if (pointPac.distance(pointGhost) >= pointPac.distance(pointGhost.getX(), pointGhost.getY() + 5)) { // south
            System.out.println("4");
            return 2;
        } else {
            System.out.println("5");
        }
        System.out.println(pointPac.distance(pointGhost));
        return 0;
    }

    // this method runs if the pac and ghost are crashing eachother
    public void isGameOver() {
        System.out.println(Pacman.pacLocation + "   es   " + Ghost.actualPoint);
        // a case of collision
        if ((Math.abs(Pacman.pacLocation.getX() - Ghost.actualPoint.getX()) < 50) && (Math.abs(Pacman.pacLocation.getY() - Ghost.actualPoint.getY()) < 50)) {
            gameOver();
            System.out.println("over");
        }
    }

    // generate the game over screen
    public JLabel gameOver() {
        Window.gameOn = false;

        over = new JLabel(new ImageIcon(getClass().getResource("/over.png")));
        over.setSize(400, 300);
        over.setLocation(200, 120);
        Window.gameOn = false; // sets the static field of Window to false so
                               // window will create a gamover process
        return over;
    }
}
