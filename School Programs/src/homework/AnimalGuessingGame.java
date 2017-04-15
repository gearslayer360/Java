/*
 *Name: Brian Matthys
 *Date: 11/18/2013
 *Class: CSCI 1302
 *Section: 200
 */

package homework;
import java.util.Scanner;

public class AnimalGuessingGame 
{
	private static Scanner kbinput = new Scanner(System.in);

	public static void main(String[] args)
	{
		BtreeNode root;
		instruct();
		root = beginningTree();

		do
		{
			play(root);
		}
		while (query("Let's play the Animal Guessing Game!"));

		System.out.println("\nType 'Y' for 'Yes' or 'N' for 'No'.");
		root.print();
	}

	public static void instruct()
	{
		System.out.println("\nPlease think of an animal.");
		System.out.println("\nI will ask yes/no questions to try to figure");
		System.out.println("\nout what animal you are thinking of.");
	}

	public static void play(BtreeNode current)
	{
		while (!current.isLeaf())
		{
			if (query(current.getData()))
			{
				current = current.getRight();
			}

			else
			{
				current = current.getLeft();
			}
		}

		System.out.print("My guess is " + current.getData() + ". ");

		if (!query("Am I right?"))
		{
			learn(current);
		}

		else
		{
			System.out.println("Ha! I knew it!");
		}
	}

	public static BtreeNode beginningTree()
	{
		BtreeNode root;

		final String ROOT_QUESTION = "Is it big?";

		BtreeNode leaf1 = new BtreeNode("It is a dog.", null, null);
		BtreeNode leaf2 = new BtreeNode("It is a cat.", null, null);
		BtreeNode node1 = new BtreeNode("Does it meow?", leaf1, leaf2);
		BtreeNode leaf3 = new BtreeNode("It is a hamster.", null, null);
		BtreeNode leaf4 = new BtreeNode("It is a bird.", null, null);
		BtreeNode node2 = new BtreeNode("Does it chirp?", leaf3, leaf4);
		BtreeNode leaf5 = new BtreeNode("It is a bear.", null, null);
		BtreeNode leaf6 = new BtreeNode("It is a giraffe.", null, null);
		BtreeNode node3 = new BtreeNode("Does it have long neck?", leaf5, leaf6);
		BtreeNode leaf7 = new BtreeNode("It is a horse.", null, null);
		BtreeNode leaf8 = new BtreeNode("It is a cow.", null, null);
		BtreeNode node4 = new BtreeNode("Does is moo?", leaf7, leaf8);
		BtreeNode node5 = new BtreeNode("Does it live in a cage?", node1, node2);
		BtreeNode node6 = new BtreeNode("Does it eat grass?", node3, node4);

		root = new BtreeNode(ROOT_QUESTION, node5, node6);

		return root;
	}

	public static void learn(BtreeNode current)
	{
		String guessAnimal;
		String correctAnimal;
		String newQuestion;
		guessAnimal = current.getData();

		System.out.println("I give up. What are you? ");

		correctAnimal = kbinput.nextLine();

		System.out.println("Please type a yes/no question that will distinguish a");
		System.out.println(correctAnimal + " from a " + guessAnimal + " .");
		System.out.println("For example, you can type, 'Do you live on land?'");

		newQuestion = kbinput.nextLine();
		current.setData(newQuestion);

		System.out.println("As a " + correctAnimal + ", " + newQuestion);

		if (query("Please answer"))
		{
			current.setLeft(new BtreeNode(correctAnimal, null, null));
			current.setRight(new BtreeNode(guessAnimal, null, null));
		}
		
		else
		{
			current.setLeft(new BtreeNode(guessAnimal, null, null));
			current.setRight(new BtreeNode(correctAnimal, null, null));
		}
	}

	public static boolean query(String prompt)
	{
		String answer;

		System.out.print(prompt + " [Y or N]: ");

		answer = kbinput.nextLine().toUpperCase();

		while (!answer.startsWith("Y") && !answer.startsWith("N")) 
		{
			System.out.print("Invalid response. Please type Y or N: ");
			answer = kbinput.nextLine().toUpperCase();
		}

		return answer.startsWith("Y");
	}
}
