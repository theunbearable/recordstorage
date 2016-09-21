import java.util.*;

/**
 *
 * @author Kirsten Renee Sowers
 */
public class RecordStorage122915
{
	ArrayList <String> record = new ArrayList <> ();
	
	void createRecord()
	{
		System.out.println("Enter record to store: ");
		Scanner inCreate = new Scanner(System.in);
		String inputCreate = inCreate.next();
		record.add(inputCreate);
	}
	
	void readOneRecord()
	{
		System.out.println("Enter record to read: ");
		Scanner inReadOne = new Scanner(System.in);
		int inputReadOne = inReadOne.nextInt();
		if (inputReadOne < record.size())
		{	
			System.out.println(inputReadOne);
		}
	}
	
	void readAllRecords()
	{
		for (int i = 0; i < record.size(); i++)
			{
				System.out.println(i + " " + record.get(i));
			}
	}
	
		
	void updateRecord()
	{
		System.out.println("Enter record number followed by update: ");
		Scanner inUpdate = new Scanner(System.in);
		int inputUpdateNumber = inUpdate.nextInt();
		String inputUpdateData = inUpdate.next();
		if (inputUpdateNumber > record.size())
		{
			inputUpdateNumber = record.size();
			System.out.println("Record number corrected to " + inputUpdateNumber);
		}
		record.add(inputUpdateNumber, inputUpdateData);
	}
	
	void deleteRecord()
	{
		System.out.println("Enter record to delete: ");
		Scanner inDelete = new Scanner(System.in);
		int inputDelete = inDelete.nextInt();
		if (inputDelete < record.size())
		{	
			record.remove(inputDelete);
		}
		
	}
	
	void inputHandler(String action)
	{
		switch(action)
		{
			case "Create" : createRecord();
				break;
			
			case "ReadAll" : readAllRecords();
				break;
			
			case "ReadOne" : readOneRecord();
				break;
			
			case "Update" : updateRecord();
				break;
			
			case "Delete" : deleteRecord();
				break;
				
			default: //
				break;
		}
	}
}
	