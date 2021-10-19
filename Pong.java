import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.Timer;


public class Pong extends JComponent{
	
	private int p1Score;
	private int p2Score;
	
	private int speed = 1; //update speed of timer
	private double ballSpeed = 1.5; //speed of ball higher is faster
	private boolean go = false; //default is false is set to true whenever a key is pressed to start the round
	
	private Timer t;
	private Ball ball;
	private Paddle left;
	private Paddle right;
	
	private int difficulty = 30;
	
	Pong()
	{
		setFocusable(true);
		addKeyListener(new Key());
		addMouseMotionListener(new Mouse());
		reset();
	}
	
	public void reset()
	{
		p1Score = 0;
		p2Score = 0;
		left = new Paddle(15, 300);
		right = new Paddle(785, 300);
		startRound();
	}
	
	public void startRound()
	{
		go = false;
		ball = new Ball(ballSpeed);
		t = new Timer(speed, (ActionEvent e) -> {
			if(go)//if a key has been pressed to start the round
				update();
		});
		t.start();
	}
	
	public void update()
	{
		ball.move();
		ai();
		hitPaddle();
		hitWall();
		score();
		repaint();
		
	}
	
	public void ai()
	{
		if(Math.abs(left.getY()-ball.getY())<50 - (int)(Math.random()*40)) {}
		else if(ball.getY()<left.getY())
		{
			left.setY(left.getY() - (int)(Math.random()*difficulty));
		}
		else
		{
			left.setY(left.getY() + (int)(Math.random()*difficulty));
		}
		
		
	}
	
	public void hitPaddle()
	{
		left.collide(ball);
		right.collide(ball);
	}
	
	public void paintComponent(Graphics g)
	{
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.WHITE);
		g.drawLine(400, 0, 400, 600);
		String score = p1Score + "    " + p2Score;
		g.drawString(score, 387, 20);
		
		//displaying the ball
		g.fillOval(ball.getX() - ball.getRadius(), ball.getY() - ball.getRadius(), ball.getRadius() * 2, ball.getRadius() * 2);
		
		//drawing paddles
		g.fillRect(left.getX()-5, left.getY()-50, 10, 100);
		g.fillRect(right.getX()-5, right.getY()-50, 10, 100);
	}
	
	//determines if the ball has collided with the top or bottom then handles it appropriately
	public void hitWall()
	{
		//if the ball's y - radius is <= 0 then is hit the top
		if(ball.getY() - ball.getRadius()  < 0)
		{
			//ball.setvY(ball.getvY() * -1);
			ball.collide(0, 1);
		}
		//if the ball's y + radius is >= 600 then is hit the top
		if(ball.getY() +ball.getRadius()  >= 600)
		{
			ball.collide(0, -1);
		}

	}

	public void score()
	{
		//if x went < 0 then p2 scored if it went greater than 800 p1 scored
		if(ball.getX() <= 0)
		{
			t.stop();
			p2Score++;
			if(p2Score == 10)
			{
				reset();
			}
			else
			{
				startRound();
			}
		}
		if(ball.getX() >= 800)
		{
			t.stop();
			p1Score++;
			if(p1Score == 10)
			{
				reset();
			}
			else
			{
				startRound();
			}
		}
	}
	
	
	class Mouse implements MouseMotionListener
	{
		public void mouseDragged(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {
			right.setY(e.getY());
		}
		
	}
	//key stuff
	class Key implements KeyListener
	{
		public void keyTyped(KeyEvent event) { go = true;}
		public void keyPressed(KeyEvent event) { go = true;}
		public void keyReleased(KeyEvent e) {go = true;}
		
	}
}
