package labs;

import java.io.File;

public class MazeRunner
{
   public static void main(String[] args)
   {
      Maze maze = new Maze(new File("Maze.txt"));
      System.out.println(maze);
      maze.search();
      System.out.println(maze);
   }
}

