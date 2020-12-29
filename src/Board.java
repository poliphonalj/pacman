
import java.util.ArrayList;

public class Board {
    ArrayList<Wall> array = new ArrayList<>();
    ArrayList<Dot> dotarray = new ArrayList<>();

    public ArrayList<Wall> createBoard() {
        ///////////////palya
//////////////palya kulso kerete
        for (int i = 0; i < 34; i++) {                                  //felso sor
            array.add(new Wall(i * 29, 0));
        }
        for (int i = 0; i < 9; i++) {                                   //bal felso oszlop
            array.add(new Wall(0, i * 30));
        }
        for (int i = 10; i < 20; i++) {                                  //bal also oszlop
            array.add(new Wall(0, i * 30));
        }
        for (int i = 0; i < 34; i++) {                                  //also sor
            array.add(new Wall(i * 29, 520));
        }
        for (int i = 0; i < 9; i++) {                                   //jobb felso oszlop
            array.add(new Wall(710, i * 30));
        }
        for (int i = 10; i < 20; i++) {                                  //jobb also oszlop
            array.add(new Wall(700, i * 30));
        }
////////////palya kulso kerete




            for (int i = 0; i < 3; i ++) {                                  //bal felso elem
                array.add(new Wall( 64, i * 32+64));
            }
            for(int i=0;i<6;i++){
                array.add(new Wall( i*32+64, 64));
            }

        array.add(new Wall( 290, 32));
        array.add(new Wall( 290, 64));              //fakbol lelogo elem
        array.add(new Wall( 290, 96));

        for(int i=0;i<6;i++){
            array.add(new Wall( 130, i*32+130));            //fuggoleges a bal felso elem alatt
        }

        for(int i=0;i<12;i++){
            array.add(new Wall( i*32+160, 160));            //fuggoleges a bal felso elem alatt
        }
        array.add(new Wall( 160, 130));
        array.add(new Wall( 192, 130));
        array.add(new Wall( 224, 130));



        for(int i=0;i<10;i++){                                   //jobb felso vastag
            array.add(new Wall( i*32+354, 64));
        }
        for(int i=0;i<10;i++){
            array.add(new Wall( i*32+354, 96));
        }



        for (int i = 0; i < 5; i ++) {                                  //balajtoval szembeni
            array.add(new Wall( 64, i * 32+196));
        }


        for (int i = 0; i < 5; i ++) {                                  //balajtoval szembeni allatti l alak
            array.add(new Wall( i*32, 390));
        }
        array.add(new Wall( 128, 358));


        for (int i = 0; i < 5; i ++) {                                  //legalso bal l alak
            array.add(new Wall( i*32+64, 454));
        }
        for (int i = 0; i < 8; i ++) {                                  //legalso bal l alak
            array.add(new Wall( 194, 452-i*32));
        }

        array.add(new Wall( 260, 256));         //maganyos potty


        array.add(new Wall( 324, 256));         //szellemlak
        array.add(new Wall( 356, 256));

        array.add(new Wall( 420, 256));
        array.add(new Wall( 452, 256));

        for(int i=0;i<3;i++){
            array.add(new Wall( 324, i*32+256));
            array.add(new Wall( 452, i*32+256));
        }

        for(int i=0;i<5;i++){
            array.add(new Wall( i*32+324, 352));
        }


        return array;
    }


    public ArrayList<Dot> createDots() {
        for (int i = 0; i < 34; i ++) {
            for (int j = 0; j < 20; j ++) {
                if (!((Window.frame.getContentPane().findComponentAt(i + 2, j + 2)) instanceof Wall)) {
                   // System.out.println("dots");
                    dotarray.add(new Dot(i*32,j*32));
                }
            }

        }
        System.out.println(dotarray.get(1));
        return dotarray;
    }

}
