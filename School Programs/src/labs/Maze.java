package labs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze
{
   private String[][] maze;
   private int rows;
   private int cols;
   private int startX;
   private int startY;
   private int endX;
   private int endY;
   private Scanner scan;
   
   public Maze(File filename)
   {
      Scanner scan;
      try 
      {
         scan = new Scanner(filename);
      }
      catch(FileNotFoundException e)
      {
          System.out.println("File not found");
          return;
      }
      
      rows = scan.nextInt();
      cols = scan.nextInt();
      maze = new String[rows][cols];
      startX = scan.nextInt();
      startY = scan.nextInt();
      endX = scan.nextInt();
      endY = scan.nextInt();
      
      for (int i = 0; i < rows; i++)
      {
         String temp = scan.next();
         for (int j = 0; j < cols; j++)
         {
            maze[i][j] = "" + temp.charAt(j);
         }
      }
      scan.close();
   }

   public String toString()
   {
      String temp = "";
      for (int i = 0; i < rows; i++)
      {
         for (int j = 0; j < cols; j++)
         {
            temp = temp + maze[i][j] + " ";
         }
         temp = temp + '\n';
      }  
      return temp;
   }

   public boolean search()
   {
      return searchMaze(startX, startY);
   }

   public boolean searchMaze(int i, int j)
   {
	   
     if(maze[i][j].equals("a"))
     	{
    	  System.out.println("true");
    	  maze[i][j] = " ";
    	  searchMaze(i ,j);
     	}
     
     else if(maze[i+1][j].equals("a"))
   	 	{
    	 maze[i+1][j] = " ";
    	 searchMaze(i+1 ,j);
    	 System.out.println("true 1");
   	 	}
    	 
   	 else if(maze[i][j+1].equals("a"))
   	 	{
   		 maze[i][j+1] = " ";
   		 searchMaze(i ,j+1);
   		 System.out.println("true 2");
   	 	}
   	 
   	 else if(maze[i-1][j].equals("a"))
   	 	{
   		 maze[i-1][j] = " ";
   		 searchMaze(i-1 ,j);
   		 System.out.println("true 3");
   	 	}
   	 
   	 else if(maze[i][j-1].equals("a"))
   	 	{
   		 maze[i][j-1] = " ";
   		 searchMaze(i ,j-1);
   		 System.out.println("true 4"); 
   	 	}
   			   
     else if(maze[i+1][j].equals("x") && maze[i][j-1].equals("x") && maze[i][j+1].equals("x"))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i-1,j);
     }
     
     else if(maze[i+1][j].equals("x") && maze[i][j-1].equals("x") && maze[i][j+1].equals("v"))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i-1,j);
     }
     
     else if(maze[i+1][j].equals("x") && maze[i][j-1].equals("v") && maze[i][j+1].equals("x"))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i-1,j);
     }
     
     else if(maze[i+1][j].equals("v") && maze[i][j-1].equals("x") && maze[i][j+1].equals(" "))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i-1,j);
     }
     
     /*else if(maze[i][j+1].equals("x") || maze[i][j+1].equals(" "))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i,j);
     }
     
     else if(maze[i-1][j].equals("x") || maze[i-1][j].equals(" "))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i,j);
     }
     
     else if(maze[i][j-1].equals("x")|| maze[i][j-1].equals(" "))
     {
    	 maze[i][j]= "v";
    	 searchMaze(i,j);
     }
     */
     
	   return true; 
	   
  }
   
}

