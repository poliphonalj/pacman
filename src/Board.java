
import java.util.ArrayList;

public class Board {
    ArrayList<Wall> array = new ArrayList<>();
    ArrayList<Dot> dotarray = new ArrayList<>();

    public ArrayList<Wall> createBoard() {
        ///////////////palya
//////////////palya kulso kerete
        for (int i = 0; i < 23; i++) {                                  //felso sor
            array.add(new Wall(i * 32, 0));
        }
        for (int i = 0; i < 9; i++) {                                   //bal felso oszlop
            array.add(new Wall(0, i * 32));
        }
        for (int i = 10; i < 17; i++) {                                  //bal also oszlop
            array.add(new Wall(0, i * 32));
        }


        for (int i = 0; i < 23; i++) {                                  //also sor
            array.add(new Wall(i * 32, 512));
        }


        for (int i = 0; i < 9; i++) {                                   //jobb felso oszlop
            array.add(new Wall(710, i * 32));
        }
        for (int i = 10; i < 17; i++) {                                  //jobb also oszlop
            array.add(new Wall(710, i * 32));
        }
////////////palya kulso kerete




            for (int i = 0; i < 3; i ++) {                                  //bal felso elem
                array.add(new Wall( 64, i * 32+64));
            }
            for(int i=0;i<6;i++){
                array.add(new Wall( i*32+64, 64));
            }

        array.add(new Wall( 288, 32));
        array.add(new Wall( 288, 64));              //fakbol lelogo elem
        array.add(new Wall( 288, 96));

        for(int i=0;i<6;i++){
            array.add(new Wall( 128, i*32+128));            //fuggoleges a bal felso elem alatt
        }

        for(int i=0;i<12;i++){
            array.add(new Wall( i*32+160, 160));            //fuggoleges a bal felso elem alatt
        }
        array.add(new Wall( 160, 128));
        array.add(new Wall( 192, 128));
        array.add(new Wall( 224, 128));



        for(int i=0;i<10;i++){                                   //jobb felso vastag
            array.add(new Wall( i*32+352, 64));
        }
        for(int i=0;i<10;i++){
            array.add(new Wall( i*32+352, 96));
        }



        for (int i = 0; i < 5; i ++) {                                  //balajtoval szembeni
            array.add(new Wall( 64, i * 32+192));
        }


        for (int i = 0; i < 5; i ++) {                                  //balajtoval szembeni allatti l alak
            array.add(new Wall( i*32, 384));
        }
       // array.add(new Wall( 128, 358));


        for (int i = 0; i < 5; i ++) {                                  //legalso bal l alak
            array.add(new Wall( i*32+64, 448));
        }
        for (int i = 0; i < 8; i ++) {                                  //legalso bal l alak
            array.add(new Wall( 192, 448-i*32));
        }

        array.add(new Wall( 256, 224));         //maganyos pottyok
        array.add(new Wall( 256, 256));
        array.add(new Wall( 256, 320));//

        array.add(new Wall( 256, 384));
        array.add(new Wall( 256, 448));
        array.add(new Wall( 256, 512));


        array.add(new Wall( 320, 256));         //szellemlak
        array.add(new Wall( 352, 256));

        array.add(new Wall( 416, 256));
        //array.add(new Wall( 456, 260));

        for(int i=0;i<3;i++){
            array.add(new Wall( 320, i*32+256));
            array.add(new Wall( 448, i*32+256));
        }

        for(int i=0;i<5;i++){
            array.add(new Wall( i*32+320, 352));
        }


        return array;
    }


    public ArrayList<Dot> createDots() {
        for (int i = 0; i < 23; i ++) {
            for (int j = 0; j < 17; j ++) {
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
