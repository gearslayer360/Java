package shooting_tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player implements Runnable
{
	int x;
	int y;
	int phealth;
	int bx;
	int by;
	int xDirection;
	public static boolean readyToFire;
	boolean shot = false;
	Rectangle player;
	Rectangle bullet;

	public Player(int x, int y, int health)
	{
		this.x = x;
		this.y = y;
		this.phealth = phealth;
		player = new Rectangle(400, 550, 100, 30);

	}		

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(e.getKeyCode() == e.VK_A)
		{
			setXDirection(-1);
		}

		if(e.getKeyCode() == e.VK_D)
		{
			setXDirection(1);
		}

		//firing button shoots a bullet each time space is pressed 
		//only supposed to let you fire one at a time 
		//currently glitched so if player holds the fire button
		//the readyToFire never becomes false and there is an infinite loop
		//of creating bullets that only go a few pixels before another is created
		if(e.getKeyCode() == e.VK_SPACE)
		{
			readyToFire = true;
			if(readyToFire)
			{
				bullet = new Rectangle (player.x+45, player.y-20);
				by = player.y-20;
				bx = player.x+45;
				bullet = new Rectangle(bx, by, 3 , 15);
				shot = true;
			}
		}
	}

	public void keyReleased(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(e.getKeyCode() == e.VK_A)
		{
			setXDirection(0);
		}

		if(e.getKeyCode() == e.VK_D)
		{
			setXDirection(0);
		}

		//sets readyToFire to false so if the space is released you cant fire
		//another bullet until you press space again
		//creates a null bullet at 0, 0, 0, 0 so you dont end up
		//with infinite bullets lagging the game (I think)
		if(e.getKeyCode() == e.VK_SPACE)
		{
			readyToFire = false;

			if(bullet.y <= -5)
			{
				bullet = new Rectangle(0, 0, 0, 0);
				shot = false;
				readyToFire = true;
			}
		}
	}

	//moves the bullet when it is shot
	public void shoot()
	{
		if(shot)
		{
			bullet.y-=5;
		}
	}

	//moves the player when they press A for left or D for right
	public void move()
	{
		player.x+= xDirection;

		//Checks if the player hits the left side of the screen
		//if so set x to the left edge of the screen
		if(player.x <= 20)
		{
			player.x = 20;
		}

		//Checks if the player hits the right side of the screen
		//if so set x to the right edge of the screen
		if(player.x >= 700)
		{
			player.x = 700;
		}
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(player.x, player.y, player.width+5, player.height);
		g.fillRect(player.x+45, player.y-25, 15, 30);

		//if a bullet is shot draw it where it looks 
		//like it comes from the players gun
		if(shot)
		{
			g.setColor(Color.RED);
			g.fillRect(bullet.x+5, bullet.y-10, bullet.width, bullet.height);
		}
	}

	public void setXDirection(int direction) 
	{
		xDirection = direction;
	}

	public void damage() 
	{
		phealth--;
	}

	public void run() 
	{
		try
		{
			while(true)
			{
				move();
				shoot();
				Thread.sleep(2);
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

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getPhealth()
	{
		return phealth;
	}

	public void setPhealth(int phealth)
	{
		this.phealth = phealth;
	}

	public int getBx()
	{
		return bx;
	}

	public void setBx(int bx)
	{
		this.bx = bx;
	}

	public int getBy()
	{
		return by;
	}

	public void setBy(int by)
	{
		this.by = by;
	}

	public boolean isReadyToFire()
	{
		return readyToFire;
	}

	public void setReadyToFire(boolean readyToFire)
	{
		this.readyToFire = readyToFire;
	}

	public Rectangle getPlayer()
	{
		return player;
	}

	public void setPlayer(Rectangle player)
	{
		this.player = player;
	}

	public Rectangle getBullet()
	{
		return bullet;
	}

	public void setBullet(Rectangle bullet)
	{
		this.bullet = bullet;
	}

	public int getXDirection()
	{
		return xDirection;
	}	 
}


