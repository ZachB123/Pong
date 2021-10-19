import java.lang.Math;
public class Paddle {
	private int x;
	private int y;
	
	Paddle(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void collide(Ball ball)
	{
		//first check that a collision is possible by using the balls y
		if(!(ball.getY() + ball.getRadius() < y - 50 || ball.getY() - ball.getRadius() > y + 50))
		{
			//in here the ball is at a y coord that the paddle covers
			//checking x coord
			if(!(ball.getX() + ball.getRadius() < x-5 || ball.getX() - ball.getRadius() > x+5))
			{
				hit(ball);
			}
		}
	}
	
	public void hit(Ball ball)
	{
		ball.setvX(10);
		//switching vY
		
		int hitY = ball.getY() - y; //displacement on y axis of where the ball hit
		
		if(hitY <= 50 && hitY > 40)
		{
			ball.setvY(12);
		}
		if(hitY <= 40 && hitY > 30)
		{
			ball.setvY(9);
		}
		if(hitY <= 30 && hitY > 20)
		{
			ball.setvY(7);
		}
		if(hitY <= 20 && hitY > 10)
		{
			ball.setvY(4);
		}
		if(hitY <= 10 && hitY > -10)
		{
			int lol = (int)(Math.random()*9)-4;
			ball.setvY(lol);
			
		}
		if(hitY <= -10 && hitY > -20)
		{
			ball.setvY(-4);
		}
		if(hitY <= -20 && hitY > -30)
		{
			ball.setvY(-7);
		}
		if(hitY <= -30 && hitY > -40)
		{
			ball.setvY(-9);
		}
		if(hitY <= -40 && hitY >= -50)
		{
			ball.setvY(-12);
		}
		
		if(ball.getX() < x)
		{
			ball.setvX(-1 * (ball.getvX()));
		}
	}
	
	public void move(int amount)
	{
		y += amount;
		if(y < 50)
		{
			y = 50;
		}
		if(y > 550)
		{
			y = 550;
		}
	}
	
	public void setY(int y)
	{
		this.y = y;
		if(this.y < 50)
		{
			this.y = 50;
		}
		if(this.y > 550)
		{
			this.y = 550;
		}
		
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
}
