package homework;

public class RoadSimulator
{
	public static void main(String[] args)
	{
		final int NUM_CARS_PER_ROAD = 100;	
		TrafficLight light = new TrafficLight();
		RoadRunner[] roads = new RoadRunner[4];	
		Thread[] someThreads = new Thread[roads.length];
		
		for(int i = 0; i < 4; i++)
		{
			roads[i] = new RoadRunner(i + 1, light);
			someThreads[i] = new Thread(roads[i]);
			
			for(int j = 1; j <= NUM_CARS_PER_ROAD; j++)
			{
				roads[i].add(new String("Car" + j));
			}
		}
		
		for(int i = 0; i < 4; i++)
		{
			someThreads[i].start();
		}
	}
}	
