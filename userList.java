//********************************************************************
//  userList.java  	Based on Lewis / Loftus 
// 	Represents facts about an Authorised Users
// 	Shell for Assignment 3
//********************************************************************

public class userList implements Comparable
{
	//-----------------------------------------------------------------
	// Constructor
	//-----------------------------------------------------------------
	
    private String adminFirst,adminLast,adminUser,adminDepart;
    private int adminPIN;
    
	public userList(String userFirst,String userLast,String userUser,String userDepart,int userPIN)
	{
		adminFirst=userFirst;
		adminLast=userLast;
		adminUser=userUser;
		adminDepart=userDepart;
		adminPIN=userPIN;
	}
	
	public String toString()
	{
		String adminDes;
		
		adminFirst+=getSpace(adminFirst.length(),1);
		adminLast+=getSpace(adminLast.length(),0);
		adminUser+=getSpace(adminUser.length(),0);
		adminDepart+=getSpace(adminDepart.length(),0);
		
		adminDes=adminFirst+adminLast+adminUser+adminDepart+adminPIN+"\n";
		
		return adminDes;
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
		return (adminLast.equals(((userList)other).getLastName())&&
				adminFirst.equals(((userList)other).getFirstName()));
	}
	public int compareTo(Object other)
	{
		int conclu;
		
		String otherFirst=((userList)other).getFirstName();
		String otherLast=((userList)other).getLastName();

		if(adminLast.equals(otherLast))
			conclu=adminFirst.compareTo(otherFirst);
		else
			conclu=adminLast.compareTo(otherLast);
		
		return conclu;
	}
	
	public String getFirstName()
	{
		return adminFirst;
	}
	
	public String getLastName()
	{
		return adminLast;
	}
	
	public String getUserName()
	{
		return adminUser;
	}
	
	public String getDepartment()
	{
		return adminDepart;
	}
	
	public int getPIN()
	{
		return adminPIN;
	}
	
	public boolean validatePIN(int passWord)
	{
		if(adminPIN==passWord)
			return true;
		else
			return false;
	}

} // end of class uerList
//-----------------------------------------------------------------
