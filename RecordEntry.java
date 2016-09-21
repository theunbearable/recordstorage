import java.util.Scanner;

public class RecordEntry
{
	public static void main (String [] args)
	{
		RecordStorage record1 = new RecordStorage();
		
		boolean quitting = false;
		
		System.out.println("Welcome!");
		
		while(!quitting)
		{
			System.out.println("Enter Load, Create, ReadOne, ReadAll, Update, Delete, or Quit");
			
			Scanner in = new Scanner(System.in);
			
			String input = in.next();
			
			if (input.equals("Quit"))
			{
				record1.quit();
				quitting = true;
			}
			
			record1.inputHandler(input);
		}
	}
}