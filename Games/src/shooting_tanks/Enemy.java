package shooting_tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy implements Runnable 
{
	int x;
	int y;
	int xDirection;
	int yDirection;
	int health;
	int p1Score;
	int pHealth = 10;
	int bx;
	int by;
	boolean shot = false;
	public static boolean readyToFire;
	
	Rectangle enemy;
	Rectangle bullet;	
	Player p1 = new Player(290, 15, 10);
	
	public Enemy(int x, int y, int health)
	{
		p1Score = 0;
		this.x = x;
		this.y = y;
		this.health = health;
		
		Random r = new Random();
		int rDir = r.nextInt(1);
		
		if(rDir == 0)
		{
			rDir--;
			setXDirection(rDir);
		}
		
        int yrDir = r.nextInt(1);
		
		/*if(yrDir == 0)
		{
			yrDir--;
			setYDirection(yrDir);
		}
		*/
		
		enemy = new Rectangle(this.x, this.y, 100, 30);
	}
		
	public void draw(Graphics g)
	{
		//draw the enemy initially
		g.setColor(Color.BLUE);
		g.fillRect(enemy.x, enemy.y, enemy.width+5, enemy.height);
		g.fillRect(enemy.x+45, enemy.y+25, 15, 30);
		
		if(shot)
		{
			g.setColor(Color.BLUE);
			g.fillRect(bullet.x+5, bullet.y-10, bullet.width, bullet.height);
		}
		
		//if the enemy dies remove it
		//Need to delete the current one and make a new enemy
		if(health <= 0)
		{
			enemy = new Rectangle(x, y, 100, 30);
			health = 10 ;
		}
	}
	
	/*
	 * Always seems to create the enemy bullet in the same place
	 * Probably because i tell it to create it at the enemy x +45
	 * and enemy y+65...need to figure a way for it to always fire 
	 * if within range of the player
	 */
	public void shoot()
	{
		if(enemy.x >= p1.x-100)
		{
		readyToFire = true;
		if(readyToFire)
		{
			bullet = new Rectangle (enemy.x+45, enemy.y+65);
			by = enemy.y+65;
			bx = enemy.x+45;
			bullet = new Rectangle(bx, by, 3 , 15);
			shot = true;
			
			if(bullet.y >= 595)
			{
				bullet = new Rectangle(0, 0, 0, 0);
				//shot = false;
				//readyToFire = true;
			}
			
		}
		}
		bullet.y+=5;
		//readyToFire = false;
	}
	
	public void collision()
	{
		//Collision between the bullet and the enemy. 
		//Checks first if the player bullet is null
		//Checks if the bounds of bullet and enemy intersect 
		
		if(enemy.getBounds().intersects(p1.player))
		{
			setYDirection(-1);
		}
		
		if(p1.bullet != null && enemy.getBounds().contains(p1.bullet.getBounds()))
		{
			//setYDirection(-1);
			p1Score+=100;
			health-=1;
			p1.bullet = new Rectangle(0, 0, 0, 0);
		}
	}
		
	public void move()
	{
		enemy.x+=xDirection;
		enemy.y+=yDirection;
		
		//Checks if the enemy hits the left side of the screen
		//if so reverse the direction to the right
		if(enemy.x <= 0)
		{
			setXDirection(1);
		}
		
		//Checks if the enemy hits the right side of the screen
		//if so reverse the direction to the left
		if(enemy.x >= 700)
		{
			setXDirection(-1);
		}
		
		//Checks if the enemy hits the top of the screen
		//if so reverse the direction to the bottom
		if(enemy.y <= 30)
		{
			setYDirection(1);
			
		}
		
		//Checks if the enemy hits the bottom of the screen
		//if so reverse the direction to the top
		if(enemy.y >= 570)
		{
			setYDirection(-1);
			
		}
   }
	
	 public void run()
	    {
	        try
	        {
	           while(true)
	           {
	        	   move();
	        	   collision();
	        	   shoot();
	        	   Thread.sleep(3);
	           }
	        }
	        catch(Exception e){System.err.println(e.getMessage());}
	    }

	 public void setXDirection(int direction) 
	{
		xDirection = direction;
	}

		public void setYDirection(int direction) 
	{
		yDirection = direction;
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

	public int getHealth() 
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}

	public int getP1Score()
    {
		return p1Score;
	}

	public void setP1Score(int score) 
	{
		p1Score = score;
	}

	public Player getP1() 
	{
		return p1;
	}

	public void setP1(Player p1) 
	{
		this.p1 = p1;
	}

	public Rectangle getEnemy() 
	{
		return enemy;
	}

	public void setEnemy(Rectangle enemy) 
	{
		this.enemy = enemy;
	}

	public int getXDirection() 
	{
		return xDirection;
	}

	public int getYDirection()
	{
		return yDirection;
	}

	public int getPHealth() {
		return pHealth;
	}

	public void setPHealth(int health) {
		pHealth = health;
	} 
}

