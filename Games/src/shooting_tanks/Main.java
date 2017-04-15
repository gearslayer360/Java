package shooting_tanks;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame
{
	
	Image dbImage;
	Graphics dbg;
 
	static Enemy en = new Enemy(393,93, 10);
	//static Player p1 = new Player(290, 15, 10);
	int GWIDTH = 800;
	int GHEIGHT = 600;
 
	Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
	
	public Main()
	{
		this.setTitle("2D Shooting Tanks Game");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.black);
        this.addKeyListener(new AL());
	}
	 
	public static void main(String[] args)
	{
		Main m = new Main();
		Thread enemy = new Thread(en);
     	Thread player = new Thread(en.p1);
     	enemy.start();
    	player.start();  
	}
	
	public void paint(Graphics g)
	{
		dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    	
	}
	
	 public void draw(Graphics g)
	    {
	    	en.draw(g);
	    	en.p1.draw(g);
	    	
	    	g.setColor(Color.red);
	    	g.drawString("Score: "+en.p1Score, 150,50);
	    	
	    	g.setColor(Color.RED);
	    	g.drawString("Your Health: " + en.pHealth, 600,300);
	    	g.setColor(Color.blue);
	    	g.drawString("Enemy Health: " +en.health, 200,300);
	    	repaint();    	
	    }
	
	public class AL extends KeyAdapter 
    {
        
        public void keyPressed(KeyEvent e)
        {
        	int keyCode = e.getKeyCode();
            en.p1.keyPressed(e);
        }
       
        public void keyReleased(KeyEvent e)
        {
        	int keyCode = e.getKeyCode();
            en.p1.keyReleased(e);
        }
    }
}
