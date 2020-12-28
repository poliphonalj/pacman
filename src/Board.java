import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board {
    ArrayList<Wall> array = new ArrayList<>();
    ArrayList<Dot> dotarray = new ArrayList<>();

    public ArrayList<Wall> createBoard() {
        ///////////////palya
//////////////palya kulso kerete
        for (int i = 0; i < 18; i++) {                                  //felso sor
            array.add(new Wall(i * 50, 0));
        }
        for (int i = 0; i < 5; i++) {                                   //jobb felso oszlop
            array.add(new Wall(0, i * 50));
        }
        for (int i = 6; i < 13; i++) {                                  //jobb also oszlop
            array.add(new Wall(0, i * 50));
        }
        for (int i = 0; i < 18; i++) {                                  //also sor
            array.add(new Wall(i * 50, 515));
        }
        for (int i = 0; i < 5; i++) {                                   //bal felso oszlop
            array.add(new Wall(735, i * 50));
        }
        for (int i = 6; i < 13; i++) {                                  //bal also oszlop
            array.add(new Wall(735, i * 50));
        }
////////////palya kulso kerete


        //////////////////////////////////4 szelso T elem
        for (int j = 0; j < 12; j += 2) {
            for (int i = 2; i < 10; i += 2) {                                  //elso belso akadaly oszlop
                array.add(new Wall(100 + j * 52, i * 52));
            }
        }


        ///  for(int i=0;i<array.size();i++)
        // System.out.println(array.get(i));
//


        return array;
    }


    public ArrayList<Dot> createDots() {
        for (int i = 0; i < 16; i ++) {
            for (int j = 0; j < 12; j ++) {
                if (!((Window.frame.getContentPane().findComponentAt(i + 2, j + 2)) instanceof Wall)) {
                   // System.out.println("dots");
                    dotarray.add(new Dot(i*52,j*52));
                }
            }

        }
        System.out.println(dotarray.get(1));
        return dotarray;
    }

}
