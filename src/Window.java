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


public class Window {

    Clip clip;
    int pacccing = 0;            //opening and closing the mouth
    static boolean gameOn = true;
    Pacman pacman;
    GameEngine gameEngine;
    JFrame frame = new JFrame();


    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        pacman = new Pacman();
        pacman.setHorizontalAlignment(10);

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());
        playSound("pacman_beginning.WAV");    //plays starting music

        frame.setLayout(null);
        frame.add(pacman);
        gameEngine = new GameEngine();

        Ghost g1 = new Ghost();
        frame.add(g1);

        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setTitle("PACMAN");
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(4, 5, 42));
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
                            gameEngine.isGameOver();        //ask gameEngine if it is a gameover
                            break;
                        case 38:       //fel nyil kodja
                            pacman.move(38);
                            gameEngine.isGameOver();
                            break;
                        case 39:       //jobb nyil kodja
                            pacman.move(39);
                            gameEngine.isGameOver();
                            break;
                        case 40:       //moving and turning south
                            pacman.move(40);
                            gameEngine.isGameOver();
                            break;

                        case (27):       //game over created by pressing "esc" button
                            frame.remove(pacman);
                            frame.remove(g1);
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


                    g1.move(gameEngine.moveGhost());//this is the core of the program, moves the ghost to the suitable coorinates




                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (LineUnavailableException lineUnavailableException) {
                    lineUnavailableException.printStackTrace();
                } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                    unsupportedAudioFileException.printStackTrace();
                } catch (InterruptedException interruptedException) {
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
