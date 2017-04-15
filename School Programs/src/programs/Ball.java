/*Name: Brian Matthys
 * Date Started: 4/1/2012
 * Latest Update Date: 9/8/2012
 */

package programs;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Ball implements Runnable 
{
	public int x;
	public int y;
	int xDirection;
	static int yDirection;
	
	public int p1Score;
	public int p2Score;
	
	//creates the paddle objects 
	Paddle p1 = new Paddle(15, 290 , 1);
	static Paddle p2 = new Paddle(770, 290, 2);
	
	Rectangle ball;
	
	//constructor of ball this is the basic and default ball object
	public Ball(int x, int y)
	{
		p1Score = 0;
		p2Score = 0;
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		int rDir = r.nextInt(1);
		
		if(rDir == 0)
		{
			rDir--;
			setXDirection(rDir);
		}
		
        int yrDir = r.nextInt(1);
		
		if(yrDir == 0)
		{
			yrDir--;
			setYDirection(yrDir);
		}
		
		ball = new Rectangle(this.x, this.y, 7, 7);
	}
	
	public void setXDirection(int xDir)
	{
		xDirection = xDir;
	}
	
	public void setYDirection(int yDir)
	{
		yDirection = yDir;
	}
	
	//takes keyboard input for the pressing of keys Y and N ONLY after 
	//gameOver is true. Won't accept the input for these keys
	//while the game is running.
	 public void keyPressed(KeyEvent e)
	    {
		 //Player wants to restart
	    	if(e.getKeyCode() == e.VK_Y && Main.gameOver == true)
	    	{
	    		Main.gameOver = false;
	    		p1Score = 0;
	    		p2Score = 0;
	    		p1.paddle.y = 290;
	    		p2.paddle.y = 290;
	    		ball.x = this.x;
	    		ball.y = this.y;
	    		Thread ball = new Thread(Main.b);
	         	Thread p1 = new Thread(Main.b.p1);
	         	Thread p2 = new Thread(Main.b.p2);
	            ball.start();
	        	p1.start();
	        	p2.start();
	        	
	    	}
	    
	    	//Player doesn't want to restart
	    		if(e.getKeyCode() == e.VK_N && Main.gameOver == true)
		    	{
		    		System.exit(0);
		    	}
	      }
	 
	//takes keyboard input for the releasing of keys Y and N ONLY after 
	//gameOver is true. Won't accept the input for these keys
	//while the game is running.
	 public void keyReleased(KeyEvent e)
	 {
		 //Player wants to restart
	    	if(e.getKeyCode() == e.VK_Y && Main.gameOver == true)
	    	{
	    		Main.gameOver = false;
	    		p1Score = 0;
	    		p2Score = 0;
	    		p1.paddle.y = 290;
	    		p2.paddle.y = 290;
	    		ball.x = this.x;
	    		ball.y = this.y;
	    		Thread ball = new Thread(Main.b);
	         	Thread p1 = new Thread(Main.b.p1);
	         	Thread p2 = new Thread(Main.b.p2);
	            ball.start();
	        	p1.start();
	        	p2.start();
	    	}
	    	
	    	//Player doesn't want to restart
	    		if(e.getKeyCode() == e.VK_N && Main.gameOver == true)
		    	{
		    		System.exit(0);
		    	}
	      }
	
	//Draws the ball and sets the color to white. 
	//Also when the game is over it displays who wins accordingly
	//along with the option to restart or quit.
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);
		
		//the game is over because one player has reached the required score to win
		if(Main.gameOver == true)
		{
			//player 1 wins the game
			if(p1Score >=5)
			{
				g.setColor(Color.red);
		    	g.drawString("You Win!!!   Final Score: " + p1Score + "   -   " + p2Score, 350,300);
		    	g.setColor(Color.red);
		    	g.drawString("Play Again?" , 350,325);
		    	g.drawString("Press [Y] for Yes or [N] for No", 350,350);
			}
			
			//player 2 has wins the game
			if(p2Score >=5)
			{
				g.setColor(Color.CYAN);
				g.drawString("You Lose!!!   Final Score: " + p2Score + "   -   " + p1Score, 350,300);
		    	g.setColor(Color.CYAN);
		    	g.drawString("Play Again?" , 350,325);
		    	g.drawString("Press [Y] for Yes or [N] for No", 350,350);
			}
		}
	}
	
	public void collision()
	{
		if(ball.intersects(p1.paddle))
		{
			setXDirection(1);
		}
		
		if(ball.intersects(p2.paddle))
		{
			setXDirection(-1);
		}
	}
		
	public void move()
	{
		collision();
		ball.x+=xDirection;
		ball.y+=yDirection;
						
		//Reverse ball when it hits edge
		
		if(ball.x <= 0)
		{
			setXDirection(1);
			//Add to score
			p2Score++;
			//game over if score is above 2 points
			if(p2Score >=5)
			{
				Main.gameOver = true;
			}
		}
		
		if(ball.x >= 790)
		{
			setXDirection(-1);
			//Add to score
			p1Score++;
			//game over if score is above 2 points
			if(p1Score >=5)
			{
				Main.gameOver = true;
			}
		}
		
		if(ball.y <= 20)
		{
			setYDirection(1);
			
		}
		
		if(ball.y >= 590)
		{
			setYDirection(-1);
			
		}		
	}
        
    public void run()
    {
        try
        {
           while(true && Main.gameOver ==false)
           {
        	   move();
        	   Thread.sleep(4);
           }
        }
        catch(Exception e){System.err.println(e.getMessage());}
    }

	public int getX() 
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public static int getYDirection() 
	{
		return yDirection;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public Paddle getP1() 
	{
		return p1;
	}

	public void setP1(Paddle p1) 
	{
		this.p1 = p1;
	}

	public static Paddle getP2() 
	{
		return p2;
	}

	public void setP2(Paddle p2)
	{
		this.p2 = p2;
	}
}
