/*Name: Brian Matthys
 * Date Started: 4/1/2012
 * Latest Update Date: 9/8/2012
 */

package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Main extends JFrame 
{
	Image dbImage;
	Graphics dbg;
	
 	static Ball b = new Ball(393, 293);
 	 	 	
   int GWIDTH = 800;
   int GHEIGHT = 600;
   public static boolean gameOver;
   
   Dimension screenSize = new Dimension(GWIDTH, GHEIGHT);
    
   //new object main creates the game and the window and sets size
    public Main()
    {
        this.setTitle("2D Pong Game");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.black);
        this.addKeyListener(new AL());
    }
    
    //three threads, p1, p2, and ball and start them
    public static void main(String[] args)
    {
        Main m = new Main();
        Thread ball = new Thread(b);
     	Thread p1 = new Thread(b.p1);
     	Thread p2 = new Thread(b.p2);
        ball.start();
    	p1.start();
    	p2.start();  
    }
    
    //double buffering
    public void paint(Graphics g)
    {
    	dbImage = createImage(getWidth(), getHeight());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage, 0, 0, this);
    }
    
    //draw the string to display the scores and set the colors
    public void draw(Graphics g)
    {
    	b.draw(g);
    	b.p1.draw(g);
    	b.p2.draw(g);
    	
    	g.setColor(Color.red);
    	g.drawString("Score: "+b.p1Score, 150,50);
    	g.setColor(Color.cyan);
    	g.drawString("Score: "+b.p2Score, 670,50);
    	
    	repaint();
    }
    
    //Action Listenenr listens for keyboard input among the classes
    public class AL extends KeyAdapter 
    {
        
        public void keyPressed(KeyEvent e)
        {
            b.p1.keyPressed(e);
            b.p2.keyPressed(e);
            b.keyPressed(e);
        }
       
        public void keyReleased(KeyEvent e)
        {
            b.p1.keyReleased(e);
            b.p2.keyReleased(e);
            b.keyReleased(e);
        }
    }

	public boolean isGameOver()
	{
		return gameOver;
	}

	public void setGameOver(boolean gameOver) 
	{
		this.gameOver = gameOver;
	}
        
}
