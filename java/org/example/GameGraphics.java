package org.example;
import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame{

    GameData data;
    public GameGraphics() throws HeadlessException
    {
        Draw draw = new Draw();
        add(draw);

        data = null;
        super.setTitle("ball");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600); //default 1080 and 760
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(GameData data) {
        this.data = data;
        repaint();
    }

    class Draw extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g) {

            if (data.getBall2() == null){

            }
            else
            {
                g.setColor(data.getBall2().getColor());
                g.fillOval(data.getBall2().getX(), data.getBall2().getY(), data.getBall2().getWidth(), data.getBall2().getHeight());
            }
            g.setColor(data.getBall().getColor());
            g.fillOval(data.getBall().getX(), data.getBall().getY(), data.getBall().getWidth(), data.getBall().getHeight());

            g.setColor(data.getWall().getColor());
            g.fillRect(data.getWall().getX(), data.getWall().getY(), data.getWall().getWidth(), data.getWall().getHeight());
        }
    }
}
