/*Class to represent attributes of Person object
To be used for Assignment 2
  name:Vincent Goeijenbier
  student number:L00170175*/                  
import java.io.*;

public class Person implements Serializable
{
   //instance variables
	private int pps;
	private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String occupation;
    private static int nextPps = 100;
    //Constructors  
	public Person()
    {
        this.pps = 0;
	    this.name = "";
		this.age = 0;
		this.gender = "";
		this.height = 0;
		this.weight = 0;
		this.occupation = "";  
	}
		
	public Person(String name, int age, String gender, double height, double weight, String occupation)
	{
		this.pps = nextPps++;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.occupation = occupation;
	}	
	//Getters and Setters Methods
	public int getPps() {
		return pps;
	}
	public void setPps(int pps) {
		this.pps = pps;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	//toString method
	@Override
	public String toString() 
	{
		return "Person [pps=" + pps + ", name=" + name + ", age=" + age + ", gender=" + gender + ", height=" + height
				+ ", weight=" + weight + ", occupation=" + occupation + "]";
	}
}
