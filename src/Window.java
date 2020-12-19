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
    JLabel pacmanLabel = new JLabel();
    ImageIcon image;
    Clip clip;
    int pacccing = 0;            //opening and closing the mouth
    Ghost g1;
    boolean gameOn = true;
    Pacman pacman;
    GameEngine game;
    JFrame frame = new JFrame();


    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        pacman = new Pacman();
        pacman.setHorizontalAlignment(10);

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());
        playSound("pacman_beginning.WAV");    //plays starting music
        // image = new ImageIcon("pac_right.png");


        //pacmanLabel = (new JLabel(image));
        frame.setLayout(null);
        frame.add(pacman);
        game = new GameEngine();

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
                    //az ablak bal felso sarka a (0,0)
                    switch (e.getKeyCode()) {
                        case 37:       //balra nyil kodja
                            pacman.move(37);
                            break;
                        case 38:       //fel nyil kodja
                            pacman.move(38);
                            break;
                        case 39:       //jobb nyil kodja
                            pacman.move(39);
                            break;
                        case 40:       //moving and turning south
                            pacman.move(40);
                            break;

                        case 27:       //esc game over
                            frame.remove(pacman);
                            frame.remove(g1);
                            frame.validate();
                            frame.setSize(800,600);         //redraw the frame with a game over logo
                            frame.add(game.gameOver());
                            playSound("gameover.WAV");
                            frame.setVisible(true);
                            break;

                    }
                    if (!(clip.isRunning())) {
                        playSound("pacman_chomp.WAV");
                    }
                    // g1.move();            at every keyEvent the ghosts are moving de nem joooooooo

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
