import javax.swing.*;

public class Wall extends JLabel {
    int x;
    int y;

    public Wall(int x, int y){
        super(new ImageIcon("wall.png"));
        this.x=x;
        this.y=y;
        this.setBounds(x,y,32,32);
    }

}
