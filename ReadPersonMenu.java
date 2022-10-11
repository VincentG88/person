/*name:Vincent Goeijenbier
student number:L00170175*/
import java.io.*;
import java.util.*;

public class ReadPersonMenu
{
	public static void main(String []args) throws IOException, FileNotFoundException, ClassNotFoundException
	{
		Scanner keyboardIn = new Scanner(System.in);
		//Create objects to open file and read from it
		FileInputStream fis = new FileInputStream("personlist.txt");
		ObjectInputStream os = new ObjectInputStream(fis);
		//Read ArrayList from file
		ArrayList<Person>personList = (ArrayList<Person>) os.readObject();
		
		//Variables
		int option, pps;
		String occupation;
		
		//Menu system with switch statements
		do
		{
			System.out.println("1. View all Persons");
			System.out.println("2. View Person by PPS");
			System.out.println("3. View number of males and females on file");
			System.out.println("4. Calculate average age of persons on file");
			System.out.println("5. Search by occupation to create a new file");
			System.out.println("0. Exit System");
			option = keyboardIn.nextInt();
		switch(option)
 		{
			//Display all persons in ArrayList
			case 1:
    		System.out.println("Details of all persons: ");
    		viewAll(personList);
    		break;
    		//Search by PPS number
			case 2:
			System.out.println("Enter a PPS number: ");
			pps = keyboardIn.nextInt();
			viewPPS(personList, pps);
			break;
			//View males and females
			case 3:
			viewMales(personList);
			viewFemales(personList);
			break;
			//Calculate average age
			case 4:
			calcAverage(personList);
			break;
			//Search by occupation
			case 5:
			System.out.println("Enter an occupation: ");
			occupation = keyboardIn.next();
			searchOccupation(personList, occupation);
			break;
			//Message when user ends program			
			default:
			System.out.println("Goodbye");
		}//Close switch
		}while(option != 0);
	}//Close Main method
	
	//Method to view all persons in the file
	public static void viewAll(ArrayList<Person> personList) 
	{		
		for (int i=0; i <personList.size(); i++)
		{
			System.out.println(personList.get(i));
		}
	}
	
	//Method to view by PPS number
	public static void viewPPS(ArrayList<Person> personList, int pps)
	{	
		boolean isFound = false;
		for(int i = 0; i <personList.size(); i++)
		{
	   		if(pps == personList.get(i).getPps())
	   		{
	   			isFound = true;	
	   			System.out.println(personList.get(i));
	   			break;
	   		}
	   		else if(isFound = false) //(pps != personList.get(i).getPps())
	   		{
	   			System.out.println("No match found");
	   		}		
		}				
	}
	
	//Method to view males
	public static void viewMales(ArrayList<Person> personList)
	{
		int count=0;
		char male = 'm';
		for(int i=0; i< personList.size(); i++)
		{	
			if(male == personList.get(i).getGender().charAt(0))
				count++;
		}	
		System.out.println("Number of males: "+count);
	}
	//Method to view females
	public static void viewFemales(ArrayList<Person> personList)
	{
		int count=0;
		char female = 'f';
		for(int i=0; i<personList.size(); i++)
		{
			if(female == personList.get(i).getGender().charAt(0))
			{
				count++;
			}
		}
			System.out.println("Number of females: " + count);		
	}
		
	//Method to calculate the average age
	public static void calcAverage(ArrayList<Person> personList)
	{
		int total = 0;
		for(int i = 0; i<personList.size(); i++)
		    total = total+personList.get(i).getAge();
		int avg = total / personList.size();
		System.out.println("The Average age is:" + avg);	
	}
	
	//Method to search occupation
	public static void searchOccupation(ArrayList<Person> personList, String occupation) throws IOException
	{
		for(Person p : personList)
		{
		//Try catch InputMismatchException
		try {
			//Loop to find user input occupation match
			if (p.getOccupation().equals(occupation)) 
			{
				//Return result to the user
				System.out.println(p.toString());
				PrintWriter pw = new PrintWriter("Occupation.txt");
				//Writing user search result out to new file callled Occupation.txt
				pw.write(p.toString());
				pw.close();
				System.out.println("New file created");			
			}
			//Message to tell user if there is no match found 
			else 
			{
			System.out.println("No match found. File not created");
			}
			}//Close try
			catch(InputMismatchException  ex) 
			{
				System.out.println("Numeric values only, try again");			
				continue;
			} 			
		}	
	}
}//Close class
