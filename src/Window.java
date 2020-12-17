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
    JLabel hero=new JLabel();
    ImageIcon image;
    Clip clip;
boolean kapcsolo=true;

    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
        JFrame f = new JFrame();

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        f.setIconImage(img.getImage());





        playSound("pacman_beginning.WAV");    //plays starting music
        image = new ImageIcon("pac_right.png");

        hero.setHorizontalAlignment(10);
        hero = (new JLabel(image));
        f.setLayout(null);
        f.add(hero);
        hero.setSize(48, 48);
        hero.setLocation(0, 0);


        f.setSize(800, 600);
        f.setResizable(false);
        f.setTitle("PACMAN");
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(new Color(4,5,42));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //ennek hianyaban nem all le program csak az ablak tunik el


        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                try {
                    //az ablak bal felso sarka a (0,0)

                    switch (e.getKeyCode()) {

                        case 37:       //balra nyil kodja
                            hero.setLocation(hero.getX() - 5, hero.getY());     //balra mozgatja
                            image.setImage(new ImageIcon("pac_left.png").getImage());
                            break;


                        case 38:       //fel nyil kodja
                            hero.setLocation(hero.getX(), hero.getY() - 5);     //fel mozgatja
                            image.setImage(new ImageIcon("pac_up.png").getImage());
                            break;


                        case 39:       //jobb nyil kodja
                            hero.setLocation(hero.getX() + 5, hero.getY());     //jobbra mozgatja
                            if (kapcsolo){
                                image.setImage(new ImageIcon("pac_right.png").getImage());
                                kapcsolo=false;
                            }
                            else{
                                image.setImage(new ImageIcon("pac_full.png").getImage());
                                kapcsolo=true;
                            }


                            break;

                        case 40:
                            hero.setLocation(hero.getX(), hero.getY() + 5);     //le mozgatja
                            image.setImage(new ImageIcon("pac_down.png").getImage());
                            break;
                    }




                    if(!(clip.isRunning())) playSound("pacman_chomp.WAV");


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


