package org.example;

import org.example.data.Ball;
import org.example.data.Wall;

import java.awt.*;

public class GameData {

    private Ball ball;
    private Ball ballEnemy;
    private Wall wall;
    public void update() {
        /*if ()
        {
            ball.move(7, Direction.DOWN);
            wall.move(7, Direction.RIGHT);
        }
        else {
            ball.move(5, Direction.RIGHT);
        }*/

        ball.getBallRectangle();
        if(!(ballEnemy == null)){
            if (ball.isCollided(ballEnemy.getBallRectangle())) {
                ballEnemy = null;
                System.out.println("Děje se kolize");
            }
        }






    }
    public void initialize (){
        ball = new Ball(20,20,50,50, Color.BLUE);
        wall = new Wall(550,20,30,500, Color.RED);
        ballEnemy = new Ball(100,69,50,50, Color.GREEN);
    }

    public Ball getBall() {
        return ball;
    }
    public Ball getBall2() {
        return ballEnemy;
    }

    public Wall getWall() {
        return wall;
    }
}
