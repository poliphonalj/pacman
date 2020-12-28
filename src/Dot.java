import javax.swing.*;


    public class Dot extends JLabel{//a boardhoz wallakat tartalmazo arraylist miatt szarmazik a wallbol
        int x;
        int y;

        public Dot(int x, int y){
            super(new ImageIcon("dot.png"));
            this.x=x;
            this.y=y;
            //this.setText("0");

        this.setBounds(x,y,50,50);
        }

    }




