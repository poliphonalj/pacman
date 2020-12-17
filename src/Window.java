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

    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        Pacman pacman = new Pacman();


        JFrame frame = new JFrame();

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());

        playSound("pacman_beginning.WAV");    //plays starting music
        image = new ImageIcon("pac_right.png");

        pacmanLabel.setHorizontalAlignment(10);
        pacmanLabel = (new JLabel(image));
        frame.setLayout(null);
        frame.add(pacmanLabel);


        Ghost g1=new Ghost();
        frame.add(g1);



        pacmanLabel.setSize(50, 50);
        pacmanLabel.setLocation(0, 0);


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
                            pacmanLabel.setLocation(pacmanLabel.getX() - 5, pacmanLabel.getY());     //moving and turning towards to west
                            if (pacccing <= 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Left()).getImage());
                                pacccing++;
                            } else if (pacccing > 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Full()).getImage());
                                pacccing++;
                                if (pacccing == 10)
                                    pacccing = 0;
                            }
                            break;

                        case 38:       //fel nyil kodja
                            pacmanLabel.setLocation(pacmanLabel.getX(), pacmanLabel.getY() - 5);     //moving and turning towards to north
                            if (pacccing <= 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Up()).getImage());
                                pacccing++;
                            } else if (pacccing > 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Full()).getImage());
                                pacccing++;
                                if (pacccing == 10)
                                    pacccing = 0;
                            }
                            break;


                        case 39:       //jobb nyil kodja
                            pacmanLabel.setLocation(pacmanLabel.getX() + 5, pacmanLabel.getY());     //moving east
                            if (pacccing <= 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Right()).getImage());
                                pacccing++;
                            } else if (pacccing > 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Full()).getImage());
                                pacccing++;
                                if (pacccing == 10)
                                    pacccing = 0;
                            }
                            break;

                        case 40:                                    //moving and turning south
                            pacmanLabel.setLocation(pacmanLabel.getX(), pacmanLabel.getY() + 5);
                            if (pacccing <= 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Down()).getImage());
                                pacccing++;
                            } else if (pacccing > 5) {
                                image.setImage(new ImageIcon(pacman.getPath_Full()).getImage());
                                pacccing++;
                                if (pacccing == 10)
                                    pacccing = 0;
                            }
                            break;
                    }
                    if (!(clip.isRunning())){
                        playSound("pacman_chomp.WAV");
                    }
                    //g1.move();


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


