import javax.swing.*;
import java.util.ArrayList;

public class Board {
    ArrayList<JLabel> board = new ArrayList<>();
    JLabel jl=new JLabel(new ImageIcon("wall.png"));

    public ArrayList<JLabel>getBoard() {
      int a=-50;
        for(int i=0;i<18;i++){
            a+=50;
            jl.setBounds(a,0,50,50);
          board.add(jl);
          System.out.println(board.get(i));
      }


        return board;
    }

        /*JLabel wall0 = new JLabel(new ImageIcon("leftcorner.png"));
        wall0.setBounds(0, 0, 50, 50);//upper wall

        JLabel wall1 = new JLabel(new ImageIcon("hor_line.png"));
        wall1.setBounds(50, 0, 250, 50);//upper wall

        JLabel wall2 = new JLabel(new ImageIcon("innerright.png"));
        wall2.setBounds(300, 0, 50,50);//upper wall

        JLabel wall3 = new JLabel(new ImageIcon("innerleft.png"));
        wall3.setBounds(350, 0, 50,50);//upper wall

        JLabel wall4 = new JLabel(new ImageIcon("ver_line.png"));
        wall4.setBounds(325, 50, 50,50);//upper wall

        JLabel wall5 = new JLabel(new ImageIcon("ver_line.png"));
        wall5.setBounds(0, 50, 50,150);//upper wall

        JLabel wall6 = new JLabel(new ImageIcon("downend.png"));
        wall6.setBounds(0, 200, 50,50);//upper wall

        board.add(wall0);
        board.add(wall1);
        board.add(wall2);
        board.add(wall3);
        board.add(wall4);
        board.add(wall5);
        board.add(wall6);
*/
    }
