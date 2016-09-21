import java.util.*;
import java.io.*;

public class RecordStorage
{
	ArrayList <String> record = new ArrayList <> ();
	boolean recordLoaded = false;
	
	void recordIsLoaded()
	{
		System.out.println("Record already loaded"); 
	}
	
	void loadChecker()
	{
		if(recordLoaded)
		{
			recordIsLoaded();
		}
		else
		{
			loadRecord();
		}
	}
	
	void loadRecord()
	{
		
		System.out.println("Loading record....");
		
		try
		{
                    try (Scanner loader = new Scanner(new File ("savedrecord.txt"))) {
                        while(loader.hasNext())
                        {
                            record.add(loader.next());
                        }
                    }
			recordLoaded = true;
			System.out.println("Success!");
		}
		catch(FileNotFoundException fnfe)
		{
			System.out.println("File not found");
		}
	}
	
	
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
		if(record.isEmpty())
		{
			System.out.println("Record is empty");
		}
		if (inputReadOne < record.size())
		{	
			System.out.println(inputReadOne);
		}
		if (inputReadOne > record.size())
		{	
			System.out.println("Invalid Record Number");
		}
	}
	
	void readAllRecords()
	{
		if(record.isEmpty())
		{
			System.out.println("Record is empty");
		}
		else
		{
            for (int i = 0; i < record.size(); i++)
			{
				System.out.println(i + " " + record.get(i));
			}
	
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
		
		if (inDelete.hasNextInt())
		{
			int inputDelete = inDelete.nextInt();
		
			if (inputDelete < record.size())
			{	
				record.remove(inputDelete);
			}
		}
		else
		{
			System.out.println("Enter a number between 0 and " + (record.size() - 1));
		}
		
	}
	
	void quit()
	{
		try 
		{
                    try (FileWriter fw = new FileWriter("savedrecord.txt")) {
						for (String aRecord : record) {
							fw.write(aRecord);
							fw.write(System.lineSeparator());
						}
                        fw.flush();
                    }
		}
		catch(IOException ignored)
		{
		}
	}
	
	void inputHandler(String action)
	{
		switch(action)
		{
			case "Load" : loadChecker();
				break;
			
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
				
			
		}
	}
}
