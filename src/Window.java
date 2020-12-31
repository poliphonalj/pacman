//gives an outfit for the program
//responsible for menu
//responsible for sound
//responsible for frame etc.....

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Window {

    Clip clip;
    static JFrame frame = new JFrame();
    static int score = 0;

    Pacman pacman;
   static Ghost g1;
    GameEngine gameEngine;

    JPanel gameOverPanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel sidePanel = new JPanel();
    JLabel scoreLabel = new JLabel();
    JLabel scoringLabel = new JLabel("0");
    JLabel livesLabel = new JLabel();
    JLabel soundLabel = new JLabel();
    JLabel gameoverLabel = new JLabel();
    int soundFlag = 1;
    Timer timer;

    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException, AWTException {

        Board b = new Board();          // adding the board to the Frame
        ArrayList wallList = b.createBoard();
        ArrayList dotslist = b.createDots();

        pacman = new Pacman();
        gameEngine = new GameEngine();

        g1 = new Ghost(359, 220, "red");
        //Ghost g2 = new Ghost(673, 51, "blue");

        pacman.setBounds(33, 33, 30, 30);

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());
        frame.setTitle("PACMAN");
        playSound("pacman_beginning.WAV");    //plays starting music

        gamePanel.setLayout(null);
        gamePanel.add(pacman);
        gamePanel.add(g1);

        // frame.add(g2);


        for (int i = 0; i < wallList.size(); i++) {             //drawing the board items from an arrayList
            gamePanel.add((Wall) wallList.get(i));
        }

        for (int i = 0; i < dotslist.size(); i++) {              //drawing the dot items from an arrayList
            gamePanel.add((Dot) dotslist.get(i));
        }
        livesLabel.setIcon(new ImageIcon("lives3.png"));
        soundLabel.setIcon(new ImageIcon("speaker_on.png"));


        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 44));
        scoreLabel.setForeground(Color.white);
        scoreLabel.setText("SCORES:");
        scoringLabel.setFont(new Font("Serif", Font.PLAIN, 44));

        sidePanel.add(scoreLabel);
        scoreLabel.setBounds(30, 50, 200, 50);
        sidePanel.add(scoringLabel);
        scoringLabel.setBounds(70, 120, 200, 50);
        scoringLabel.setForeground(Color.white);

        sidePanel.add(livesLabel);
        livesLabel.setBounds(35, 400, 200, 60);

        sidePanel.add(soundLabel);
        soundLabel.setBounds(70, 300, 200, 50);

        sidePanel.setLayout(null);
        gamePanel.setBounds(0, 0, 742, 544);
        sidePanel.setBounds(742, 0, 250, 544);

        frame.setLayout(null);

        frame.add(sidePanel);
        frame.add(gamePanel);

        sidePanel.setBackground(new Color(4, 5, 42));
        frame.setBackground(new Color(4, 5, 42));
        gamePanel.setBackground(new Color(4, 5, 42));

        frame.setSize(998, 580);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //g1.move();







        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                try {
                    switch (e.getKeyCode()) {
                        case 37:       //left arrow

                            pacman.move(37);
                            scoringLabel.setText(score + "");
                            switch (gameEngine.isCrash(g1)) {
                                case 2:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives2.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 1:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives1.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 0:
                                    Thread.sleep(1000);
                                    showGameOver();
                                    break;
                            }
                            //gameEngine.isGameOver(g2);
                            break;

                        case 38:       //upp arrow

                            pacman.move(38);
                            scoringLabel.setText(score + "");
                            switch (gameEngine.isCrash(g1)) {
                                case 2:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives2.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 1:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives1.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 0:
                                    Thread.sleep(1000);
                                    showGameOver();
                                    //gameEngine.gameOver();
                                    break;
                            }
                            //gameEngine.isGameOver(g2);
                            break;

                        case 39:       //right arrow

                            pacman.move(39);
                            scoringLabel.setText(score + "");
                            switch (gameEngine.isCrash(g1)) {
                                case 2:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives2.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 1:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives1.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 0:
                                    Thread.sleep(1000);
                                    showGameOver();
                                    break;
                            }
                            //gameEngine.isGameOver(g2);
                            break;

                        case 40:       //down arrow

                            pacman.move(40);
                            scoringLabel.setText(score + "");
                            switch (gameEngine.isCrash(g1)) {
                                case 2:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives2.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 1:
                                    if (!(soundFlag % 2 == 0)) {
                                        playSound("gameover.WAV");
                                    }
                                    Thread.sleep(1000);
                                    livesLabel.setIcon(new ImageIcon("lives1.png"));
                                    pacman.setLocation(new Point(33, 33));
                                    g1.setLocation(352,300);
                                    break;

                                case 0:
                                    Thread.sleep(1000);
                                    showGameOver();
                                    break;
                            }
                            //gameEngine.isGameOver(g2);
                            break;

                        case (27):       //game over created by pressing "esc" button
                            if (!(soundFlag % 2 == 0)) {
                                playSound("gameover.WAV");
                            }
                            showGameOver();
                            break;
                    }

                    if (!(clip.isRunning()) && !(soundFlag % 2 == 0)) {
                        playSound("pacman_chomp.WAV");
                    }

                    gameEngine.moveGhost(g1);//this is the core of the program, moves the ghost to the suitable coorinates
                    //g2.move(gameEngine.moveGhost(g2));//this is the core of the program, moves the ghost to the suitable coorinates


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

        soundLabel.addMouseListener(new MouseListener() {           //turns on or mutes the sound with the help of an int flag
            @Override
            public void mouseClicked(MouseEvent e) {
                soundFlag++;
                if (soundFlag % 2 == 0) {              //to mute
                    soundLabel.setIcon(new ImageIcon("speaker_mute.png"));
                    clip.stop();
                } else {
                    soundLabel.setIcon(new ImageIcon("speaker_on.png"));
                    clip.start();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }

    public void showGameOver() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        gamePanel.remove(pacman);
        gamePanel.remove(g1);
        frame.remove(gamePanel);
        frame.remove(sidePanel);

        gameoverLabel.setIcon(new ImageIcon("over.png"));     //redraw the frame with a game over logo
        gameoverLabel.setBounds(0, 0, 300, 300);
        gameOverPanel.add(gameoverLabel);
        gameOverPanel.setBounds(0, 0, 998, 580);
        frame.add(gameOverPanel);

        playSound("gameover.WAV");
        gameoverLabel.setBackground(new Color(4, 5, 42));
        gameOverPanel.setBackground(new Color(4, 5, 42));
        frame.setSize(999, 580);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        frame.validate();
    }


    void playSound(String soundFile) throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(soundFile));
        clip.open(inputStream);
        clip.start();
    }
}
