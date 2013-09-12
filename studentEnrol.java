//********************************************************************
//	studentEnrol.java		  Based on Lewis / Loftus 
//  Manage Students
//  Shell for Assignment 3
//********************************************************************

import java.text.*;
import java.util.*;

public class studentEnrol
{
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	public studentRecord[] record;
	private int count;
	private double totalFee;
    final int MAX=100;
	public studentEnrol()
	{
		record=new studentRecord[MAX];
		count=0;
		totalFee=0.0;	
	}
	
	public void addStudent(String firstName,String lastName,long stuID,String stuMajor,double stuFee )
	{
		if(count==record.length)
			increaseSize();
		
		record[count]=new studentRecord(firstName,lastName,stuID,stuMajor,stuFee);
		totalFee+=stuFee;
		count++;
	}
	public void sortStudent()
	{
		studentRecord[] temp=new studentRecord[count];
		for(int i=0;i<count;i++)
			temp[i]=record[i];
		record=temp;
		listSort.insertionSort(record);
	}
	private void increaseSize()
	{
		studentRecord[] stutemp=new studentRecord[record.length*2];
		for(int i=0;i<record.length;i++)
			stutemp[i]=record[i];
		record=stutemp;
	}
	public String toString()
	{
		NumberFormat fmt=NumberFormat.getCurrencyInstance(Locale.US);
		
		String stuList="Students Number: "+count+"\n";
		stuList+="Total of fee payalbe: "+fmt.format(totalFee)+"\n";
		stuList+="Average fee payable: "+fmt.format(totalFee/count)+"\n";

		stuList+="\nFirt Name      Last Name           ID            Major                    Fee\n";
		stuList+="------------------------------------------------------------------------------------------\n";
		
		for(int i=0;i<count;i++)
			stuList+=record[i];
		
		return stuList;
	}
	
} // end of studentEnrol class 
//-----------------------------------------------------------------
