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


public class Window {

    Clip clip;
    int pacccing = 0;            //opening and closing the mouth
    static boolean gameOn = true;
    Pacman pacman;
    GameEngine gameEngine;
    static JFrame frame = new JFrame();
    JPanel gamePanel = new JPanel();
    JPanel sidePanel = new JPanel();

    Ghost g1;
    static int score = 0;
    JLabel scoreLabel = new JLabel();
    JLabel scoringLabel = new JLabel("0");
    JLabel livesLabel=new JLabel();



    public Window() throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException, AWTException {
        Board b = new Board();          // adding the board to the Frame
        ArrayList aList = b.createBoard();
        ArrayList dotslist = b.createDots();


        pacman = new Pacman();
        pacman.setBounds(33, 33, 30, 30);

        ImageIcon img = new ImageIcon("pacman.png");//ez az ablak ikonja
        frame.setIconImage(img.getImage());
        playSound("pacman_beginning.WAV");    //plays starting music

        gamePanel.setLayout(null);

        gamePanel.add(pacman);
        gameEngine = new GameEngine();

        g1 = new Ghost(673, 423, "red");
        //  System.out.println(g1);
        //Ghost g2 = new Ghost(673, 51, "blue");
        gamePanel.add(g1);
        // frame.add(g2);


        for (int i = 0; i < aList.size(); i++) {
            gamePanel.add((Wall) aList.get(i));
        }

        for (int i = 0; i < dotslist.size(); i++) {
            gamePanel.add((Dot) dotslist.get(i));
        }


        //gamePanel.setBounds(0,0,300, 560);
        //sidePanel.setSize(100,560);
        //scoreLabel.setSize(100,600);
        //frame.setResizable(false);

        frame.setTitle("PACMAN");


        livesLabel.setIcon(new ImageIcon("lives3.png"));



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
        livesLabel.setBounds(35,400,200,60);


        sidePanel.setLayout(null);
        // frame.setLayout(null);
        gamePanel.setBounds(0, 0, 742, 544);
        sidePanel.setBounds(742, 0, 250, 544);

        frame.setLayout(null);

        frame.add(sidePanel);
        frame.add(gamePanel);

        //sidePanel.setBackground(new Color(4, 5, 42));
        // sidePanel.setSize(200,600);
        sidePanel.setBackground(new Color(4, 5, 42));
        frame.setBackground(new Color(4, 5, 42));
        gamePanel.setBackground(new Color(4, 5, 42));

        frame.setSize(998, 580);
        frame.setLocationRelativeTo(null);
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
                        gamePanel.remove(pacman);
                        gamePanel.remove(g1);
                        //frame.remove(g2);
                        gamePanel.validate();
                        gamePanel.add(gameEngine.gameOver());     //redraw the frame with a game over logo
                        gamePanel.setSize(1000, 601);
                        playSound("gameover.WAV");
                        gamePanel.setVisible(true);
                    }
                    //az ablak bal felso sarka a (0,0)
                    switch (e.getKeyCode()) {
                        case 37:       //balra nyil kodja

                            System.out.println("nhnhnhnnnhnhnhnhnnhnhnhnhnnhnhnnh");


                            pacman.move(37);
                            gameEngine.isGameOver(g1);
                            //  gameEngine.isGameOver(g2);        //ask gameEngine if it is a gameover
                            scoringLabel.setText(score + "");
                            break;
                        case 38:       //fel nyil kodja
                            pacman.move(38);
                            gameEngine.isGameOver(g1);
                            //gameEngine.isGameOver(g2);
                            scoringLabel.setText(score + "");
                            break;
                        case 39:       //jobb nyil kodja
                            pacman.move(39);
                            gameEngine.isGameOver(g1);
                            //gameEngine.isGameOver(g2);
                            scoringLabel.setText(score + "");
                            break;
                        case 40:       //moving and turning south
                            pacman.move(40);
                            gameEngine.isGameOver(g1);
                            //gameEngine.isGameOver(g2);

                            scoringLabel.setText(score + "");
                            break;

                        case (27):       //game over created by pressing "esc" button
                            gamePanel.remove(pacman);
                            gamePanel.remove(g1);
                            //frame.remove(g2);
                            gamePanel.validate();
                            gamePanel.add(gameEngine.gameOver());     //redraw the frame with a game over logo
                            gamePanel.setSize(700, 550);
                            playSound("gameover.WAV");
                            gamePanel.setVisible(true);
                            break;
                    }
                    if (!(clip.isRunning())) {
                        playSound("pacman_chomp.WAV");
                    }

                    //System.out.println(gameEngine.moveGhost(g1) + "fdfdfdfdf");
                    g1.move(gameEngine.moveGhost(g1));//this is the core of the program, moves the ghost to the suitable coorinates
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
    }

    void playSound(String soundFile) throws IOException, LineUnavailableException, UnsupportedAudioFileException, InterruptedException {
        clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(soundFile));
        clip.open(inputStream);
        clip.start();
    }
}
