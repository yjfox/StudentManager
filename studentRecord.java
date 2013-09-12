//********************************************************************
//	studentRecord.java		  Based on Lewis / Loftus
//  Represents facts about a Students
//  Shell for Assignment 3
//********************************************************************
import java.text.*;
import java.util.*;

public class studentRecord implements Comparable
{

	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	private String stuFirst,stuLast,stuMajor;
	private long stuID;
	private double stuFee;
	public studentRecord(String first,String last,long ID,String major,double fee)
	{
		stuFirst=first;
		stuLast=last;
		stuID=ID;
		stuMajor=major;
		stuFee=fee;
	}
	public String toString()
	{
		NumberFormat fmt=NumberFormat.getCurrencyInstance(Locale.US);
		
		String stuDes;
		
		stuFirst+=getSpace(stuFirst.length(),1);
		stuLast+=getSpace(stuLast.length(),0);
		stuMajor+=getSpace(stuMajor.length(),0);
		
		stuDes=stuFirst+stuLast+stuID+"        "+stuMajor+"     "+fmt.format(stuFee)+"\n";
		
		return stuDes;
	}
	public String getSpace(int strLen,int flag)
	{
		String Space="";
		if(flag==1)
		{
			for(int i=0;i<15-strLen;i++)
				Space+=" ";
		}
		else
		{			
			for(int i=0;i<20-strLen;i++)
			    Space+=" ";
		}
		return Space;
	}
	public boolean equals(Object other)
	{
		return (stuLast.equals(((studentRecord)other).getLastName())&&
				stuFirst.equals(((studentRecord)other).getFirstName()));
	}
	public int compareTo(Object other)
	{
		int conclu=0;
		
		String otherFirst=((studentRecord)other).getFirstName();
		String otherLast=((studentRecord)other).getLastName();
		
		if(stuLast.equals(otherLast))
			conclu=stuFirst.compareTo(otherFirst);
		else
			conclu=stuLast.compareTo(otherLast);
		
		return conclu;
	}
	public String getFirstName()
	{
		return stuFirst;
	}
	public String getLastName()
	{
		return stuLast;
	}
		
} // end of studentRecord class 
//-----------------------------------------------------------------
