//holds each game field in a 2 dim array......
//directing the actors. Each field knows its own possible directions
//and knows its type(wall, empty field, food, etc)
//control the ghosts and pacman (not letting them to walk into a wall)
//controls and runs the whole game
//knows the lives of pacman
//knows the scores and level of the game


import javax.swing.*;

public class GameEngine {
    JLabel over;

    public JLabel gameOver(){
       over=new JLabel(new ImageIcon("over.png"));
       over.setSize(400,300);
       over.setLocation(200,120);

       return over;
    }


}
