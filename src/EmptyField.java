import javax.swing.*;



    public class  EmptyField extends JLabel {//a boardhoz wallakat tartalmazo arraylist miatt szarmazik a wallbol
        int x;
        int y;

        public  EmptyField(int x, int y){
            super(new ImageIcon("empty.png"));
            this.x=x;
            this.y=y;
            this.setBounds(x,y,45,45);
        }
    }
