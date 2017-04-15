package homework;

import java.util.LinkedList;

public class RoadRunner implements Runnable
{
		private static final int DELAY = 5;
		private LinkedList<String> queue;
		private int number;
		private TrafficLight light;
		
		public RoadRunner(int roadNumber, TrafficLight aLight)
		{
			queue = new LinkedList<String>();
			number = roadNumber;
			light = aLight;
		}
		
		public void add(String car)
		{
			queue.addLast(car);
		}
		
		public void run()
		{
			while(queue.size() > 0)
			{
				try
				{
					String tempCar = queue.removeFirst();
					light.turnGreen(number, tempCar);
					Thread.sleep(DELAY);
				} catch(InterruptedException e){}
			}
		}
}
