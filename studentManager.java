//********************************************************************
//  	studentManager.java    Based on Lewis / Loftus
//	 	Student Record System Driver
// 	Driver shell for Assignment 3.
//********************************************************************

import java.io.*;
import java.util.*;

class studentManager
{
public static void main (String[] args) throws Exception
    {
	int flag=0,i=0,number;
	double stuFee;
	long studentID;
	String round="first";
	String firstName,lastName,stuMajor;
	String adminFirst,adminLast,adminUser,adminDepart;
	int adminPIN,passWord;
	String fileName=new String();
	String userName=new String();
	
	Scanner scan=new Scanner(System.in);
	//create a bufferedReader using system.in
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	studentList stuList=new studentList();
	
	userManager adminList=new userManager();
	
	while(flag!=1&&i<3)
	{
	System.out.println("Please enter your username and PIN");
	System.out.print("User name:");
	userName=br.readLine();
	System.out.print("User PIN:");
	passWord=scan.nextInt();
	if(userName.equals("yj")&&passWord==1234)
		flag=1;
	else
		System.out.println("User name or PIN is wrong. You have "+(2-i)+" chance to enter again.");
	i++;
	}
	while(flag==1)
	{
		System.out.println("Choose one function:");
		System.out.println("1: Enter the names of the two text files");
		System.out.println("2: Add a new student");
		System.out.println("3: Print a list of the students");
		System.out.println("4: Add a new authorised user");
		System.out.println("5: Exit the program");
		System.out.println("Type in your choosed number");
		number=scan.nextInt();
		switch(number)
		{
		case 1:
		{
			i=1;
			round="first";
			while(i<3)
			{
			System.out.println("Enter the "+round+" file's name");
			fileName=br.readLine();
			stuList.readin(fileName);
			round="second";
			i++;
			}
			System.out.println("Add data from two files successfully!");
			System.out.println("------------------------------------");
			System.out.println("Press anything continue");
			System.in.read();
			break;
		}
		case 2:
		{
			System.out.print("Enter student's first name:");
			firstName=scan.next();
			System.out.print("\nEnter student's last name:");
			lastName=scan.next();
			System.out.print("\nEnter student's ID:");
			studentID=scan.nextLong();
			System.out.print("\nEnter student's major:");
			stuMajor=scan.next();
			System.out.print("\nEnter student's fee payable:");
			stuFee=scan.nextDouble();
			stuList.addNewStudent(firstName,lastName,studentID,stuMajor,stuFee);
			System.out.println("Add student successfully!");
			System.out.println("------------------------------------");
			System.out.println("Press anything continue");
			System.in.read();
			break;
		}
		case 3:
		{
			stuList.printStudentList();
		    System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Press anything continue");
			System.in.read();
			break;
		}
		case 4:
		{
			System.out.print("Enter authorised user's first name:");
			adminFirst=scan.next();
			System.out.print("\nEnter authorised user's last name:");
			adminLast=scan.next();
			System.out.print("\nEnter authorised user's user name:");
			adminUser=scan.next();
			System.out.print("\nEnter authorised user's department:");
			adminDepart=scan.next();
			System.out.print("\nEnter authorised user's PIN:");
			adminPIN=scan.nextInt();
			adminList.addUser(adminFirst,adminLast,adminUser,adminDepart,adminPIN);
			System.out.println("Add authorised user successfully!");
			System.out.println("------------------------------------");
		    adminList.sortUsers();
		    System.out.print(adminList);
		    System.out.println("------------------------------------------------------------------------------------------");
			System.out.println("Press anything continue");
			System.in.read();
			break;
		}
		case 5:
		{
			String sure;
			System.out.print("Are you sure to exit? Y/N");
			sure=scan.next();
			if(sure.equalsIgnoreCase("y"))
			{
			    System.out.print("\nGood Bye!");
			    System.exit(0);
			}
			else 
			{
				System.out.println("------------------------------------");
				break;
			}
		}
		default:
		{
			System.out.println("Please do not enter other number besides 1-5.\nPress anything continue");
			System.in.read();
			break;
		}
		}
	}		
	}		
} // end of studentManager class
