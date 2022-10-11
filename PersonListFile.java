/*name:Vincent Goeijenbier
student number:L00170175*/

import java.io.*;
import java.util.*;

public class PersonListFile
{
	public static void main(String []args) throws IOException, FileNotFoundException, NumberFormatException
	{		
	Scanner keyboardIn = new Scanner(System.in);
	//Create ArrayList for person object
	ArrayList<Person> personList = new ArrayList<>();
	//Create objects to open and write to file
	FileOutputStream personFile = new FileOutputStream("personlist.txt");
	ObjectOutputStream person = new ObjectOutputStream(personFile);
  
	//Variables
	String name, gender, occupation;
	int pps=0, age = 0;
	double height=0, weight =0;
	char ans ='A';
	boolean done = false;
	//Loop to ask user for input while done is false. Checking user input for positive ints with do while loops.
	while(!done)
	{		
	//Try catch to handle InputMismatchException		
	try {					
		System.out.print("Enter name: ");
		name = keyboardIn.next();
		
		do
		{
		System.out.print("Enter age: ");
		age = keyboardIn.nextInt();
		}while(age<=0);
																				
		System.out.print("Enter gender: ");
		gender = keyboardIn.next().toLowerCase();
		
		do
		{
		System.out.print("Enter height: ");
		height = keyboardIn.nextDouble();
		}while(height<=0);
			
		do
		{
		System.out.print("Enter weight: ");
		weight = keyboardIn.nextDouble();
		}while(weight<=0);				

		System.out.print("Enter occupation: ");
		occupation = keyboardIn.next();				
		personList.add(new Person(name, age, gender, height, weight, occupation));
													
		System.out.print("Would you like to add another person (Y/N): ");
		ans = keyboardIn.next().charAt(0);
		//If user is finished with adding persons, write object to file and end program.
		if(ans == 'n' || ans =='N')
		{
			person.writeObject(personList);
		    done=true;							    
		}	
		} //Close try
		catch (InputMismatchException  ex) 
		{
			keyboardIn.nextLine();
			System.out.println("Numeric values only, try again");			
			continue;
		} 
	}//Close while loop
	//Letting the user know that the file has been created			
    System.out.println("File created");
    //Close output stream
    person.close();		
   }//Close Main method
}//Close class