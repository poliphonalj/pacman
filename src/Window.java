//gives an outfit for the program
//responsible for menu
//responsible for sound
//responsible for frame etc.....

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.io.File;
import java.util.ArrayList;


public class Window{

    Clip clip;
    int pacccing = 0;            //opening and closing the mouth
    static boolean gameOn = true;
    Pacman pacman;
    GameEngine gameEngine;
    static JFrame frame = new JFrame();
    Ghost g1;
    Board board = new Board();


    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException, AWTException {
        pacman = new Pacman();
        pacman.setBounds(51,51,50,50);

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());
        playSound("pacman_beginning.WAV");    //plays starting music
        frame.setLayout(null);



        frame.add(pacman);
        gameEngine = new GameEngine();

        g1 = new Ghost(673, 423, "red");
        System.out.println(g1);
        Ghost g2 = new Ghost(673, 51, "blue");
        frame.add(g1);
        frame.add(g2);


///////////////palya
//////////////palya kulso kerete
        for (int i = 0; i < 18; i++) {                                  //felso sor
            frame.add(new Wall(i * 50, 0));
        }
        for (int i = 0; i < 5; i++) {                                   //jobb felso oszlop
            frame.add(new Wall(0, i * 50));
        }
        for (int i = 6; i < 13; i++) {                                  //jobb also oszlop
            frame.add(new Wall(0, i * 50));
        }
        for (int i = 0; i < 18; i++) {                                  //also sor
            frame.add(new Wall(i * 50, 515));
        }
        for (int i = 0; i < 5; i++) {                                   //bal felso oszlop
            frame.add(new Wall(735, i * 50));
        }
        for (int i = 6; i < 13; i++) {                                  //bal also oszlop
            frame.add(new Wall(735, i * 50));
        }
////////////palya kulso kerete


        //////////////////////////////////4 szelso T elem
        for (int j = 0; j < 12; j += 2) {
            for (int i = 2; i < 10; i += 2) {                                  //elso belso akadaly oszlop
                frame.add(new Wall(100 + j * 52, i * 52));
            }
        }




frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setTitle("PACMAN");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(4, 5, 42));
       // frame.add(new JLabel(new ImageIcon("bor.png")));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //ennek hianyaban nem all le program csak az ablak tunik el


        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    if (gameOn == false) {  //in case of a game over this arranges the game over screen
                        frame.remove(pacman);
                        frame.remove(g1);
                        frame.remove(g2);
                        frame.validate();
                        frame.add(gameEngine.gameOver());     //redraw the frame with a game over logo
                        frame.setSize(800, 601);
                        playSound("gameover.WAV");
                        frame.setVisible(true);
                    }
                    //az ablak bal felso sarka a (0,0)
                    switch (e.getKeyCode()) {
                        case 37:       //balra nyil kodja
                            pacman.move(37);
                            gameEngine.isGameOver(g1);
                            gameEngine.isGameOver(g2);        //ask gameEngine if it is a gameover
                            break;
                        case 38:       //fel nyil kodja
                            pacman.move(38);
                            gameEngine.isGameOver(g1);
                            gameEngine.isGameOver(g2);
                            break;
                        case 39:       //jobb nyil kodja
                            pacman.move(39);
                            gameEngine.isGameOver(g1);
                            gameEngine.isGameOver(g2);
                            break;
                        case 40:       //moving and turning south
                            pacman.move(40);
                            gameEngine.isGameOver(g1);
                            gameEngine.isGameOver(g2);
                            break;

                        case (27):       //game over created by pressing "esc" button
                            frame.remove(pacman);
                            frame.remove(g1);
                            frame.remove(g2);
                            frame.validate();
                            frame.add(gameEngine.gameOver());     //redraw the frame with a game over logo
                            frame.setSize(800, 601);
                            playSound("gameover.WAV");
                            frame.setVisible(true);
                            break;
                    }
                    if (!(clip.isRunning())) {
                        playSound("pacman_chomp.WAV");
                    }

                    System.out.println(gameEngine.moveGhost(g1) + "fdfdfdfdf");
                    g1.move(gameEngine.moveGhost(g1));//this is the core of the program, moves the ghost to the suitable coorinates
                    g2.move(gameEngine.moveGhost(g2));//this is the core of the program, moves the ghost to the suitable coorinates


                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (InterruptedException | AWTException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    void playSound(String soundFile) throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(soundFile));
        clip.open(inputStream);
        clip.start();
    }
}
