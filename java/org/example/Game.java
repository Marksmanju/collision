package org.example;


import org.example.data.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    public static void main(String[] args) {
        new Game();
    }

    public Game()
    {
        GameData data = new GameData();
        GameGraphics graphics = new GameGraphics();

        data.initialize();
        graphics.render(data);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data.update();
                graphics.render(data);

            }
        });
        timer.start();


        graphics.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickX = e.getX();
                int clickY = e.getY();

                int ballX = data.getBall().getX();
                int ballY = data.getBall().getY();

                int ballWidth = data.getBall().getWidth();
                int ballHeight = data.getBall().getHeight();

                int differenceX = clickX - ballX;
                int differenceY = clickY - ballY - graphics.getInsets().top;

                if(differenceX >= 0 && differenceX < ballWidth && differenceY >= 0 && differenceY < ballHeight) {
                    data.getBall().setColor(Color.WHITE);
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

        graphics.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)
                {
                    data.getBall().move(5, Direction.LEFT);
                }
                else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)
                {
                    data.getBall().move(5, Direction.RIGHT);
                }
                else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)
                {
                    data.getBall().move(5, Direction.DOWN);
                }
                else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
                {
                    data.getBall().move(5, Direction.UP);
                }
                else
                {

                }
                if(e.getKeyCode() == KeyEvent.VK_Y)
                {
                    data.getBall().setColor(Color.yellow);
                }
                if(e.getKeyCode() == KeyEvent.VK_B)
                {
                    data.getBall().setColor(Color.blue);
                }
                if(e.getKeyCode() == KeyEvent.VK_R)
                {
                    data.getBall().setColor(Color.red);
                }
                if(e.getKeyCode() == KeyEvent.VK_F)
                {
                    graphics.setSize(1920,1080);
                }


            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
