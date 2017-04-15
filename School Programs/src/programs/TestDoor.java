package programs;

public class TestDoor
{
	public static void main(String[] args)
	{
		Door frontDoor = new Door("Front", "Open");
		System.out.println("The front door is " + frontDoor.getState());
		System.out.println("Expected: open ");
		
		Door backDoor = new Door("Back", "Closed");
		System.out.println("The back door is " + backDoor.getState());
		System.out.println("Expected: closed ");
		
		backDoor.setState("open");
		System.out.println("The back door is " + backDoor.getState());
		System.out.println("Expected: open ");
		
	}
}
