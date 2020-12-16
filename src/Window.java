
import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.io.File;


public class Window {

    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame f=new JFrame();

        ImageIcon img = new ImageIcon("pacman.png");
        f.setIconImage(img.getImage());

        JPanel panel=new JPanel();
        f.add(panel);

        playSound("pacman_beginning.WAV");    //plays starting music


        panel.add(new JLabel("nyomogass tetszes szerinti gombokat"));

        f.setSize(800, 600);
        f.setResizable(false);
        f.setTitle("PACMAN");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //ennek hianyaban nem all le program csak az ablak tunik el



        f.addKeyListener(new KeyListener() {
           @Override
           public void keyTyped(KeyEvent e) {

           }

           @Override
           public void keyPressed(KeyEvent e) {
               try {
                   playSound("pacman_chomp.WAV");
               } catch (IOException ioException) {
                   ioException.printStackTrace();
               } catch (LineUnavailableException lineUnavailableException) {
                   lineUnavailableException.printStackTrace();
               } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                   unsupportedAudioFileException.printStackTrace();
               }


           }

           @Override
           public void keyReleased(KeyEvent e) {

           }
       });



    }

    void playSound(String soundFile) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(soundFile));
        clip.open(inputStream);
        clip.start();
    }


}


