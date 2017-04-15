package homework;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TrafficLight
{
	private Lock intersectionLock; 
	
	public TrafficLight()
	{
		intersectionLock = new ReentrantLock();
	}
	
   public void turnGreen(int road, String car)
   {
      intersectionLock.lock();
      try
      {
         System.out.println("Light turned green by road " + road);
         System.out.println("Waiting for road " + road + " car " + car
               + " to clear intersection");
         for (int i = 10; i >= 0; i--)
         {
            System.out.print(i + " ");
         }
         System.out.println();
      }
      finally
      {
         intersectionLock.unlock();
      }
   }

}
