/*Name: Brian Matthys
 * Date Started: 4/1/2012
 * Latest Update Date: 9/8/2012
 */

package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

  public class Paddle implements Runnable
  {
	  int x;
	  int y;
	  int yDirection;
	  int id;
	  Rectangle paddle;
	
	//constructor of paddle this is the basic and default paddle object
    public Paddle(int x, int y, int id)
    {
	  this.x = x;
	  this.y = y;
	  this.id = id;
	  paddle = new Rectangle(x, y, 20, 100);
    }

    //takes keyboard input for pressed keys for p1 and none for the AI controlled p2
    public void keyPressed(KeyEvent e)
    {
     switch(id)
     {
    	default:System.out.println("Please enter correct key");
    	break;
    	
    	case 1:
     
    	if(e.getKeyCode() == e.VK_W)
    	{
    		setYDirection(-1);
    	}
    	
    	if(e.getKeyCode() == e.VK_S)
    	{
    		setYDirection(1);
    	}
    	break;
    	
    	case 2:
    	
    	break;
      }
    }
    
  //takes keyboard input for released keys for p1 and none for the AI controlled p2
    public void keyReleased(KeyEvent e)
    {
     switch(id)
     {
    	default:System.out.println("Please enter correct key");
    	break;
    	
    	case 1:
     
    	if(e.getKeyCode() == e.VK_W)
    	{
    		setYDirection(0);
    	}
    	
    	if(e.getKeyCode() == e.VK_S)
    	{
    		setYDirection(0);
    	}
    	break;
    	
    	case 2:
    
    	break;
      }
    }
    
    public void setYDirection(int yDir)
    {
    	yDirection = yDir;
    }
    
    //moves the paddle p1 and checks if it hits the upper and lower y bounds
    //if it collides with the edge of the screen, it sets it to the boundary's value
    public void move()
    {
    	paddle.y+= yDirection;
    	
    	if(paddle.y <= 20)
    	{
    		paddle.y = 20;
    	}
    	//sets paddle y value to 500 because screen max is 600 and paddle is 100
    	//therefore 600-100 = 500
    	if(paddle.y >= 500)
    	{
    		paddle.y = 500;
    	}
    }
    
    //AI control for paddle 2 basically sets paddle 2 moving 
    //in the direction of the ball. Simple and efficient AI movement 
    //without the risk of it looking too stupid, or being unbeatable
    public void moveEnemy()
    {
    	if (Ball.getYDirection() == -1)
		{
			Ball.getP2().setYDirection(-1);
		}
		
		if (Ball.getYDirection() == 1)
		{
			Ball.getP2().setYDirection(1);
		}
    }
    
    //draws paddle 1 and paddle 2 and sets paddle 1 color to red 
    //and paddle 2 color to cyan
    public void draw(Graphics g)
    {
    	switch(id)
    	{
    	default:System.out.println("Please enter correct key");
    	break;
    	
    	case 1:
    		g.setColor(Color.RED);
    		g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
    		break;
    		
    	case 2:
    		g.setColor(Color.CYAN);
    		g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
    		break;
    	}
    }

    //run the thread for the paddles as long as gameOver is not true
    //moves the paddle p1 and paddle p2 
    public void run() 
    {
    	try
    	{
    		while(true && Main.gameOver == false)
    		{
    			move();
    			moveEnemy();
    			Thread.sleep(6);
    		}
    		
    	}
    	catch(Exception e){System.err.println(e.getMessage());}
    }

	public int getId()
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}
    
  }
