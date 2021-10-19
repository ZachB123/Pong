public class Ball {
	
	private int x;
	private int y;
	private double vX;
	private double vY;
	private int radius;
	private double speed;
	
	private double actualX;
	private double actualY;
	
	
	
	Ball(double speed)
	{
		x = 400;
		y = 300;
		actualX = 400;
		actualY = 300;
		vX = -10;
		vY = 1;
		radius = 5;
		this.speed = speed;
	}
	
	public void move()
	{
		actualX = (actualX + (vX * speed));
		actualY = (actualY + (vY * speed));
		x = (int) actualX;
		y = (int) actualY;
	}
	
	public void collide(int xValue, int yValue)
	{
		if(xValue == -1 || xValue == 1)
		{
			//vX *= -1;
		}
		if(yValue == -1 || yValue == 1)
		{
			vY *= -1;
		}
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public double getvX()
	{
		return vX;
	}
	
	public double getvY()
	{
		return vY;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setvX(double vX)
	{
		this.vX = vX;
	}
	
	public void setvY(double vY)
	{
		this.vY = vY;
	}
}
