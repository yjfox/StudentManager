//********************************************************************
//  	studentList.java  	Based on Lewis / Loftus
// 	Opens the required files and adds new students
// 	Shell for Assignment 3
//********************************************************************

import java.io.*;
import java.util.*;

public class studentList
{
		//********************************************************************
		// Try-Catch Statement is used to handle exceptions - such as file not found 
		// Reading the files will need to be placed inside a Try-Catch - just like this one!
		// For more information see page 534 of the textbook
		//********************************************************************

	private String data,dataFirst,dataLast,dataMajor;
	private long dataID;
	private double dataFee;
    Scanner dataScan;
	studentEnrol studentList=new studentEnrol();
	
	public void readin(String file)
	{
		try
		{
			Scanner fileScan = new Scanner(new File(file));
		    // Read in the data from the file
			while(fileScan.hasNext())
			{
			    data=fileScan.nextLine();
				dataScan=new Scanner(data);
				dataScan.useDelimiter(";");
				while(dataScan.hasNext())
				{
					dataFirst=dataScan.next();
					dataLast=dataScan.next();
					dataID=dataScan.nextInt();
					dataMajor=dataScan.next();
					dataFee=dataScan.nextDouble();
					studentList.addStudent(dataFirst,dataLast,dataID,dataMajor,dataFee);
				}
			}
		    // Then close the file
			fileScan.close();
		}
		catch (Exception except) // Exception caught here and message displayed to the screen 
  		{
  	 	 	System.err.println(except);
   			System.out.println ("The Error occures when file opening!");   	
		}
	}
	
	public void addNewStudent(String stuFirst,String stuLast,long stuID,String stuMajor,double stuFee)
	{
		studentList.addStudent(stuFirst, stuLast, stuID, stuMajor, stuFee);
	}
	
	public void printStudentList()
	{
		studentList.sortStudent();
	    System.out.println(studentList);
	}
			

	
} // end of studentList class 
//-----------------------------------------------------------------
